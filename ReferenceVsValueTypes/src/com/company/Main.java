package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
		int myIntValue = 10;
		int anotherIntValue = myIntValue;
		System.out.println("myIntValue:" +myIntValue + " & anotherIntValue:" + anotherIntValue);
		anotherIntValue++; // only applied to anotherIntValue and not myIntValue
		System.out.println("myIntValue:" +myIntValue + " & anotherIntValue:" + anotherIntValue);


		int[] myIntArray = new int[5]; // myIntArray is a reference type which is a type that is used by a reference.
			// so in this case the variable: "myIntArray" holds a reference to new int[5]
		int[] anotherArray = myIntArray; // anotherArray is another reference type and here the two arrays are now equal to each other.

		System.out.println("myIntArray= "+ Arrays.toString(myIntArray)); // Arrays.toString displays all of the content of an array
		System.out.println("myIntArray= "+ Arrays.toString(anotherArray)); // like so: myIntArray= [0, 0, 0, 0, 0]
		anotherArray[0] = 1;
		System.out.println("after anotherArray[0] = 1, myIntArray= "+ Arrays.toString(myIntArray)); // myIntArray= [0, 0, 0, 0, 0]
		System.out.println("after anotherArray[0] = 1, anotherArray= "+ Arrays.toString(anotherArray)); // anotherArray= [0, 0, 0, 0, 0]
		anotherArray = new int[]{4, 5, 6, 7, 8}; // now we are de-referencing the variable anotherArray by using the "new" keyword
												// to assign it to the new array int[]{4, 5, 6, 7, 8}
		modifyArray(myIntArray); // changing the first index of the array (0) = 2
		System.out.println("after modifyArray(myIntArray), myIntArray= "+ Arrays.toString(myIntArray)); // myIntArray= [0, 0, 0, 0, 0]
		System.out.println("after modifyArray(myIntArray), anotherArray= "+ Arrays.toString(anotherArray)); // anotherArray= [0, 0, 0, 0, 0]


	}

	private static void modifyArray(int[] array){
		array[0] = 2;
		array = new int[] {1, 2, 3, 4, 5};
	}

}
