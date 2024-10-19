package com.junia.tailorshop.utils;

import com.junia.tailorshop.enums.ColorsEnum;
import com.junia.tailorshop.enums.ItemEnum;
import com.junia.tailorshop.enums.MaterialEnum;
import com.junia.tailorshop.enums.SizeEnum;
import com.junia.tailorshop.people.Customer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Utils class provides utility functions used throughout the tailor shop application.
 * These functions include validation checks for customer information, such as phone numbers
 * and names, as well as methods for inputting and validating clothing attributes like 
 * item type, size, material, and color. It also includes methods for printing messages 
 * to the console and retrieving the current hour.
 */
public class Utils {
    
    // Welcoming functions

    /**
     * Validates the phone number input from the customer.
     * The method prompts the user until a valid phone number format is provided.
     *
     * @param customer The Customer object to update with the validated phone number.
     * @param scanner  The Scanner object for reading user input.
     */
    public static void numberCheck(Customer customer, Scanner scanner) {
        boolean valid = false;
        // Regex pattern for validating French phone numbers starting with 06 or 07 and followed by 8 digits.
        String phoneRegex = "^(06|07)\\d{8}$"; 
        Pattern pattern = Pattern.compile(phoneRegex);
        
        while (!valid) {
            String phoneNumber = scanner.nextLine();
            Matcher matcher = pattern.matcher(phoneNumber);
            
            if (matcher.matches()) {
                customer.setContactInfo(phoneNumber);
                valid = true;
            } else {
                println("Erreur : Numéro de téléphone invalide. Veuillez réessayer. (format : 06xxxxxxxx ou 07xxxxxxxx) :");
            }
        }
    }

    /**
     * Validates the name input from the customer.
     * The method prompts the user until a valid name format is provided.
     *
     * @param customer The Customer object to update with the validated name.
     * @param scanner  The Scanner object for reading user input.
     */
    public static void nameCheck(Customer customer, Scanner scanner) {
        boolean valid = false;
        // Regex pattern for validating names, allowing letters, spaces, hyphens, and apostrophes.
        String nameRegex = "^[a-zA-Z][a-zA-Z]*(?:[\\s'-][A-Za-z][a-zA-Z]*)*$"; 
        Pattern pattern = Pattern.compile(nameRegex);

        while (!valid) {
            String name = scanner.nextLine();
            Matcher matcher = pattern.matcher(name);
            
            if (matcher.matches()) {
                customer.setName(name);
                valid = true;
            } else {
                println("Erreur : Name format not valid. please try again :");
            }
        }
    }

    /**
     * Prompts the user to choose an item type for their order.
     * The method validates the input against allowed item types.
     *
     * @param scanner The Scanner object for reading user input.
     * @return The validated ItemEnum corresponding to the chosen item type.
     */
    public static ItemEnum clothesCheck(Scanner scanner) {
        boolean correct = false;
        String item = "";
        
        while (!correct) {
            item = scanner.nextLine().toUpperCase();
            
            if (item.equals("COAT") || item.equals("PANTS") || item.equals("BOTH")) {
                correct = true;
            } else {
                println("incorrect format, choose again between those choices, Coat, Pants, or Both");
            }
        }
        
        return ItemEnum.valueOf(item);
    }

    /**
     * Prompts the user to choose a size for their order.
     * The method validates the input against allowed sizes.
     *
     * @param scanner The Scanner object for reading user input.
     * @return The validated SizeEnum corresponding to the chosen size.
     */
    public static SizeEnum sizeCheck(Scanner scanner) {
        boolean correct = false;
        String size = "";
        
        while (!correct) {
            size = scanner.nextLine().toUpperCase();
            
            if (size.equals("S") || size.equals("M") || size.equals("L") || 
                size.equals("XL") || size.equals("XXL") || size.equals("XXXL")) {
                correct = true;
            } else {
                println("incorrect format, choose again between those choices, S, M, L, XL, XXL, XXXL");
            }
        }
        
        return SizeEnum.valueOf(size);
    }

    /**
     * Prompts the user to choose a material for their order.
     * The method validates the input against allowed materials.
     *
     * @param scanner The Scanner object for reading user input.
     * @return The validated MaterialEnum corresponding to the chosen material.
     */
    public static MaterialEnum materialCheck(Scanner scanner) {
        boolean correct = false;
        String material = "";
        
        while (!correct) {
            material = scanner.nextLine().toUpperCase();
            
            if (material.equals("SILK") || material.equals("WOOL") || 
                material.equals("COTTON") || material.equals("LINEN") || 
                material.equals("SATIN")) {
                correct = true;
            } else {
                println("incorrect format, choose again between those choices, Silk, wool, linen, satin");
            }
        }
        
        return MaterialEnum.valueOf(material);
    }

    /**
     * Prompts the user to choose a color for their order.
     * The method validates the input against allowed colors.
     *
     * @param scanner The Scanner object for reading user input.
     * @return The validated ColorsEnum corresponding to the chosen color.
     */
    public static ColorsEnum colorsCheck(Scanner scanner) {
        boolean correct = false;
        String color = "";
        
        while (!correct) {
            color = scanner.nextLine().toUpperCase();
            
            if (color.equals("RED") || color.equals("WHITE") || 
                color.equals("BLACK") || color.equals("GREEN") || 
                color.equals("BLUE")) {
                correct = true;
            } else {
                println("incorrect format, choose again between those choices, red, white, green, blue");
            }
        }
        
        return ColorsEnum.valueOf(color);
    }

    /**
     * Prints a given message to the console.
     *
     * @param text The message to be printed.
     */
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * Prints a given message to the console without a newline.
     *
     * @param text The message to be printed.
     */
    public static void print(String text) {
        System.out.println(text);
    }

    /**
     * Retrieves the current hour of the day in 24-hour format.
     *
     * @return The current hour as an integer.
     */
    public static int currentTime() {
        return Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH")));
    }
}
