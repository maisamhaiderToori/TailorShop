package com.junia.tailorshop.models;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.junia.tailorshop.models.Color;
import com.junia.tailorshop.models.Item;
import com.junia.tailorshop.models.Material;
import com.junia.tailorshop.models.Size;

public class CustomerOrder {
    private String name;
    private String contactInfo;
    private Item itemOrdered;
    private Size size;
    private Material material;
    private Color color;
    
    // Constructors
    public CustomerOrder(){ }
    
    public CustomerOrder(String name, 
            String contactInfo, 
            String status, 
            Item itemOrdered, 
            Size size, 
            Material material, 
            Color color) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.itemOrdered = itemOrdered;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

   
    public Item getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(Item itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Method to convert the object to JSON
    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    // Static method to convert JSON back to an object
    public static CustomerOrder fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, CustomerOrder.class);
    }
}
