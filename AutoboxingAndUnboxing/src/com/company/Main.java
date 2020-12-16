package com.company;

import java.util.ArrayList;


// Autoboxing makes it easier to utilize primitive types as objects

// unlike having to manually create whole new class types like the case of IntClass here:
class IntClass {
    // the int-type variable myValue is in a wrapper; only able to be modified via access modifiers
    // like constructors or setters but not directly.
    private int myValue;

    public int getMyValue() {
        return myValue;
    }

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
public class Main {

    public static void main(String[] args) { // recall String is a class and not a primitive type.
	    String[] stringArray = new String[10]; // An array comprised of 10 String elements
	    int[] intArray = new int[10]; // An array comprised of 10 int elements

	    ArrayList<String> stringArrayList = new ArrayList<String>(); // a String type arrayList
        stringArrayList.add("Bruno"); // adding a String to the ArrayList

        // ArrayList can be of class types like Strings but not primitive types like ints
        // But I can create a class that takes in ints and use it for the ArrayList
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54)); // creating the 1st element in the arrayList,
                                                        // an object with type IntClass, a value of 54,
                                                        // created from the IntClass above Main

        // Autoboxing Examples:

        Integer integer = new Integer(55); // Integer is a class where int is just a primitive type
        //The Integer class wraps a value of the primitive type int in an object.
        // An object of type Integer contains a single field whose type is int

        Double doubleValue = new Double(2.2); // can't use keyword "double" so instead I used: doubleValue

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        // Long way
        for (int i = 0; i <= 10; i++){ // here we are preforming autoboxing with .valueOf()
            integerArrayList.add(Integer.valueOf(i)); // .valueOf() is taking the primitive type of i & converting it
                                                        // to the class Integer type of i.
        }

        for(int i = 0; i <= 10; i++){ // here we are doing the opposite of Autoboxing: unboxing
            // aka taking an element from the class (object wrapper) and converting it back to a primitive type
            System.out.println(i + " ==> " + integerArrayList.get(i).intValue());
        }

        // Short way: ( when Java take care of .intValue() and .valueOf() )

        // autoboxing
        Integer myIntValue = 56; // = Integer.valueOf(56); aka Java is doing the hard work during compile

        // unboxing
        int myInt = myIntValue; // = myIntValue.intValue();

        // Autoboxing: converting the primitive type (double) to the object wrapper ( Class Double)
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5){
            myDoubleValues.add(dbl); // adding the values to the arrayList: myDoubleValues
        }

        // Unboxing: Converting from the object wrapper (Class Double) back to the primitive value of double.
        for( int i = 0; i < myDoubleValues.size(); i++){
          double value = myDoubleValues.get(i);
          System.out.println(i + " --> " + value);
        }
    }
}
