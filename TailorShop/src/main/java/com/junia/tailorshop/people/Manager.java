package com.junia.tailorshop.people;

import com.junia.tailorshop.interfaces.WelcomeService;
import com.junia.tailorshop.interfaces.ManagementTasks;
import static com.junia.tailorshop.utils.Utils.nameCheck;
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;
import static com.junia.tailorshop.utils.Utils.numberCheck;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Manager extends Person implements WelcomeService, ManagementTasks {
   
    public Manager(String name, String contactInfo) {
        super(name, contactInfo);
    }

    @Override
    public void welcomeCustomer(Customer customer) {
        if (customer.getStatus().equals("NEW")) {
            Scanner scanner = new Scanner(System.in);
            talk("Welcome! Manager "+getName()+" is here to assist you.");

            talk("Please enter your name: ");
            nameInputCheck(customer, scanner);
            
            talk("Please enter your telephone number (format : 06xxxxxxxx ou 07xxxxxxxx) :");
            numberInputCheck(customer, scanner);
            

            talk("Thank you, " + customer.getName() + "! Let's proceed with your order.");
        } else {
            talk("Welcome back, valued customer! Manager "+getName()+" is here to assist you.");
            customer.showInfo();
        }
    }

    
    
    @Override
    public void manageTailors() {
        talk("Manager is managing tailors.");  
    }

    @Override
    public void handleCustomerComplaints() {
       talk("Manager is handling customer complaints.");
    }
    
    @Override
    public void showRole() {
        talk("I am the Manager "+ getName()+".");
    }

    @Override
    public void numberInputCheck(Customer customer, Scanner scanner) {
        numberCheck(customer, scanner);
    }

    @Override
    public void nameInputCheck(Customer customer, Scanner scanner) {
       nameCheck(customer, scanner);
    }
}
