package JAVA.CryptopalsChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CryptopalsChallenge4 {

    CryptopalsChallenge4(){
        try {
            yay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void yay() throws FileNotFoundException {
        /* One of the 60-character strings in this file has been encrypted by single-character XOR.
        Find it.
        (Your code from #3 should help.) */
        File file = new File("src/Python/CryptoChallenge/Challenge4.txt");
        Scanner sc = new Scanner(file);

        int i = 0;
        String[] asd = new String[327];
        while (sc.hasNextLine()) {
            asd[i++] = sc.nextLine();
        }
        sc.close();

        for(String s: asd) {
            System.out.println(s);
        }

        System.out.println("Inte löst..... <.<");
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

    public static void main(String[] args) {
        new CryptopalsChallenge4();
    }
}
