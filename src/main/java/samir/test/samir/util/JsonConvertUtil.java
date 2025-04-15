package samir.test.samir.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConvertUtil {

    public static <T> T fromObject(Object object, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String itemString = null;

        JsonProcessingException e;
        try {
            itemString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException var7) {
            e = var7;
            e.printStackTrace();
        }

        try {
            return objectMapper.readValue(itemString, clazz);
        } catch (JsonProcessingException var5) {
            e = var5;
            e.printStackTrace();
        }

        return null;
    }
}
