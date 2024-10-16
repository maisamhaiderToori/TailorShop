/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author maisa
 */
public class Utils {
    
    ////Welcoming functions////////
    
    
  public static void numberCheck(Customer customer, Scanner scanner){
        boolean valid =false;
        String phoneRegex = "^(06|07)\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        
            while (!valid) {
              
             String phoneNumber = scanner.nextLine();// Matches if phone number in correct format
             
             Matcher matcher = pattern.matcher(phoneNumber);
    
            if (matcher.matches()) {
                customer.setContactInfo(phoneNumber);
                valid = true; // Si c'est valide, on sort de la boucle
            } else {
                println("Erreur : Numéro de téléphone invalide. Veuillez réessayer. (format : 06xxxxxxxx ou 07xxxxxxxx) :");
            }
        }
    }
  
  public static void nameCheck(Customer customer, Scanner scanner){
      boolean valid =false;
      
      String nameRegex = "^[a-zA-Z][a-zA-Z]*(?:[\\s'-][A-Za-z][a-zA-Z]*)*$";

        Pattern pattern = Pattern.compile(nameRegex);
       while (!valid) {
           
       String name = scanner.nextLine();
       Matcher matcher = pattern.matcher(name);
      if (matcher.matches()) {
                customer.setName(name);
                valid = true; // Si c'est valide, on sort de la boucle
            } else {
              println("Erreur : Name format not valid. please try again :");
            }
            customer.setName(name);
       }
  }
  public static ItemEnum clothesCheck( Scanner scanner){
    boolean correct = false;
    String item = "";
            
       
    while(correct == false){
        
            
        item = scanner.nextLine().toUpperCase();
                
        if(item.equals("COAT")  || item.equals("PANTS") || item.equals("BOTH")){
           // itemOrdered = ItemEnum.valueOf(item); // ItemEnum choice
            correct=true;
                         }
        else{
            println("incorrect format, choose again between those choices, Coat, Pants, or Both");
            }
                
     
            }
    
    return ItemEnum.valueOf(item);
  }
  
  public static SizeEnum sizeCheck( Scanner scanner){
    boolean correct = false;
    String size = "";   
    while(correct == false){    
        size = scanner.nextLine().toUpperCase();
                
        if(size.equals("S")  || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL") 
                || size.equals("XXXL") ){
         
            correct=true;
                         }
        else{
            println("incorrect format, choose again between those choices, S, M, L, XL, XXL, XXXL");
            }
                
     
            }
    
    return SizeEnum.valueOf(size);
  }
    
    
  public static MaterialEnum materialCheck( Scanner scanner){
    boolean correct = false;
    String material = "";   
    while(correct == false){    
        material = scanner.nextLine().toUpperCase();
                
        if(material.equals("SILK")  || material.equals("WOOL") || material.equals("LINEN") || material.equals("SATIN")){
         
            correct=true;
                         }
        else{
            println("incorrect format, choose again between those choices, Silk, wool, linen, satin");
            }
                }
    
    return MaterialEnum.valueOf(material);
  }
  
  public static ColorsEnum colorsCheck( Scanner scanner){
    boolean correct = false;
    String color = "";   
    while(correct == false){    
        color = scanner.nextLine().toUpperCase();
                
        if(color.equals("RED")  || color.equals("WHITE") || color.equals("BLACK") || color.equals("GREEN") || color.equals("BLUE")){
         
            correct=true;
                         }
        else{
            println("incorrect format, choose again between those choices, red, white, green, blue");
            }
                }
    
    return ColorsEnum.valueOf(color);
  }
    
    
    public static void println(String text){
        System.out.println(text);
    }
    
    
    
    public static void print(String text){
        System.out.println(text);
    }
    public static int currentTime(){
       return Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH")));
     }
    
}
