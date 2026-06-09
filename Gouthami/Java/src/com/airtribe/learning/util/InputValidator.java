package com.airtribe.learning.util;

public class InputValidator {
    // Validate integer input
    public static int validateInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format. Please enter a valid number.");
        }
    }

    // Validate non-empty string
    public static String validateString(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return input.trim();
    }

    // Validate status (used for enrollment status)
    public static boolean isValidStatus(String status) {
        return status.equalsIgnoreCase("ACTIVE")
                || status.equalsIgnoreCase("COMPLETED")
                || status.equalsIgnoreCase("CANCELLED");
    }
}
