package com.company;

// Overview: Create a program that implements a simple mobile phone with the following capabilities.


// Task 1. You will want to create a separate class for Contacts (name and phone number).

// Task 2.  Able to store, modify, remove and query contact names.
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// MobilePhone should do everything with Contact objects only.
// Important Note: When adding or updating be sure to check if the contact already exists (use name) aka boolean

// Task 3. Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.

// Task 4. Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc

// Most UI is in the main Class, where CRUD resides in MobilePhone, and middleman is Contact
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in); // allowing keyboard input
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404"); // input a string phone # in function

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter your choice: (Press 0 to show available options) ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    printActions();
                    break;
                case 1:
                    mobilePhone.printContacts(); // calling a public method that utilizes private methods
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine(); // collecting the name the user inputted
        System.out.println("Enter new phone number");
        String phone = scanner.nextLine(); // collecting the phone the user inputted
        Contact newContact = Contact.createContact(name, phone); // passing the inputted values to a new instance of the createContact method
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else System.out.println("Cannot add, " + name + " is already on file");
    }

    private static void updateContact() {
        // Searching to see if the user's inputted name is within the list of contacts
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord ==  null){
            System.out.println("Contact not found.");
            return; // returning null and ending this entire updateContact() code block
        }

        // Since return statement hasn't been activated, we are taking in the user's new name & phone number
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();

        // Checking to see if the newName = (old name || another name in the contact list)
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");
        } else System.out.println("Error updating record."); // in the case of multiple users, best practice
    }

    private static void removeContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord ==  null){
            System.out.println("Contact not found.");
            return; // returning null
        }

        // Updating the user on deletion progress
        if (mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        } else System.out.println("Error deleting contact");
    }


    public static void queryContact (){

        // Searching to see if the user's inputted name is within the list of contacts
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return; // returning null
        }

        System.out.println("Successfully found. Name: " + existingContactRecord.getName() +
                " phone number is " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    public static void printActions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print possible actions.");
        System.out.println("\t 1 - To print contact list.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove an existing contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To exit out of contacts.");
    }
}
