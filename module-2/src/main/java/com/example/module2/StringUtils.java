package com.example.module2;

import com.google.common.base.Strings;

/**
 * Utility class for string operations using Guava and Commons Lang.
 */
public class StringUtils {

    /**
     * Pads a string to the specified minimum length.
     * Uses Guava's Strings utility.
     */
    public static String padStart(String input, int minLength, char padChar) {
        return Strings.padStart(input, minLength, padChar);
    }

    /**
     * Checks if a string is blank (null, empty, or whitespace only).
     * Uses Apache Commons Lang.
     */
    public static boolean isBlank(String input) {
        return org.apache.commons.lang3.StringUtils.isBlank(input);
    }

    /**
     * Reverses a string.
     * Uses Apache Commons Lang.
     */
    public static String reverse(String input) {
        return org.apache.commons.lang3.StringUtils.reverse(input);
    }

    /**
     * Repeats a string n times.
     * Uses Guava's Strings utility.
     */
    public static String repeat(String input, int count) {
        return Strings.repeat(input, count);
    }
}
