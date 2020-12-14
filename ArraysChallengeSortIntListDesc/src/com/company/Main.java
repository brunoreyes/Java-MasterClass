package com.company;

import java.util.Scanner;

// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

// If I try to access an index that is out of the range Java will give me an ArrayIndexOutOfBoundsException error
// To access an index use []

// int [] array = new int[5]; // array index 0 to 4 ( or length - 1). array is comprised of type int values defaulted to = {0,0,0,0,0}
//int[] myNumbers ={5,4,3,2,1} // initializing an anonymous array
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);

    }
    public static int[] getIntegers(int number){
        System.out.println("Enter "+ number +" integers"); // requesting user to enter x amount of integer values
        int[] values = new int[number]; // initializing a new int array and assigning the # of elements to the passed "number" variable
        // values.length is set above in new int[number], number reps the value.length
        for(int i=0; i<number; i++){
            values[i] = scanner.nextInt();
        } return values;
    }
    public static int[] sortIntegers(int[] array){

        for (int i=0; i<array.length; i++){
            int temp = array[i];
            int currentIndex = i;
            for (int j=i+1; j<array.length; j++){
                int temp2 = array[j];
                if ( temp < temp2 ){ // sorting the array from largest to smallest values
                    temp = temp2;
                    currentIndex = j;
                }
            }
            array[currentIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
    public static void printArray(int[] mySortedIntegers){
        for(int i=0;i <mySortedIntegers.length; i++){
            System.out.println("Element "+ i + " value is "+ mySortedIntegers[i]);
        }
    }

}
