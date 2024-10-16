package com.junia.tailorshop.people;

import com.junia.tailorshop.models.CustomerOrder;
import com.junia.tailorshop.enums.SizeEnum;
import com.junia.tailorshop.enums.ItemEnum;
import com.junia.tailorshop.enums.MaterialEnum;
import com.junia.tailorshop.enums.ColorsEnum;
import com.junia.tailorshop.iooperations.FileOperations;
import com.junia.tailorshop.models.Color;
import com.junia.tailorshop.models.Item;
import com.junia.tailorshop.models.Material;
import com.junia.tailorshop.models.Size;
import static com.junia.tailorshop.utils.Utils.clothesCheck;
import static com.junia.tailorshop.utils.Utils.colorsCheck;
import static com.junia.tailorshop.utils.Utils.materialCheck;
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;
import static com.junia.tailorshop.utils.Utils.sizeCheck;

import java.io.IOException;
import java.util.Scanner;

 
/**
 *
 * @author maisa
 */
public class Customer extends Person{
    private String contactInfo;
    private final String status; // NEW or OLD
    private ItemEnum itemOrdered;
    private SizeEnum size;
    private MaterialEnum material;
    private ColorsEnum color;
    private CustomerOrder custonerOrder;
    
    
    public Customer(String name, String contactInfo, String status) {
         super(name, contactInfo);
         custonerOrder = new CustomerOrder();
         this.status = status;
    }

   

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getStatus() {
        return status;
    }

    public void showInfo() {
       println("Name: " + getName());
        println("Contact: " + contactInfo);
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        if (status.equals("NEW")) {
           
            //TODO
            talk("Please choose the item you want to sew: Coat, Pants, or Both");
            itemOrdered = clothesCheck(scanner);
                   
            talk("Choose size: S, M, L, XL, XXL, XXXL");
            size = sizeCheck(scanner); // SizeEnum choice

            talk("Choose material: SILK, WOOL, COTTON, LINEN, SATIN");
            material = materialCheck(scanner); // MaterialEnum choice

            talk("Choose color: RED, WHITE, BLACK, GREEN, BLUE");
            color = colorsCheck(scanner); // ColorsEnum choice

            
            
            talk("Order placed for " + itemOrdered + " with size " + size +
                    ", material " + material + ", and color " + color);
            
            custonerOrder.setName(getName());
            custonerOrder.setContactInfo(contactInfo);
            custonerOrder.setColor(new Color(color.toString()));
            custonerOrder.setItemOrdered(new Item(itemOrdered.toString()));
            custonerOrder.setMaterial(new Material(material.toString()));
            custonerOrder.setSize(new Size(size.toString()));
            try{
           
              FileOperations.saveToFile(custonerOrder.toJson(), "customersDatabase.txt");
              FileOperations.loadFromFile("customersDatabase.txt");
            }catch (IOException e) {
                print(e.getMessage());
            }
           
        } else if (status.equals("OLD")) {
            talk("You are an old customer. Would you like to modify your previous order?");
            talk("Enter Y/N");
             //logic here for confirmation
             // want to modify confirmation or No
            if (scanner.nextLine().toUpperCase().equals("Y")) {
                modifyOrder();
            } else {
                talk("No changes made to your previous order.");
            }
        }
    }
//try {
//            FileOperations.saveToFile(newCustomer.name + ", " + newCustomer.customerType, "customers.txt");
//            FileOperations.loadFromFile("customers.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
 
    
    
    public void modifyOrder() {
        talk("Which part of your order would you like to modify?");
        talk("1. Size  2. Material  3. Color  4. Item Type (Coat, Pants, Both)");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // input logic here for the customer’s choice
        int choice = scanner.nextInt(); // choice to change

        switch (choice) {
            case 1 -> {
                talk("Choose new size: S, M, L, XL, XXL, XXXL");
                // Taking input for size
                size = sizeCheck(scanner2); ;  
                talk("Size updated to " + size);
            }/*
            case 2 -> {
                talk("Choose new material: SILK, WOOL, COTTON, LINEN, SATIN");
                
                material = materialCheck(scanner2);  
                talk("Material updated to " + material);
            }
            case 3 -> {
                talk("Choose new color: RED, WHITE, BLACK, GREEN, BLUE");
                // Taking input for color here
                color = colorsCheck(scanner2);
                talk("Color updated to " + color);
            }
            case 4 -> {
                talk("Choose new item: Coat, Pants, or Both");
                // Taking input for items 
                itemOrdered = clothesCheck(scanner2);
                talk("Item updated to " + itemOrdered);
            }*/
            default -> talk("Invalid choice.");
        }

        /*talk("Updated order: " + itemOrdered + " with size " + size +
                ", material " + material + ", and color " + color);*/
    }

    public int calculatePrice() {
        // Simplified price calculation based on size and material
        int basePrice = 50; // Default base price
        switch (size) {
            case S -> basePrice += 5;
            case M -> basePrice += 10;
            case L -> basePrice += 15;
            case XL -> basePrice += 20;
            case XXL -> basePrice += 25;
            case XXXL -> basePrice += 30;
        }

        switch (material) {
            case SILK -> basePrice += 30;
            case WOOL -> basePrice += 20;
            case COTTON -> basePrice += 15;
            case LINEN -> basePrice += 25;
            case SATIN -> basePrice += 35;
         }

        return basePrice;
    }

    @Override
    public void showRole() {
        talk("I am a customer "+ getName()+".");
  
     }
    
    
}
