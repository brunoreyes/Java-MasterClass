package com.company;

public class Main {

    // There's nothing to prevent a static method from accessing  non-static fields (vars) or methods
    // b/c it creates an instance of a class in order to do so.
    public static int multiplier = 7;

    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number "+ StaticTest.getNumInstances());
        // output: 1                              // using get as a static method helps not having to create new instances


        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
        // output: 2

        // java com.company.-static.main running static from command line

        int answer = multiply(6); // can't be used when method multiply isn't static
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier); // can't be used when var multiplier isn't static
    }

    public static int multiply(int number){
        return number * multiplier;
    }
}
