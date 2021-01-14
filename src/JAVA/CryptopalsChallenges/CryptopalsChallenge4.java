package JAVA.CryptopalsChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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

        int q = 0;
        String[] asd = new String[327];
        while (sc.hasNextLine()) {
            asd[q++] = sc.nextLine();
        }
        sc.close();

        HashMap<Integer, String> highScore = new HashMap<>();
        int highestScore = 0;


        for(String s: asd) {
            StringBuilder result = new StringBuilder();
            byte[] dehexFeedString = hexStringToByteArray(s); // dehexar

            for (byte b : dehexFeedString) { //From ascii to characters
                result.append((char) b);
            }

            for(int i = 0; i < 256; i++) {
                StringBuilder kalle = new StringBuilder();
                char x = (char) i; //Generates char from ASCII number

                for(int j = 0; j < result.length(); j++) {
                    kalle.append((char) (result.charAt(j) ^ x));
                }
                kalle.append(x); //lägger på vilken bokstav det kmr ifrån

                String res1 = kalle.toString();

                int score = checkValueFromString(res1);

                highScore.put(score, res1);

                if (score >= highestScore) {
                    highestScore = score;
                }
            }
        }
        System.out.println(highScore.get(highestScore)); // 5an kmr ifrån denna strängen.... tar man en substring -1 så försvinner den
        System.out.println("Score: " + highestScore);
    }

    int checkValueFromString(String s) {
        int score = 0;
        for(int i = 0; i < s.length(); i++) {
            byte x = (byte) (s.charAt(i));
            if (x > 97 && x < 122 || x == 32) {
                score++;
            }
        }
        return score;
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
