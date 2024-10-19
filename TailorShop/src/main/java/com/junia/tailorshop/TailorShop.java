package com.junia.tailorshop;

import com.junia.tailorshop.interfaces.WelcomeService;
import static com.junia.tailorshop.iooperations.FileOperations.isFileExists;
import static com.junia.tailorshop.iooperations.FileOperations.loadFromFile;
import com.junia.tailorshop.models.CustomerOrder;
import static com.junia.tailorshop.models.CustomerOrder.fromJson;
import com.junia.tailorshop.people.JuniorTailor;
import com.junia.tailorshop.people.SeniorTailor;
import com.junia.tailorshop.people.Manager;
import com.junia.tailorshop.people.Customer;
import static com.junia.tailorshop.utils.Utils.currentTime;
import static com.junia.tailorshop.utils.Utils.println;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
    
    /*
     * The TailorShop class simulates a tailor shop operation.
     * 
     * It initializes staff members, including a Junior Tailor, Senior Tailor, and Manager.
     * The shop opens and welcomes customers, who can be either new or returning.
     * 
     * For new customers, the system initiates a new customer procedure.
     * For returning customers, the system checks if their information exists in the File system 
     * by validating their name and phone number. If their record exists, their previous 
     * order details are retrieved from a file.
     * 
     * The chosen staff member (either Senior Tailor or Manager) welcomes the customer 
     * and allows them to place an order. After placing an order, the total price is calculated 
     * and presented to the customer, who is then prompted to choose a payment method.
     * 
     * The shop may close automatically if the time exceeds 8 PM, at which point the 
     * Junior Tailor will close the shop.
     */

public class TailorShop {

    public static void main(String[] args) {
        // Creating instances of customers, senior tailor, junior tailor, and manager
        // Create staff members
        Scanner input = new Scanner(System.in); 
        JuniorTailor junior = new JuniorTailor("Maisam Haider", "+33781882419"); 
        SeniorTailor senior = new SeniorTailor("Emile Fourtane", "+33712345678");
        Manager manager = new Manager("Boss", "+33712345679");

        // Simulate opening the shop
        junior.openShop(); // Call method for Junior Tailor to open the shop
        
        // Randomly assign Senior Tailor or Manager to welcome the customer
        Random random = new Random(); // Create a random number generator
        int randomChoice = random.nextInt(2); // Randomly choose between 0 (Senior Tailor) or 1 (Manager)
        
        // Declare a variable for the welcoming service
        WelcomeService welcomer; 
        
        // If 0, assign Senior Tailor to welcome customers
        // If 1, assign Manager to welcome customers
        if (randomChoice == 0) {
            welcomer = senior; 
        } else {
            welcomer = manager; 
        }
        
        // Create new and old customers
        String customerType; // Variable to store customer type
        Customer customer = null; // Initialize customer
        boolean userTypeIsWrong = true; // Flag to control user input loop
      
        while (userTypeIsWrong) {
            println("Please Enter if the customer is ?\n1. Old\n2. New"); // Prompt user for customer type
            customerType = input.nextLine().toUpperCase(); // Read and convert input to uppercase

            switch (customerType) {
                case "NEW" -> {
                    userTypeIsWrong = false; // Valid input, exit loop
                    println("New customer procedure: \n"); // Inform user of new customer procedure
                    customer = new Customer("", "", "NEW"); // Create new Customer object for a new customer
                }
                case "OLD" -> {
                    userTypeIsWrong = false; // Valid input, exit loop
                    println("Old customer procedure: \n"); // Inform user of old customer procedure
                    customer = new Customer("", "", "OLD"); // Create new Customer object for an old customer
                    boolean runLoopUntil = true; // Flag for inner loop to gather old customer info
                    while (runLoopUntil) {
                        println("Please enter the customer's name: "); // Prompt for customer's name
                        welcomer.nameInputCheck(customer, input); // Validate and set customer's name
                        
                        println("Please enter the customer's telephone number (format : 06xxxxxxxx ou 07xxxxxxxx) :"); // Prompt for phone number
                        welcomer.numberInputCheck(customer, input); // Validate and set customer's phone number
                        String fileName = customer.getName() + customer.getContactInfo() + ".txt"; // Construct filename based on customer info
                        
                        // Check if the file for the customer exists
                        if (!isFileExists(fileName)) {
                            println("Customer with name " + customer.getName() + " and " + "phone number " + customer.getContactInfo() + " does not exist."); // Inform user if file does not exist
                            println("\n-----------------------------------------------Try Again-----------------------------------------------\n");
                            runLoopUntil = false; // Exit inner loop
                            userTypeIsWrong = true; // Reset outer loop flag
                        } else {
                            runLoopUntil = false; // Exit inner loop if file exists
                            try {
                                String gson = loadFromFile(fileName); // Load customer order from file
                                CustomerOrder cOrder = fromJson(gson); // Convert JSON string to CustomerOrder object
                                
                                // Set customer's order details
                                customer.setItemOrdered(cOrder.getItemOrdered());
                                customer.setMaterial(cOrder.getMaterial());
                                customer.setColor(cOrder.getColor());
                                customer.setSize(cOrder.getSize());
                                
                            } catch (IOException e) {
                                userTypeIsWrong = true; // Reset outer loop flag on exception
                                println("Your file for the user is not existed on the system"); // Inform user of error
                                println("\n-----------------------------------------------Try Again-----------------------------------------------\n");
                            }
                        }
                    }
                }
                default -> {
                    println("Customer type is incorrect. Try Again."); // Inform user of invalid input
                    println("\n-----------------------------------------------Try Again-----------------------------------------------\n");
                }
            }
        }
        
        if (customer != null) {
            welcomer.welcomeCustomer(customer);  
            customer.placeOrder(); 
            
            // Calculate and display the total price
            println("Total Price: €" + customer.calculatePrice()); 
            println("Please pay the bill by Card or cash"); // Prompt for payment method
            println("\n\nThank you so much"); // Thank the customer
            if (currentTime() > 17) {
                println("Have a good evening!"); // Evening greeting if time is after 5 PM
            } else {
                println("Have a good day!"); // Day greeting if time is before 5 PM
            }
        }
        // Call method for Junior Tailor to close the shop if it's after 8 PM
        if (currentTime() > 20) {
            junior.closeShop(); 
        }
    }
}
