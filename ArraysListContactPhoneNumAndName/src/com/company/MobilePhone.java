package com.company;

import java.util.ArrayList;

public class MobilePhone {
    // Creating an option to store the mobile phone number
    private String myNumber;
    private ArrayList<Contact>myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>(); // initializing the ArrayList & starting it fresh
    }

    public boolean addNewContact(Contact contact){
        // if statement that will run if contact is already in the system
        if(findContact(contact.getName()) >= 0){
            // recall, x >= 0, if x is true than x is in the index of contact
            // if false, x will return -1 meaning the same contact wasn't found
            System.out.println("Contact is already on file");
            return false; //
        }
        myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if (position < 0){
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact); // calling find method to grab the possible index position
        if(foundPosition < 0){ // if foundPosition doesn't exist/-1, notify the user and return false, ending the function
            System.out.println( oldContact.getName() + ", was not found");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);// .set(position, newValue) updates the value of a position
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact); // returning index of contact >= 0, if doesn't exist, return -1
    }
    private int findContact(String contactName){
        for (int i=0; i<this.myContacts.size(); i++){

            Contact contact = this.myContacts.get(i); // .get() gets the value of the element
            if(contact.getName().equals(contactName)){ // .equals() compares a value and returns a boolean
                return i; // i, the index position is returned if .equals() returns boolean's value: true
            }
        }
        return -1; // Once, a return statement runs, the whole function ends, so if the "return" in the
                    // for loop's if statement runs, then the code will end, meaning the if statement
                    // wasn't satisfied and the return statement after and outside of the for loop will run.

    }
    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){ // if index exist we return the String name
            return contact.getName();
        } return null; // contact wasn't on file and does not exist
    }
    public Contact queryContact( String name){
        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for (int i=0; i < this.myContacts.size(); i++){  // getting the # of contacts
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " + // since we define the arraylist as contact.  Java knows that it's
                    this.myContacts.get(i).getPhoneNumber());   // an object within the  arrayList enabling the getters to work
        }

    }
}
