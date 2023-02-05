package kz.dara.cameralcontrol.util;

import javax.persistence.*;

public class BooleanToCharacterConverter implements AttributeConverter<Boolean,Character> {

    public static final Character Y = 'Y';
    public static final Character Y_LOWER = 'y';
    public static final Character N = 'N';

    @Override
    public Character convertToDatabaseColumn(Boolean aBoolean) {
        if (aBoolean == null) {return null;}
        return aBoolean? Y : N;
    }

    @Override
    public Boolean convertToEntityAttribute(Character character) {
        if (character == null) {return null;}  //NOSONAR
        return Y.equals(character) || Y_LOWER.equals(character);
    }
}
