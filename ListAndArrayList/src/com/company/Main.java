package com.company;

// NOTE: Good practice when methods deal with positions it's better to make them private methods.

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
// a list is an ordered sequence of items
public class Main {

    private static Scanner scanner = new Scanner(System.in);// System.in allows input from the keyboard
//    private static int[] baseData = new int[10];
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // .nextLine() clears the input buffer

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }

//        System.out.println("Enter 10 integers:");
//        getInput();
//        printArray(baseData);
//        resizeArray();
//        System.out.println("Enter 12 integers:");
//        getInput();
////        baseData[10] = 67;
////        baseData[11] = 34;
//        printArray(baseData);

        // Grocery List input

    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem(){
        System.out.println("Please Enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Enter current item name: ");
        String itemNo = scanner.nextLine();
        System.out.println("Enter new item name: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem); // deducting 1 from the # entered by the user
    }
    public static void removeItem(){
        // Asking the user for a number an allowing for input; repeated step from modifyItem();
        System.out.println("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem(){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList()); // .addAll() copies an entire array

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray); // myArray contains the contents of the array
    }
//    private static void getInput() // getting data from the console and saving it to the array
//    {
//        for(int i = 0; i < baseData.length; i++)
//            baseData[i] = s.nextInt();
//    }
//
//    private static void printArray(int[] arr)
//    {
//        for(int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
//
//    private static void resizeArray() // To resize an array:
//    {   // "Original" array contains 10 variables
//        int[] original = baseData; // 1. Save the original array to a variable
//
//
//        baseData = new int[12]; // 2. Initialize the variable to a new array and change the # of indexes
//
//        // ("base data" array contains 12 variables that overwrites the 10 variables of the "Original" array)
//        for (int i = 0; i < original.length; i++) // 3. Go through and copy the original values
//            baseData[i] = original[i];            // from the old array into the new array
//    }

}