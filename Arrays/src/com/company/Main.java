package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //int[] myIntArrayVariable = {1,2,3,4,5,6,7,8,9,10}; // only applicable to assign element values and # of elements at initiation
        // 9 elements, starting at 0. (element's index position: corresponding value): 0:1, 1:2, 2:3, 3:4, 4:5, 5:6, 6:7, 7:8, 8:9, 9:10)

         int[] myIntArrayVariable = new int[10]; // defined an int-type array and assigning 10 elements to the array

        // myIntArrayVariable[5] = 50; // changing array element #6's value of 50  (array elements start count at position 0)

        //double[] myDoubleArrayVariable = new double[10]; // creating the same version above in double-type
        //System.out.println(myIntArrayVariable[5]); // retrieving value for array element #6

        for (int i=0; i < myIntArrayVariable.length; i++){ // array index 9 = 90 b/c start at 0;
            myIntArrayVariable[i] = i * 10;
        }
        for(int i=0; i < myIntArrayVariable.length;i++){
            System.out.println("Element Index " + i +" val = " + myIntArrayVariable[i] ); // val is short for value
            // i is the index, myIntArrayVariable[i] is the variable
        }


        // User Input Example for finding the average of a set of #'s
        int[] myIntegers = getIntegers(5); // setting the # of elements allowed 5 inputted numbers, (index 0-4)
        for (int i=0; i < myIntegers.length; i++){
            System.out.println("#" + i +" val = " + myIntegers[i] );
        }
        System.out.println("The Average of the "+ myIntegers.length + " numbers is "+ getAverage(myIntegers));
    }
    private static Scanner scanner = new Scanner(System.in); // outside of main method but inside of Main Class
    // To use Scanner in public static method ensure to place static within initiation of Scanner

    public static int[] getIntegers(int number){
        System.out.println("Enter "+ number + " integer values.\r");
        int[] values = new int[number];

        for (int i=0; i<values.length; i++){
            values[i] = scanner.nextInt(); // Like nextLine(), nextInt() takes in a user's input,
                                            //  in this case the scanner expects an int.
                                            // The process is looped around until 5 values are inputted ( # of values set
                                            //  at initiation of myIntegers int array set to getIntegers(5) above
        } return values;
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for(int i=0; i< array.length; i++){
            sum += array[i];
        } return (double) sum / (double) array.length;
    }

}
