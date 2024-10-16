package com.junia.tailorshop;

import com.junia.tailorshop.interfaces.WelcomeService;
import com.junia.tailorshop.people.JuniorTailor;
import com.junia.tailorshop.people.SeniorTailor;
import com.junia.tailorshop.people.Manager;
import com.junia.tailorshop.people.Customer;
import static com.junia.tailorshop.utils.Utils.currentTime;
   import java.util.Random;

 



public class TailorShop {

    public static void main(String[] args) {
        // Creating instances of customers, senior tailor, junior tailor, and manager
        // Create staff members
        
   
        JuniorTailor junior = new JuniorTailor("Maisam Haider", "+33781882419");
        SeniorTailor senior = new SeniorTailor("Emile Fourtane", "+33712345678");
        Manager manager = new Manager("Boss", "+33712345679");

        // Simulate opening the shop
        junior.openShop();
        
        // Randomly assign Senior Tailor or Manager to welcome the customer
        Random random = new Random();
        int randomChoice = random.nextInt(2);  // 0 for Senior Tailor, 1 for Manager

        WelcomeService welcomer;
        if (randomChoice == 0) {
            welcomer = senior;
        } else {
            welcomer = manager;
        }
        
         // Create new and old customers
        Customer newCustomer = new Customer("", "", "NEW");
//        Customer oldCustomer = new Customer("Sam", "789789789", "OLD");

        
        welcomer.welcomeCustomer(newCustomer);

        // Customer places order and calculates price
        newCustomer.placeOrder();
 

//        // Management tasks (both Senior Tailor and Manager can now manage)
//        senior.manageTailors();
//        senior.handleCustomerComplaints();
        
// Saving customer data to file
        
        if(currentTime() > 20){
            // Junior Tailor closes the shop
        junior.closeShop();
        }
        
    }

    
}

