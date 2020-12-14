package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter count:"); // prompt for user to enter the amount of numbers to count:
                                            // for ex: if 3: then [x,y,z] for 3 numbers

        int count = scanner.nextInt(); // collecting the initial count of numbers the user wants to input
        scanner.nextLine();

        int[] returnedArray = readIntegers(count); // the array of numbers that were inputted by the user.
                                                    // where the array.length = count that was set by user above
        int returnedMin = findMin(returnedArray);

        System.out.println("From: "+ Arrays.toString(returnedArray) +", the min = " + returnedMin);
    }               // output for count of 5, and inputted #'s 1,2,3,4,5: Out of list of numbers [5, 4, 3, 2, 1] the min = 1

    private static int[] readIntegers(int count){

        int[] array = new int[count];

        for (int i=0; i<array.length; i++){ // loops continually getting inputs from user as long as: i < array.length
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number; // assigning the value inputted by the user to the proper index of the array: array[0] = 1
        }
        return array; // after the for loops is completed, the array should have all index's filled with a value
                        // and now the array is ready to be sent with filled values.
    }
    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE; // min starts as the highest possible value an int can be

        for(int i=0; i < array.length; i++){
            int value = array[i]; // checking each index of the array

            if(value < min){
                min = value; // if the value (checked index of the array) is less than the min, it becomes the new min
                            // this process continues until all values in the array are checked
            }
        }
        return min; // this min should now be the smallest value of the entire array
    }
}
