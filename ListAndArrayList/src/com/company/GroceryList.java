package com.company;

import java.util.ArrayList;

public class GroceryList {

    private int[] myNumbers = new int[50]; // an int type array is just a class
    private ArrayList<String> groceryList = new ArrayList<String>(); // the array list is a class
                                                                    //() is a parameter
    // An ArrayList doesn't define the type regularly like an array above, instead
                                // to declare a type, we do it like so: ArrayList<Type>

    public ArrayList<String> getGroceryList() { // ability to retrieve the array list
        return groceryList;
    }

    public void addGroceryItem(String item){ // CREATE
        groceryList.add(item); // how to add a value to a new index of the array list
        //myNumbers[5] = 4; // how to save a value to a normal array index
    }

    public void printGroceryList(){ // GET
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i=0; i<groceryList.size(); i++){ // .size() gives us the # of items in an array list
            System.out.println((i+1) +". " + groceryList.get(i)); // .get() retrieves the chosen index's value

        }
    }

    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem); // if current item exist we can replace it with the new item
        if( position >= 0 ){
            modifyGroceryItem(position, newItem); // if the item exist we'll pass it's position to the
                                                // overloaded version of modifyGroceryItem with 2 parameters
        }

    }
    private void modifyGroceryItem(int position, String newItem){ // UPDATE
        groceryList.set(position, newItem); // replace the value at a specific position in the arrayList
        System.out.println("Grocery item " + (position + 1) +
                " has been changed from " + (newItem)); // + 1 for human's view
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if(position >= 0){
            removeGroceryItem(position); // utilizing overloaded method with parameter of int
            System.out.println("Grocery item " + (item) +" has been removed from the list");
        }

    }
    private void removeGroceryItem(int position){ // REMOVE
        // String theItem = groceryList.get(position); // no longer needed since we've tested this in overloaded method
        groceryList.remove(position); // .remove() removes a specific item from an array
        // Milk   if we delete Cheese at int position 1, then Bread becomes the new value for int position 1
        // Cheese
        // Bread
    }

    private int findItem(String searchItem){ // FIND
        return groceryList.indexOf(searchItem); // modified this method to return an int rather than String

       // boolean exists = groceryList.contains(searchItem);// .contains(item) searches for an item within an arraylist
      //  int position = groceryList.indexOf(searchItem); // .indexOf(item) finds the item & retrieves it's index position
      //  // if .indexOf() returns -1, that means it doesn't exist
     //   if ( position >= 0 ){
          //   return groceryList.get(position); // .get() again returns the value of the index
       // } return null;
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position >= 0){
            return true;
        }
        return false;
    }
}
