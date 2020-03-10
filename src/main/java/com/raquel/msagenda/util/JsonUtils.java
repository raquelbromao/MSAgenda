package com.raquel.msagenda.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String objectToJson(Object object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            logger.error("Não foi possível converter o objeto em json: " + exception.getMessage(), exception);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
