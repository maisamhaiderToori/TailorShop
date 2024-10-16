package com.junia.tailorshop.people;

import com.junia.tailorshop.interfaces.WelcomeService;
import com.junia.tailorshop.interfaces.ManagementTasks;
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;
import java.util.Scanner;

public class Manager extends Person implements WelcomeService, ManagementTasks {
   
    public Manager(String name, String contactInfo) {
        super(name, contactInfo);
    }

    @Override
    public void welcomeCustomer(Customer customer) {
        if (customer.getStatus().equals("NEW")) {
            Scanner scanner = new Scanner(System.in);
            println("Welcome! Manager "+getName()+" is here to assist you.");

            print("Please enter your name: ");
            String name = scanner.nextLine();
            customer.setName(name);

            print("Please enter your contact information: ");
            String contactInfo = scanner.nextLine();
            customer.setContactInfo(contactInfo);

            println("Thank you, " + name + "! Let's proceed with your order.");
        } else {
            println("Welcome back, valued customer! Manager "+getName()+" is here to assist you.");
            customer.showInfo();
        }
    }

    @Override
    public void manageTailors() {
        println("Manager is managing tailors.");
    }

    @Override
    public void handleCustomerComplaints() {
        println("Manager is handling customer complaints.");
    }
    
    @Override
    public void showRole() {
        println("I am the Manager "+ getName()+".");
    }
}
