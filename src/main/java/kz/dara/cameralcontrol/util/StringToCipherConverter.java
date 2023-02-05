package kz.dara.cameralcontrol.util;

import javax.persistence.*;

public final class StringToCipherConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        if (s == null) {
            return null;
        }
        return CipherAes.cipherEncrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return CipherAes.cipherDecrypt(s);
    }
}
