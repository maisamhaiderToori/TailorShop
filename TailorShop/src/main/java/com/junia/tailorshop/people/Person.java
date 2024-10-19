package com.junia.tailorshop.people;

/**
 * Represents a person in the tailor shop system, serving as a base class
 * for various types of people like customers, tailors, and managers.
 */
public abstract class Person {
    private String name; // Name of the person
    private String contactInfo; // Contact information (e.g., phone number)

    // Constructor to initialize the person's name and contact information
    public Person(String name, String contactInfo) {
        this.name = name; // Set the name
        this.contactInfo = contactInfo; // Set the contact info
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the contact information
    public String getContactInfo() {
        return contactInfo;
    }

    // Setter for the contact information
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Abstract method that subclasses must implement to show their specific role
    public abstract void showRole();

    // Method to print messages to the console
    protected void talk(String message) {
        System.out.println(message); // Output the message to the console
    }
}
