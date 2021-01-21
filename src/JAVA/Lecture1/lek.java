package JAVA.Lecture1;

import java.nio.charset.StandardCharsets;

public class lek {


    public static String stringToBinary(String s) {
        StringBuilder lars = new StringBuilder();
        for (char c: s.toCharArray()) {
            lars.append(Integer.toBinaryString(c));
        }
        return lars.toString();
    }

    public static String binaryToString(String s) {
        StringBuilder k = new StringBuilder();
        System.out.println(s.length());
        for (int i = 0; i < s.length(); i+=9) {
            String temp = s.substring(i,i+8);
            int num = Integer.parseInt(temp,2);
            char letter = (char) num;
            k.append(letter);
        }
        return k.toString();
    }

    /*
     int index = 0;
	String letters = "01001000 01100001 01110000 01110000 01111001 00100000 01000101 01100001 01110011 01110100 01100101 01110010 00100001";
	while(index < letters.length()) {
		String temp = letters.substring(index, index+8);
		Integer num = Integer.parseInt(temp,2);
		char letter =(char) (int)num;
		System.out.print(letter);
		index +=9;
	}
     */



    public static void main(String[] args) {
        System.out.println(stringToBinary("Kalle"));
        System.out.println(binaryToString(stringToBinary("Kalle")));

        String s = "10010111100001110110011011001100101";
        String temp = s.substring(0, 8);
        System.out.println(temp);
        int num = Integer.parseInt(temp, 2);
        System.out.println(num);
        System.out.println((char) num);

    }
}
