package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contacts.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print Contacts.");
        System.out.println("\t 2 - Add a contact.");
        System.out.println("\t 3 - Update an existing contact.");
        System.out.println("\t 4 - To delete a contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To exit out of contacts.");
    }

    public static void addContact(){
        System.out.println("Please Enter the contact you want to add: ");
        contacts.addContact(scanner.nextLine());
    }
    public static void updateContact(){
        System.out.println("Enter current name of contact: ");
        String contactNo = scanner.nextLine();
        System.out.println("Enter new name of contact: ");
        String newItem = scanner.nextLine();
        contacts.updateContact(contactNo, newItem);
    }
    public static void deleteContact(){
        System.out.println("Enter contact's name: ");
        String contactNo = scanner.nextLine();
        contacts.deleteContact(contactNo);
    }

    public static void findContact(){
        System.out.println("Enter contact you want to search for: ");
        String searchedContact = scanner.nextLine();
        if(contacts.onFile(searchedContact)){
            System.out.println("Found " + searchedContact + " in Contacts");
        } else {
            System.out.println(searchedContact + " is not in Contacts");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(contacts.getContactsList()); // .addAll() copies an entire array
        ArrayList<String> nextArray = new ArrayList<String>(contacts.getContactsList());
        String[] myArray = new String[contacts.getContactsList().size()];
        myArray = contacts.getContactsList().toArray(myArray);
    }
}
