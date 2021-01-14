package JAVA.CryptopalsChallenges;

public class CryptopalsChallenge3 {

    CryptopalsChallenge3() {
        gustavs();
    }

    void gustavs() {
        String feedString = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        String xorStringTest;
        byte[] deHexedFeedString = hexStringToByteArray(feedString);
        StringBuilder resultFeedString = new StringBuilder();
        for (byte b : deHexedFeedString) {
            resultFeedString.append((char) b);
        }
        System.out.println(resultFeedString);
        byte[] d = resultFeedString.toString().getBytes();
        for (char t = 'a'; t < 'z'; t++) { //Loopar igenom alfabetet och kollar vilken char vi kan Xor:a mot för att få en träff.
            xorStringTest = generateTestCharacterToXoRAgainst(t);
            System.out.println(xorStringTest);
            byte[] l = xorStringTest.getBytes();
            int clearLetter;
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < d.length; i++) {
                byte letter = d[i];
                byte key = l[i];
                clearLetter = letter ^ key;
                resultString.append((char) clearLetter);
            }
            System.out.println(resultString);
        }
    }

    String generateTestCharacterToXoRAgainst(Character t) {
        String s = "";
        return (s + String.valueOf(t).repeat(35)).toUpperCase();
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
        new CryptopalsChallenge3();
    }
}