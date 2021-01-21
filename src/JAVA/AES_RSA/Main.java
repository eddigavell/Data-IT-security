package JAVA.AES_RSA;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {

    public static void main(String[] args) {
        String path = "src/JAVA/AES_RSA/Crypto/";
        try {
            AES aes = new AES();
            IvParameterSpec iv = aes.generateIV();
            aes.saveIV("myiv.iv", iv);
            SecretKeySpec skey = aes.keyFromPassphrase("s3cr37passw0RD");
            aes.encrypt("JAG VILL HA LUNCH NUUUUUU", path + "crypto3.enc", skey, iv);

            String result = aes.decrypt(path + "crypto3.enc", skey, iv);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
