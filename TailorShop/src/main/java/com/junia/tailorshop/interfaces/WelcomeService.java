package com.junia.tailorshop.interfaces;

import com.junia.tailorshop.people.Customer;
import java.util.Scanner;

/**
 * The WelcomeService interface defines the contract for welcoming customers
 * in the tailor shop system. It includes methods for welcoming new and returning
 * customers, as well as input validation for customer information.
 */
public interface WelcomeService {
    
    /**
     * Welcomes a customer to the tailor shop and handles any necessary 
     * initialization or interaction based on their status (NEW or OLD).
     *
     * @param customer The customer to be welcomed.
     */
    void welcomeCustomer(Customer customer);
    
    /**
     * Checks and validates the phone number input for a customer.
     *
     * @param customer The customer whose phone number is to be validated.
     * @param scanner  The Scanner object to read user input.
     */
    void numberInputCheck(Customer customer, Scanner scanner);
    
    /**
     * Checks and validates the name input for a customer.
     *
     * @param customer The customer whose name is to be validated.
     * @param scanner  The Scanner object to read user input.
     */
    void nameInputCheck(Customer customer, Scanner scanner);
}
