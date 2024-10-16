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
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;
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
           

            println("Please choose the item you want to sew: Coat, Pants, or Both");
            itemOrdered = ItemEnum.valueOf(scanner.nextLine().toUpperCase()); // ItemEnum choice

            println("Choose size: S, M, L, XL, XXL, XXXL");
            size = SizeEnum.valueOf(scanner.nextLine().toUpperCase()); // SizeEnum choice

            println("Choose material: SILK, WOOL, COTTON, LINEN, SATIN");
            material = MaterialEnum.valueOf(scanner.nextLine().toUpperCase()); // MaterialEnum choice

            println("Choose color: RED, WHITE, BLACK, GREEN, BLUE");
            color = ColorsEnum.valueOf(scanner.nextLine().toUpperCase()); // ColorsEnum choice

            println("Order placed for " + itemOrdered + " with size " + size +
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
            println("You are an old customer. Would you like to modify your previous order?");
            println("Enter Y/N");
             //logic here for confirmation
             // want to modify confirmation or No
            if (scanner.nextLine().toUpperCase().equals("Y")) {
                modifyOrder();
            } else {
                println("No changes made to your previous order.");
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
        println("Which part of your order would you like to modify?");
        println("1. Size  2. Material  3. Color  4. Item Type (Coat, Pants, Both)");
        Scanner scanner = new Scanner(System.in);

        // input logic here for the customer’s choice
        int choice = scanner.nextInt(); // choice to change

        switch (choice) {
            case 1 -> {
                println("Choose new size: S, M, L, XL, XXL, XXXL");
                // Taking input for size
                size = SizeEnum.valueOf(scanner.nextLine().toUpperCase()) ;  
                println("Size updated to " + size);
            }
            case 2 -> {
                println("Choose new material: SILK, WOOL, COTTON, LINEN, SATIN");
                // Taking input for material here
                material = MaterialEnum.valueOf(scanner.nextLine().toUpperCase());  
                println("Material updated to " + material);
            }
            case 3 -> {
                println("Choose new color: RED, WHITE, BLACK, GREEN, BLUE");
                // Taking input for color here
                color = ColorsEnum.valueOf(scanner.nextLine().toUpperCase());
                println("Color updated to " + color);
            }
            case 4 -> {
                println("Choose new item: Coat, Pants, or Both");
                // Taking input for items 
                itemOrdered = ItemEnum.valueOf(scanner.nextLine().toUpperCase());
                println("Item updated to " + itemOrdered);
            }
            default -> println("Invalid choice.");
        }

        println("Updated order: " + itemOrdered + " with size " + size +
                ", material " + material + ", and color " + color);
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
        println("I am a customer "+ getName()+".");
  
     }
    
    
}
