package com.example.eventmanagement.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    // Method to hash the password using SHA-256
    public static String hashPassword(String password) {
        try {
            // MessageDigest instance for hashing using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Perform the hashing on the password bytes
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                // Convert each byte to a hex string
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    // Append leading zero if the hex string is a single character
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // Return the complete hashed password as a hex string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where SHA-256 algorithm is not available
            throw new RuntimeException(e);
        }
    }
}
