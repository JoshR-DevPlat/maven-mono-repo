package com.example.module1;

import com.example.module2.CollectionUtils;
import com.example.module2.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Main application entry point demonstrating the mono-repo structure.
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Starting Maven Mono-Repo Demo Application");

        // Demonstrate Module 2 StringUtils
        System.out.println("=== String Utilities (from Module 2) ===");
        System.out.println("Padded ID: " + StringUtils.padStart("42", 8, '0'));
        System.out.println("Is blank: " + StringUtils.isBlank("  "));
        System.out.println("Reversed: " + StringUtils.reverse("Hello"));
        System.out.println("Repeated: " + StringUtils.repeat("*", 5));

        // Demonstrate Module 2 CollectionUtils
        System.out.println("\n=== Collection Utilities (from Module 2) ===");
        List<String> items = CollectionUtils.immutableListOf("A", "B", "C", "D", "E");
        System.out.println("Immutable list: " + items);
        System.out.println("Partitioned: " + CollectionUtils.partition(items, 2));
        System.out.println("Reversed: " + CollectionUtils.reverse(items));

        // Demonstrate Module 1 UserService with Jackson
        System.out.println("\n=== User Service (Module 1 with Jackson) ===");
        UserService userService = new UserService();
        
        String userId = userService.createUserId("123");
        System.out.println("Created user ID: " + userId);

        User user = new User(userId, "John Doe", "john@example.com");
        String json = userService.toJson(user);
        System.out.println("User as JSON: " + json);

        User parsedUser = userService.fromJson(json);
        System.out.println("Parsed user: " + parsedUser);

        logger.info("Application completed successfully");
    }
}
