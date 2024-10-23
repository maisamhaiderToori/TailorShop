package com.junia.tailorshop.people;

import com.junia.tailorshop.models.CustomerOrder;
import com.junia.tailorshop.enums.SizeEnum;
import com.junia.tailorshop.enums.ItemEnum;
import com.junia.tailorshop.enums.MaterialEnum;
import com.junia.tailorshop.enums.ColorsEnum;
import com.junia.tailorshop.iooperations.FileOperations;
import static com.junia.tailorshop.utils.Utils.clothesCheck;
import static com.junia.tailorshop.utils.Utils.colorsCheck;
import static com.junia.tailorshop.utils.Utils.materialCheck;
import static com.junia.tailorshop.utils.Utils.print;
import static com.junia.tailorshop.utils.Utils.println;
import static com.junia.tailorshop.utils.Utils.sizeCheck;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Customer class represents a customer in the tailor shop.
 * It extends the Person class and contains information about the customer's
 * order, including their status (NEW or OLD), the item they want to order,
 * its size, material, and color. The class provides methods to place
 * and modify orders, display customer information, and calculate prices.
 */
public class Customer extends Person {
    private final String status; // NEW or OLD
    private ItemEnum itemOrdered;
    private SizeEnum size;
    private MaterialEnum material;
    private ColorsEnum color;
    private final CustomerOrder custonerOrder;

    public Customer(String name, String contactInfo, String status) {
        super(name, contactInfo);
        custonerOrder = new CustomerOrder();
        this.status = status;
    }

    /**
     * Sets the item ordered by the customer.
     * 
     * @param itemOrdered The item to be set as ordered.
     */
    public void setItemOrdered(String itemOrdered) {
        this.itemOrdered = ItemEnum.valueOf(itemOrdered);
    }

    /**
     * Sets the size of the item ordered by the customer.
     * 
     * @param size The size to be set for the order.
     */
    public void setSize(String size) {
        this.size = SizeEnum.valueOf(size);
    }

    /**
     * Sets the material of the item ordered by the customer.
     * 
     * @param material The material to be set for the order.
     */
    public void setMaterial(String material) {
        this.material = MaterialEnum.valueOf(material);
    }

    /**
     * Sets the color of the item ordered by the customer.
     * 
     * @param color The color to be set for the order.
     */
    public void setColor(String color) {
        this.color = ColorsEnum.valueOf(color);
    }

    /**
     * Retrieves the status of the customer (NEW or OLD).
     * 
     * @return The status of the customer.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Displays the customer's information, including name and contact details.
     */
    public void showInfo() {
        println("Name: " + getName());
        println("Contact: " + getContactInfo());
    }

    /**
     * Prints the details of the customer's order.
     * 
     * @param startText The text to precede the order details.
     */
    private void printCustomerOrder(String startText) {
        talk(startText + itemOrdered + " with size " + size +
                ", material " + material + ", and color " + color);
    }

    /**
     * Initiates the process of placing an order based on the customer's status.
     * If the customer is new, it triggers the new customer order process.
     * If the customer is old, it prompts them to modify their previous order.
     */
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        if (status.equals("NEW")) {
            newCustomer(scanner);
        } else if (status.equals("OLD")) {
            talk("You are an old customer. Would you like to modify your previous order?");
            talk("Enter Y/N");
            // Logic here for confirmation of modification
            if (yesOrNo(scanner)) {
                modifyOrder();
            } else {
                talk("No changes made to your previous order.");
                printCustomerOrder("Order placed for ");
            }
        }
    }

    /**
     * Handles the order process for a new customer.
     * Prompts the customer to choose the item, size, material, and color,
     * then saves the order details.
     * 
     * @param scanner The scanner to take user input.
     */
    private void newCustomer(Scanner scanner) {
        talk("Please choose the item you want to sew: Coat, Pants, or Both");
        itemOrdered = clothesCheck(scanner);

        talk("Choose size: S, M, L, XL, XXL, XXXL");
        size = sizeCheck(scanner); // SizeEnum choice

        talk("Choose material: SILK, WOOL, COTTON, LINEN, SATIN");
        material = materialCheck(scanner); // MaterialEnum choice

        talk("Choose color: RED, WHITE, BLACK, GREEN, BLUE");
        color = colorsCheck(scanner); // ColorsEnum choice

        printCustomerOrder("Order placed for ");

        custonerOrder.setName(getName());
        custonerOrder.setContactInfo(getContactInfo());
        custonerOrder.setColor(color.toString());
        custonerOrder.setItemOrdered(itemOrdered.toString());
        custonerOrder.setMaterial(material.toString());
        custonerOrder.setSize(size.toString());
        try {
            FileOperations.saveToFile(custonerOrder.toJson(), getName() + getContactInfo() + ".txt");
        } catch (IOException e) {
            print(e.getMessage());
        }
    }

    /**
     * Allows an old customer to modify their existing order.
     * Prompts the customer to choose which part of their order they would like to change,
     * and processes their choices accordingly.
     */
    private void modifyOrder() {
        talk("Which part of your order would you like to modify?");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        boolean wantToChange = true;
        while (wantToChange) {
            talk("1. Size  2. Material  3. Color  4. Item Type (Coat, Pants, Both)");
            // Input logic here for the customer’s choice
            int choice = scanner.nextInt(); // choice to change
            switch (choice) {
                case 1 -> {
                    talk("Choose new size: S, M, L, XL, XXL, XXXL");
                    size = sizeCheck(scanner2);
                    talk("Size updated to " + size);
                }
                case 2 -> {
                    talk("Choose new material: SILK, WOOL, COTTON, LINEN, SATIN");
                    material = materialCheck(scanner2);
                    talk("Material updated to " + material);
                }
                case 3 -> {
                    talk("Choose new color: RED, WHITE, BLACK, GREEN, BLUE");
                    color = colorsCheck(scanner2);
                    talk("Color updated to " + color);
                }
                case 4 -> {
                    talk("Choose new item: Coat, Pants, or Both");
                    // Taking input for items 
                    itemOrdered = clothesCheck(scanner2);
                    talk("Item updated to " + itemOrdered);
                }
                default -> talk("Invalid choice.");
            }

            talk("Would you like to change something else? [Y/N]");
            wantToChange = yesOrNo(scanner2);
        }

        printCustomerOrder("Updated order: ");

        custonerOrder.setName(getName());
        custonerOrder.setContactInfo(getContactInfo());
        custonerOrder.setColor(color.toString());
        custonerOrder.setItemOrdered(itemOrdered.toString());
        custonerOrder.setMaterial(material.toString());
        custonerOrder.setSize(size.toString());
        try {
            FileOperations.saveToFile(custonerOrder.toJson(), getName() + getContactInfo() + ".txt");
        } catch (IOException e) {
            print(e.getMessage());
        }
    }

    /**
     * Validates user input for yes/no questions.
     * 
     * @param scanner The scanner to take user input.
     * @return true if the user answers 'Y', false if 'N'.
     */
    private boolean yesOrNo(Scanner scanner) {
        boolean answerNotValid = true;
        boolean yOrNo = false;
        while (answerNotValid) {
            String yesOrNo = scanner.nextLine().toUpperCase();
            switch (yesOrNo) {
                case "Y" -> {
                    answerNotValid = false;
                    yOrNo = true;
                }
                case "N" -> {
                    answerNotValid = false;
                    yOrNo = false;
                }
                default -> println("Please type Y/N");
            }
        }
        return yOrNo;
    }

    /**
     * Calculates the price of the order based on size and material.
     * 
     * @return The calculated price as an integer.
     */
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

    /**
     * Displays the customer's role in the tailor shop.
     */
    @Override
    public void showRole() {
        talk("I am a customer " + getName() + ".");
    }
}
