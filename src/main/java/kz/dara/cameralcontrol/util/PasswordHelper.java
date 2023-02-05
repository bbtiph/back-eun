package kz.dara.cameralcontrol.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public final class PasswordHelper {

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String PASSWORD_SALT = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";

    public static String generateSecurePassword(String password) {
        byte[] securePassword = hash(password.toCharArray());
        return Base64.getEncoder().encodeToString(securePassword);
    }

    private static byte[] hash(char[] password) {
        PBEKeySpec spec = new PBEKeySpec(password, PASSWORD_SALT.getBytes(), ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static boolean verifyUserPassword(String providedPassword, String securedPassword) {
        String newSecurePassword = generateSecurePassword(providedPassword);
        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }
}
