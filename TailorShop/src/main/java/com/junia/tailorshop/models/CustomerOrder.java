package com.junia.tailorshop.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The CustomerOrder class represents an order placed by a customer in the tailor shop.
 * It contains information about the customer's name, contact details, the item ordered,
 * its size, material, and color. The class provides methods to convert the order
 * to and from JSON format for easy storage and retrieval.
 */
public class CustomerOrder {
    private String name;
    private String contactInfo;
    private String itemOrdered;
    private String size;
    private String material;
    private String color;

    // Constructors
    /**
     * Default constructor for CustomerOrder.
     */
    public CustomerOrder() { }

    /**
     * Parameterized constructor for CustomerOrder.
     *
     * @param name        The name of the customer.
     * @param contactInfo The contact information of the customer.
     * @param itemOrdered The item that has been ordered.
     * @param size       The size of the ordered item.
     * @param material    The material of the ordered item.
     * @param color       The color of the ordered item.
     */
    public CustomerOrder(String name,
                         String contactInfo,
                         String itemOrdered,
                         String size,
                         String material,
                         String color) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.itemOrdered = itemOrdered;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    // Getters and Setters
    /**
     * Retrieves the name of the customer.
     *
     * @return The customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the contact information of the customer.
     *
     * @return The customer's contact information.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the contact information of the customer.
     *
     * @param contactInfo The contact information to set for the customer.
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Retrieves the item that has been ordered.
     *
     * @return The ordered item.
     */
    public String getItemOrdered() {
        return itemOrdered;
    }

    /**
     * Sets the item that has been ordered.
     *
     * @param itemOrdered The item to set as ordered.
     */
    public void setItemOrdered(String itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    /**
     * Retrieves the size of the ordered item.
     *
     * @return The size of the ordered item.
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the ordered item.
     *
     * @param size The size to set for the ordered item.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Retrieves the material of the ordered item.
     *
     * @return The material of the ordered item.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material of the ordered item.
     *
     * @param material The material to set for the ordered item.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Retrieves the color of the ordered item.
     *
     * @return The color of the ordered item.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the ordered item.
     *
     * @param color The color to set for the ordered item.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Converts the CustomerOrder object to a JSON string.
     *
     * @return A JSON representation of the CustomerOrder object.
     */
    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    /**
     * Converts a JSON string back into a CustomerOrder object.
     *
     * @param json The JSON string to be converted.
     * @return A CustomerOrder object created from the JSON string.
     */
    public static CustomerOrder fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, CustomerOrder.class);
    }
}
