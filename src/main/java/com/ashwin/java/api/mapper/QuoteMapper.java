package com.ashwin.java.api.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuoteMapper {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        //objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        //objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public static <T extends Object> T fromJson(String json, Class<T> classz) throws Exception {
        return objectMapper.readValue(json, classz);
    }
}
