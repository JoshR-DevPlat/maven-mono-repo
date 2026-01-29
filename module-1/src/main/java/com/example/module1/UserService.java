package com.example.module1;

import com.example.module2.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for user operations.
 * Demonstrates usage of Module 2 utilities along with Jackson and SLF4J.
 */
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final ObjectMapper objectMapper;

    public UserService() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Creates a formatted user ID by padding the input.
     * Uses StringUtils from module-2.
     */
    public String createUserId(String input) {
        logger.info("Creating user ID from input: {}", input);
        
        if (StringUtils.isBlank(input)) {
            logger.warn("Input is blank, using default ID");
            return StringUtils.padStart("0", 8, '0');
        }
        
        return StringUtils.padStart(input, 8, '0');
    }

    /**
     * Converts a User object to JSON string.
     * Uses Jackson ObjectMapper.
     */
    public String toJson(User user) {
        try {
            logger.debug("Converting user to JSON: {}", user.getName());
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert user to JSON", e);
            throw new RuntimeException("JSON serialization failed", e);
        }
    }

    /**
     * Parses a JSON string into a User object.
     */
    public User fromJson(String json) {
        try {
            logger.debug("Parsing user from JSON");
            return objectMapper.readValue(json, User.class);
        } catch (JsonProcessingException e) {
            logger.error("Failed to parse user from JSON", e);
            throw new RuntimeException("JSON deserialization failed", e);
        }
    }
}
