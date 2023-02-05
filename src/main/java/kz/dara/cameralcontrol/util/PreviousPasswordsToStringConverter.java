package kz.dara.cameralcontrol.util;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import javax.persistence.*;
import java.io.*;
import java.util.*;

public class PreviousPasswordsToStringConverter implements AttributeConverter<List<String>, String> {
    private final ObjectMapper attributeConverterObjectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(final List<String> attribute) {
        try {
            return attributeConverterObjectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
           e.printStackTrace();
           return null;
        }
    }

    @Override
    public List<String> convertToEntityAttribute(final String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return attributeConverterObjectMapper.readValue(
                    dbData,
                    attributeConverterObjectMapper.getTypeFactory().constructCollectionType(LinkedList.class, String.class)
            );
        } catch (final IOException e) {
              e.printStackTrace();
            return null;
        }
    }
}
