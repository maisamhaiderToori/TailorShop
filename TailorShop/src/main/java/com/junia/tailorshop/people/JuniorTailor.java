package com.junia.tailorshop.people;

import static com.junia.tailorshop.utils.Utils.println;

 /*
     * The JuniorTailor class represents a junior tailor in the tailor shop.
     * It extends the Person class and provides functionality specific to junior tailors,
     * including opening and closing the shop, as well as displaying their role.
     */

public class JuniorTailor extends Person {
    
   
    public JuniorTailor(String name, String contactInfo) {
        super(name, contactInfo); // Call the constructor of the superclass Person
    }

    /*
     * Opens the shop in the morning.
     * This method simulates the actions taken by the Junior Tailor to prepare the shop 
     * for customers, including turning on lights and organizing materials.
     */
    public void openShop() {
        println(getName() + " is opening the shop early in the morning.");  
        println("Setting up everything... Turning on lights, setting up the tailoring equipment, organizing materials.");  
    }

    /*
     * Closes the shop at the end of the day.
     * This method simulates the actions taken by the Junior Tailor to secure the shop
     * and clean the workspace after a day's work.
     */
    public void closeShop() {
        println(getName() + " is closing the shop."); 
        println("Turning off lights, cleaning the workspace, securing the shop."); 
    }

    /*
     * Displays the role of the Junior Tailor.
     * This method provides information about the Junior Tailor's position in the shop.
     */
    @Override
    public void showRole() {
        println("I am the Junior Tailor " + getName() + "."); 
    }
}
