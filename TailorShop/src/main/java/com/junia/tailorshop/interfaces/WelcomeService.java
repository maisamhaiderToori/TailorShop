package com.junia.tailorshop.interfaces;

import com.junia.tailorshop.people.Customer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public interface WelcomeService {
    void welcomeCustomer(Customer customer);
    
    void numberInputCheck(Customer customer, Scanner scanner);
    
    void nameInputCheck(Customer customer, Scanner scanner);
    
}

