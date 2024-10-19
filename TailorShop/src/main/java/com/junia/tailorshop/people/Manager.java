package com.junia.tailorshop.people;

import com.junia.tailorshop.interfaces.WelcomeService;
import com.junia.tailorshop.interfaces.ManagementTasks;
import static com.junia.tailorshop.iooperations.FileOperations.isFileExists;
import static com.junia.tailorshop.utils.Utils.nameCheck;
import static com.junia.tailorshop.utils.Utils.numberCheck;
import static com.junia.tailorshop.utils.Utils.println;

import java.util.Scanner;
  /*
     * The Manager class represents a manager in the tailor shop.
     * It extends the Person class and implements the WelcomeService and ManagementTasks interfaces.
     * 
     * The Manager can welcome customers, manage tailors, handle customer complaints,
     * and provide their role information. The class includes methods for input validation for 
     * customer name and contact information.
     */

public class Manager extends Person implements WelcomeService, ManagementTasks {
    
  
    public Manager(String name, String contactInfo) {
        super(name, contactInfo);  
    }

    /*
     * Welcomes a customer to the tailor shop. It handles both new and returning customers.
     * For new customers, it prompts for their name and phone number, ensuring the phone 
     * number is not already associated with an existing customer. For returning customers,
     * it displays their information.
     * 
     * @param customer the customer being welcomed
     */
    @Override
    public void welcomeCustomer(Customer customer) {
        if (customer.getStatus().equals("NEW")) {
            Scanner scanner = new Scanner(System.in);  
            talk("Welcome! Manager " + getName() + " is here to assist you.");

            talk("Please enter your name: ");
            nameInputCheck(customer, scanner); 
            
            talk("Please enter your telephone number (format : 06xxxxxxxx ou 07xxxxxxxx) :");
            boolean whileNumExists = true;  
            while (whileNumExists) {
                numberInputCheck(customer, scanner); 
                String fileName = customer.getName() + customer.getContactInfo() + ".txt"; 
                // Check if the customer already exists
                if (isFileExists(fileName)) {
                    println("Customer with phone number " + customer.getContactInfo() + " already exists.");
                    println("Please use a different phone number");
                } else {
                    whileNumExists = false; 
                }
            }
            talk("Thank you, " + customer.getName() + "! Let's proceed with your order.");
        } else {
            talk("Welcome back, valued customer! I am here to assist you.");
            customer.showInfo(); 
        }
    }

    /*
     * Manages the tailors in the tailor shop.
     * This method can be expanded to include more specific management functionalities in the future.
     */
    @Override
    public void manageTailors() {
        talk("Manager is managing tailors."); 
    }

    /*
     * Handles customer complaints in the tailor shop.
     * This method can be expanded to include specific complaint handling procedures in the future.
     */
    @Override
    public void handleCustomerComplaints() {
        talk("Manager is handling customer complaints.");  
    }

    /*
     * Displays the role of the Manager.
     * This method provides information about the Manager's position in the shop.
     */
    @Override
    public void showRole() {
        talk("I am the Manager " + getName() + "."); 
    }

    /*
     * Validates and sets the customer's phone number using the input provided.
     * This method delegates the actual validation to a utility function.
     * 
     * @param customer the customer whose phone number is being checked
     * @param scanner the Scanner object for user input
     */
    @Override
    public void numberInputCheck(Customer customer, Scanner scanner) {
        numberCheck(customer, scanner); 
    }

    /*
     * Validates and sets the customer's name using the input provided.
     * This method delegates the actual validation to a utility function.
     * 
     * @param customer the customer whose name is being checked
     * @param scanner the Scanner object for user input
     */
    @Override
    public void nameInputCheck(Customer customer, Scanner scanner) {
        nameCheck(customer, scanner); 
    }
}
