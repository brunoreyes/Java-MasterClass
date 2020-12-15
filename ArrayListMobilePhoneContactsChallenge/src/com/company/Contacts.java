package com.company;

import java.util.ArrayList;

public class Contacts {
    private ArrayList<String> contacts = new ArrayList<String>();

    public void addContact(String contact){ // CREATE
        contacts.add(contact);
    }

    public ArrayList<String> getContactsList() { // READ
        return contacts;
    }
    public void printContacts(){
        System.out.println("You have "+ contacts.size() + " contacts");
        for ( int i=0; i<contacts.size(); i++){
            System.out.println((i+1) + ". " + contacts.get(i)); // Ex Output: 1.Monica
        }
    }

    public void updateContact(String currentContact, String newContact){ // UPDATE
        int position = findContact(currentContact);
        if ( position >= 0){ // if exists b/c -1 would be returned if position didn't exist
            updateContact(position, currentContact, newContact);
        }
    }

    public void updateContact(int position, String currentContact, String newContact){
        contacts.set(position, newContact); // .set(val, newVal) updates a value
        System.out.println("Contact " + (position + 1) + // + 1 for human's view
                ". " + (currentContact) + " has been changed to " + (newContact));
    }

    public void deleteContact(String item){
        int position = findContact(item);
        if(position >= 0){
            deleteContact(position); // utilizing overloaded method with parameter of int
            System.out.println(" " + (item) +" has been removed from Contacts");
        }

    }
    private void deleteContact(int position){ // REMOVE
        contacts.remove(position); // .remove() removes a specific item from an array

    }

    private int findContact(String searchedContact){ // FIND
        return contacts.indexOf(searchedContact); // modified this method to return an int rather than String

    }

    public boolean onFile(String searchedContact){
        int position = findContact(searchedContact);
        if(position >= 0){
            return true;
        }
        return false;
    }



}
