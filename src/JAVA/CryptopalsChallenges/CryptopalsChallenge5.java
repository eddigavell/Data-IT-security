package JAVA.CryptopalsChallenges;

public class CryptopalsChallenge5 {

    CryptopalsChallenge5() {
        asd2();
    }

    void instruction() {
        /*
        Implement repeating-key XOR
        Here is the opening stanza of an important work of the English language:

        Burning 'em, if you ain't quick and nimble
        I go crazy when I hear a cymbal

        Encrypt it, under the key "ICE", using repeating-key XOR.

        In repeating-key XOR, you'll sequentially apply each byte of the key;
        the first byte of plaintext will be XOR'd against I, the next C, the next E,
        then I again for the 4th byte, and so on.

        It should come out to:
        0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272
        a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f

        Encrypt a bunch of stuff using your repeating-key XOR function. Encrypt your mail. Encrypt your password file.
        Your .sig file. Get a feel for it. I promise, we aren't wasting your time with this.
         */
    }

    void asd2() {
        String feedString1 = "Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal";
        String key="ICE";

        byte[] feed1 = feedString1.getBytes();

        int i = 0;
        StringBuilder resultSB1 = new StringBuilder();
        for(byte x: feed1) {
            resultSB1.append((char) (x ^ key.charAt(i++)));
            if (i == 3) {
                i = 0;
            }
        }

        String rightAnswer1 = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272";
        String rightAnswer2 = "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f";
        String rightAnswer = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f";

        byte[] a = resultSB1.toString().getBytes();
        String result = bytesToHex(a).toLowerCase();
        System.out.println(result + " : " + result.length());
        String string1 = result.substring(0,75);
        String string2 = result.substring(75, 148);

        if (result.equals(rightAnswer)) {
            System.out.println("Answer: correct");
        } else {
            System.out.println("Answer: incorrect");
            System.out.println(rightAnswer);
            System.out.println(result);
            System.out.println("-----");
        }

        if (string1.equals(rightAnswer1)) {
            System.out.println("Answer1: correct");
        } else {
            System.out.println("Answer1: incorrect");
            System.out.println(rightAnswer1);
            System.out.println(string1);
            System.out.println("-----");
        }

        if (string2.equals(rightAnswer2)) {
            System.out.println("Answer2: correct");
        } else {
            System.out.println("Answer2: incorrect");
            System.out.println(rightAnswer2);
            System.out.println(string2);
            System.out.println("-----");
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

    public static void main(String[] args) {
        new CryptopalsChallenge5();
    }
}