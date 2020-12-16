package com.company;

public class Contact {
    private String name;
    private String phoneNumber;

    // Adding Getters and utilizing the Constructor to perform functionality that usually the Setter does.

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // here we are using a static aka convenience or factory method,
    // allowing me to create a new contact record w/o having to create a new Contact Class
    // w/o having to create an instance or object to create a method on.
    public static Contact createContact(String name, String phoneNumber){  // returning a Contact
        // static here tells me I don't have to create a new object instance for this class Contact
        return new Contact(name, phoneNumber); // Calling the constructor to create a new contact record

    }






}
