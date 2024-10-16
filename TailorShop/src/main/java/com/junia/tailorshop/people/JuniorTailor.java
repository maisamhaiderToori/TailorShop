package com.junia.tailorshop.people;

import static com.junia.tailorshop.utils.Utils.println;





public class JuniorTailor extends Person {
    
    public JuniorTailor(String name, String contactInfo) {
        super(name, contactInfo);
    }

    public void openShop() {
        println(getName() + " is opening the shop early in the morning.");
        println("Setting up everything... Turning on lights, setting up the tailoring equipment, organizing materials.");
    }

    public void closeShop() {
        println(getName() + " is closing the shop.");
        println("Turning off lights, cleaning the workspace, securing the shop.");
    }

    @Override
    public void showRole() {
        println("I am the Junior Tailor "+ getName()+".");
    }
}
