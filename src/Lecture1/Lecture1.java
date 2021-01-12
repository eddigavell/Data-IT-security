package Lecture1;

import java.util.Base64;

public class Lecture1 {
    public static void main(String[] args) {
        //Base64 encoding
        String originalString = "This is a message";
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println(encodedString);

        //Base64 decode
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString);
    }
}
