package com.junia.tailorshop.people;


import com.junia.tailorshop.interfaces.WelcomeService;
import com.junia.tailorshop.interfaces.ManagementTasks;
import static com.junia.tailorshop.utils.Utils.nameCheck;
import static com.junia.tailorshop.utils.Utils.numberCheck;
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;

 import java.util.Scanner;

public class SeniorTailor extends Person implements WelcomeService, ManagementTasks {
   
    
    public SeniorTailor(String name, String contactInfo) {
        super(name, contactInfo);
    }

    @Override
    public void welcomeCustomer(Customer customer) {
        
        if (customer.getStatus().equals("NEW")) {
            Scanner scanner = new Scanner(System.in);
            println("Welcome! Senior Tailor "+ getName() +" is here to assist you.");

            print("Please enter your name: ");
            nameInputCheck(customer,scanner);

            talk("Please enter your telephone number (format : 06xxxxxxxx ou 07xxxxxxxx) :");
            numberInputCheck(customer, scanner);

            println("Thank you, " + customer.getName() + "! Let's proceed with your order.");
        } else {
            println("Welcome back, valued customer! Senior Tailor is here to assist you.");
            customer.showInfo();
        }
    }

    @Override
    public void manageTailors() {
        println(getName() +" is managing junior tailors.");
    }

    @Override
    public void handleCustomerComplaints() {
        println("Senior Tailor "+ getName() +" is handling customer complaints.");
    }
    
    @Override
    public void showRole() {
        println("I am the Senior Tailor "+ getName()+".");
    }

    @Override
    public void numberInputCheck(Customer customer, Scanner scanner) {
        numberCheck(customer, scanner);
    }

    @Override
    public void nameInputCheck(Customer customer, Scanner scanner) {
        nameCheck(customer, scanner);
    
    
}}
