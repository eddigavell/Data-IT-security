package Lecture1;

import java.util.Base64;

public class Lecture1 {

    Lecture1() {
        //base64("This is a message");
        //logicOperation();
        byte[] values = {68, 4, 72};
        System.out.println("String bytesToHex: " + bytesToHex(values));
        System.out.println("Hex to byte: " +  hexStringToByteArray(bytesToHex(values)));;
    }

    void base64(String msg) {
        System.out.println("----- Base64 -----");
        // Base64 encoding
        String encodedString = Base64.getEncoder().encodeToString(msg.getBytes());
        System.out.println("Encoded message: " + encodedString);

        // Base64 decode
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded message: " + decodedString);
    }

    void logicOperation() {
        // Bitvis logisk operation
        System.out.println("----- Logical Operations -----");
        // xor
        byte letter = (byte) 'A';
        byte key = (byte) 'K';
        int cipher = letter ^ key;
        System.out.println("Cipher: " + cipher);
        int clear_letter = cipher ^ key;
        System.out.println("Deciphered: " + (char) clear_letter);
        // bitwise and
        int andValue = 197;
        int result128 = andValue & 128;
        int result64 = andValue & 64;
        int result32 = andValue & 32;
        int result16 = andValue & 16;
        int result8 = andValue & 8;
        int result4 = andValue & 4;
        int result2 = andValue & 2;
        int result1 = andValue & 1;
        System.out.println(result128);
        System.out.println(result64);
        System.out.println(result32);
        System.out.println(result16);
        System.out.println(result8);
        System.out.println(result4);
        System.out.println(result2);
        System.out.println(result1);

        // bitwise shift
        for (int i = 7; i >= 0; i--) {
            int bit = andValue >> i;
            if(i == 3) {
                System.out.print(" ");
            }
            System.out.print(bit & 1);
        }
    }

    String bytesToHex(byte[] bytes) {
        //[68, 4, 72] => ['4', '4', '0', '4', '4', '8'] => "440448"
        char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int value = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[value >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[value & 0x0F];
        }
        return new String(hexChars);
    }

    byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if (len % 2 != 0) {

        }
        return ;
    }

    public static void main(String[] args) {
        new Lecture1();
    }
}
