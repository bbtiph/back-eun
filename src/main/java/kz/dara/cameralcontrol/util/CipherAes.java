package kz.dara.cameralcontrol.util;


import com.google.common.base.*;
import org.apache.commons.lang3.StringUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CipherAes {
    private static final String CONST_DEFAULT_AES_ENCRYPTION_KEY = "W36z0RDMmBfhuoc5";
    private static final String CONST_ENCRYPTION_TYPE = "AES";
    private static final String CONST_ENCRYPTION_TRANSFORMER = "AES/CBC/PKCS5Padding";
    private static final String CONST_ENCRYPTION_PREFIX = "CpHr1";

    public static String cipherEncrypt(String value) {
        if (value == null){
            return null;
        }
        if (value.startsWith(CONST_ENCRYPTION_PREFIX)){
            return value;
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(CONST_DEFAULT_AES_ENCRYPTION_KEY.getBytes(Charsets.UTF_8), CONST_ENCRYPTION_TYPE);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(CONST_DEFAULT_AES_ENCRYPTION_KEY.getBytes(Charsets.UTF_8));
                Cipher cipher = Cipher.getInstance(CONST_ENCRYPTION_TRANSFORMER);
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
                byte[] encrypted = cipher.doFinal(value.getBytes(Charsets.UTF_8));
                String ev = new String(Base64.getEncoder().encode(encrypted), Charsets.UTF_8);
                ev = CONST_ENCRYPTION_PREFIX + ev;
                return ev;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String cipherDecrypt(String value) {
        if (value == null){
            return null;
        }
        if (!value.startsWith(CONST_ENCRYPTION_PREFIX)){
            return value;
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(CONST_DEFAULT_AES_ENCRYPTION_KEY.getBytes(Charsets.UTF_8), CONST_ENCRYPTION_TYPE);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(CONST_DEFAULT_AES_ENCRYPTION_KEY.getBytes(Charsets.UTF_8));
                Cipher cipher = Cipher.getInstance(CONST_ENCRYPTION_TRANSFORMER);
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

                String ev = StringUtils.substringAfter(value, CONST_ENCRYPTION_PREFIX);

                byte[] decodedValue = Base64.getDecoder().decode(ev);
                byte[] decryptedValue = cipher.doFinal(decodedValue);

                ev = new String(decryptedValue, Charsets.UTF_8);
                return ev;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
