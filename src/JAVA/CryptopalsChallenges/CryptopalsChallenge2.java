package JAVA.CryptopalsChallenges;

public class CryptopalsChallenge2 {

    CryptopalsChallenge2() {
        doSomething();
    }

    void doSomething() {
        String feedString = "1c0111001f010100061a024b53535009181c";
        String xorString = "686974207468652062756c6c277320657965";
        String rightResult = "746865206b696420646f6e277420706c6179";
        // after hex decoding and when XOR'd against:

        //Dehex feedstring
        byte[] a = hexStringToByteArray(feedString);
        String dehexFeedString = new String(a);
        System.out.println("Dehex feedstring: " + dehexFeedString);

        //Dehex xorString
        byte[] b = hexStringToByteArray(xorString);
        String dehexXORString = new String(b);
        System.out.println("Dehex xorString: " + dehexXORString);

        //XOR on dehexed stuffs
        byte[] k = dehexFeedString.getBytes();
        byte[] n = dehexXORString.getBytes();

        StringBuilder resultSB = new StringBuilder();
        for (int i = 0; i < k.length; i++) {
            resultSB.append((char) (k[i] ^ n[i]));
        }
        String result = resultSB.toString();
        System.out.println("dehexed Result: " + result);

        //Result in string, need to convert to Hex
        byte[] x = result.getBytes();
        String kanDetVaraRatt = bytesToHex(x);
        System.out.println("Hex result: " + kanDetVaraRatt.toLowerCase());
        System.out.println("Right answer: " + rightResult);

        if (rightResult.equals(kanDetVaraRatt.toLowerCase())) {
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
        new CryptopalsChallenge2();
    }
}