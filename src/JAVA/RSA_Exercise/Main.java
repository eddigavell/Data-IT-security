package JAVA.RSA_Exercise;

import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private final String pathForKeys = "src/JAVA/RSA_Exercise/Keys/";
    private final String pathForMessages = "src/JAVA/RSA_Exercise/Messages/";
    private KeyPair publicKey;
    private KeyPair privateKey;

    Main() {
        String fileName = "gustav";

        //generateKeys(fileName);
        publicKey = readKey(fileName, "public");
        privateKey = readKey(fileName, "private");

        System.out.println("-----private-----");
        System.out.println(decryptTextFile("EncryptedMsggustav", privateKey));

        //encryptMessageToTextFile("HEJSVEJS", publicKey, fileName);
    }

    /*
        [65, 66, 67]
        65^e mod n => nn
        66^e mod n => oo
        67^e mod n => pp
        656667^e mod n => 1234566
        1234566^d mod n => 656667
        656667 => string => ABC
     */

    private void generateKeys(String fileName, int bitLength) {
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
        publicKey = new KeyPair(e, n);
        privateKey = new KeyPair(d, n);
        saveKey(pathForKeys + fileName + "_pub.key", publicKey);
        saveKey(pathForKeys + fileName + "_priv.key", privateKey);
    }

    private void generateKeys(String fileName) {
        generateKeys(fileName, 2048);
    }

    private void saveKey(String filePath, KeyPair key) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(key);
            out.close();
            System.out.println("Saved key as " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private KeyPair readKey(String fileName, String type) {
        String fileExtension;
        if (type.equals("private")) {
            fileExtension = "_priv.key";
        } else {
            fileExtension = "_pub.key";
        }
        String filePath = pathForKeys + fileName + fileExtension;
        KeyPair key = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            key = (KeyPair) in.readObject();
            in.close();
            System.out.println("Read key from " + fileName + fileExtension);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String encryptMessage(String s, KeyPair key) {
        // m^e mod n = c
        return (new BigInteger(s.getBytes())).modPow(key.getKey(), key.getN()).toString();
    }

    public void encryptMessageToTextFile(String s, KeyPair key, String fileName) {
        String encrypted_message = encryptMessage(s, key);
        try {
            FileWriter fw = new FileWriter(pathForMessages+"EncryptedMsg" + fileName + ".txt");
            fw.write(encrypted_message);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String decryptMessage(String s, KeyPair key) {
        if (s.equals("")) {
            return "tomt meddelande....";
        }
        //Bugg ÅÄÖ först buggar ur.
        return new String((new BigInteger(s)).modPow(key.getKey(),key.getN()).toByteArray());
    }

    public String decryptTextFile(String fileName, KeyPair key) {
        if (!fileName.contains(".txt")) {
            fileName = fileName + ".txt";
        }

        String filePath = pathForMessages + fileName;
        StringBuilder s = new StringBuilder();
        try {
            Scanner sc = new Scanner(new File(filePath));
            while(sc.hasNextLine()) {
                s.append(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
        System.out.println("Message read from file " + fileName);
        return decryptMessage(s.toString(), key);
    }

    public static void main(String[] args) {
        new Main();
    }
}
