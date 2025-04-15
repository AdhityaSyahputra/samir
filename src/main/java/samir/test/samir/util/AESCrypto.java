package samir.test.samir.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AESCrypto {

    private static String MASTER_KEY = "secretKey";
    private static final String ALG = "AES/ECB/PKCS5PADDING";
    private static final String ALGSEC = "AES";


    public static String encrypt(String value) throws Exception {
        return encrypt(value, MASTER_KEY);
    }

    public static String decrypt(String value) throws Exception {
        return decrypt(value, MASTER_KEY);
    }

    public static String encrypt(String value, String key) throws Exception {
        if (value == null || value.isEmpty()) return "";
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGSEC);

        Cipher cipher = Cipher.getInstance(ALG);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encrypted, String key) throws Exception {
        if (encrypted == null || encrypted.isEmpty()) return "";
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGSEC);

        Cipher cipher = Cipher.getInstance(ALG);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

        return new String(original);

    }

}
