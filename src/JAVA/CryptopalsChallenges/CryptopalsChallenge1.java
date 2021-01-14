package JAVA.CryptopalsChallenges;

import java.util.Base64;

public class CryptopalsChallenge1 {

    CryptopalsChallenge1() {
        doSomething();
    }

    void doSomething() {
        String startString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        String answer = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";

        byte[] a = hexStringToByteArray(startString);

        StringBuilder fromASCIITOCHARStartString = new StringBuilder();
        for(byte x: a) {
            fromASCIITOCHARStartString.append((char) x);
        }
        String dehexStartString = fromASCIITOCHARStartString.toString();
        System.out.println("Message: " + dehexStartString);

        String result = base64Encode(dehexStartString);

        System.out.println(result);
        System.out.println(answer);

        if (result.equals(answer)) {
            System.out.println("Yay, det stämmer ju... fan va du är duktig");
        } else {
            System.out.println("Fan håller du på med? Det är fel...");
        }
    }

    byte[] hexStringToByteArray(String s) {
        int len = s.length();
        // This only works with an even number of characters.
        // If len is odd, append a 0 at the start of number.
        if (len % 2 != 0) {
            s = "0" + s;
            len++;
        }

        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1),16 ));
        }

        return data;
    }

    String base64Encode(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    public static void main(String[] args) {
        new CryptopalsChallenge1();
    }
}