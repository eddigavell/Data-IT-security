package JAVA.AES_RSA;


import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;


public class AES {
    IvParameterSpec generateIV() {
        byte[] iv = new byte[128 / 8];
        SecureRandom srandom = new SecureRandom();
        srandom.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    void saveIV(String ivFileName, IvParameterSpec iv) throws IOException {
        FileOutputStream out = new FileOutputStream(ivFileName);
        out.write(iv.getIV());
        out.close();
    }

    IvParameterSpec readIV(String ivFileName) throws IOException {
        byte[] iv = Files.readAllBytes(Paths.get(ivFileName));
        return new IvParameterSpec(iv);
    }

    SecretKeySpec generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        return new SecretKeySpec(keygen.generateKey().getEncoded(), "AES");
    }

    SecretKeySpec keyFromPassphrase(String passphrase) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = "1234567890ABC".getBytes();
        int iterationCount = 1024;
        int keyStrength = 256;
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, iterationCount, keyStrength);
        SecretKey key = factory.generateSecret(spec);
        return new SecretKeySpec(key.getEncoded(), "AES");
    }

    void encrypt(String plainText, String outFile, SecretKeySpec skey, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skey, iv);

        FileOutputStream out = new FileOutputStream(outFile);
        byte[] input = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] cipherOutput = cipher.doFinal(input);
        out.write(cipherOutput);
        out.close();
    }

    String decrypt(String inFile, SecretKeySpec skey, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skey, iv);
        byte[] cipherInput = Files.readAllBytes(Paths.get(inFile));
        return new String(cipher.doFinal(cipherInput), StandardCharsets.UTF_8);
    }
}
