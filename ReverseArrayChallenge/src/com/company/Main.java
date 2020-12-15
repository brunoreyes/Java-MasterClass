package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Array = "+ Arrays.toString((array)));

        reverse(array);
        System.out.println("Array = "+ Arrays.toString((array)));

    }
    private static void reverse(int[] array){

        int maxIndex = array.length - 1;
        int halfLength = array.length / 2; // since I am swapping elements, the 2nd half has already been
        // swapped with the 1st half so the array is already fully reversed halfway into the array

        for(int i=0; i < halfLength; i++){

            int temp = array[i]; // saving the element at index: i to the "temp" variable
            array[i] = array[maxIndex - i]; // moving the array index to = the highest index value.
            array[maxIndex - i] = temp; // the highest index value is now set to 1 (temp).

        } // as i progresses from 0 to the index of half of the length,  each element swaps with it's mirror element
    }
}
