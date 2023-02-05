package kz.dara.cameralcontrol.config;

import kz.dara.cameralcontrol.util.PasswordHelper;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return  PasswordHelper.generateSecurePassword(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return PasswordHelper.verifyUserPassword(rawPassword.toString(), encodedPassword);
    }
}
