package JAVA.Lecture2;

import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    RSA() {
        String fileName = "src/JAVA/Lecture2/Kalle";

        generateKeys(fileName,2048); //Generate keys
        KeyPair publicKey = readKey(fileName + "_pub.key"); //Reads in publicKey
        KeyPair privateKey = readKey(fileName + "_priv.key"); //Reads in privKey

        String msgToEncrypt = "Betala annars dör du";
        String encrypted = encryptMessage(msgToEncrypt, publicKey);
        String decrypted = decryptMessage(encrypted, privateKey);

        System.out.println(encrypted);
        System.out.println(decrypted);
    }

    void generateKeys(String fileName, int bitLength) {
        SecureRandom rand = new SecureRandom();
        BigInteger p = new BigInteger(bitLength / 2, 100, rand);
        BigInteger q = new BigInteger(bitLength / 2, 100, rand);
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("3");
        while (phiN.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        BigInteger d = e.modInverse(phiN);
        KeyPair publicKey = new KeyPair(e, n);
        KeyPair privateKey = new KeyPair(d, n);
        saveKey(fileName + "_pub.key", publicKey);
        saveKey(fileName + "_priv.key", privateKey);
    }

    void saveKey(String fileName, KeyPair key) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(key);
            out.close();
            System.out.println("Saved key as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    KeyPair readKey(String fileName) {
        KeyPair key = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            key = (KeyPair) in.readObject();
            in.close();
            System.out.println("Read key from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return key;
    }

    String encryptMessage(String s, KeyPair key) {
        // m^e mod n = c
        // BigInteger msg = new BigInteger(s.getBytes());
        // return msg.modPow(key.getKey(), key.getN()).toString();
        return (new BigInteger(s.getBytes())).modPow(key.getKey(), key.getN()).toString();
    }

    String decryptMessage(String s, KeyPair key) {
        //Bugg ÅÄÖ först buggar ur.
        return new String((new BigInteger(s)).modPow(key.getKey(),key.getN()).toByteArray());
    }

    void sign() {
        String toSign = "ABC123";
        BigInteger toSignBI = new BigInteger(toSign.getBytes());

        //Signering
        //String signC = toSignBI.modPow(d, n).toString();

        //String clearSign = new String((new BigInteger(signC).modPow(e, n)).toByteArray());
        //System.out.println(clearSign);
    }

    public static void main(String[] args) {
        new RSA();
    }
}
