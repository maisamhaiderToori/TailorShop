package com.junia.tailorshop.people;


abstract class Person {
    private String name;
    private String contactInfo;

    public Person(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public abstract void showRole();
    
    
    public void talk(String text){
        System.out.println( name +": "+ text);
    }
}
