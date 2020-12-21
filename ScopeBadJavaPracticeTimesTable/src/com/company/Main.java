package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write a small program to read an integer from the keyboard
        // (using Scanner) and print out the times table for that number.
        // The table should run from 1 to 12.
        //
        // You are allowed to use one variable called scanner for your
        // Scanner instance. You can use as many other variables as you
        // need, but they must must all be called x. That includes any
        // class instances and loop control variables that you may decide
        // to use.
        //
        // If you use a class, the class can be called X (capital), but
        // any instances of it must be called x (lower case).
        //
        // Any methods you create must also be called x.
        //
        // Optional Extra:
        // Change your program so that ALL variables (including the scanner
        // instance) are called x.

//        Placed scanner functionality within class X's constructor
//        Scanner scanner = new Scanner(System.in); // creating a scanner to allow user to input number via keyboard
//        System.out.println("Please enter a number"); // prompting user with a call-to-action
//        X x = new X(scanner.nextInt());  // creating an instance of the class X and passing user's inputted # as param

        X x = new X(new Scanner(System.in)); // creating instance of class X & passing user's input to X's constructor
        x.x();  // calling the instance method x of Class x to get times table of 12 of user's inputted #
    }
}
