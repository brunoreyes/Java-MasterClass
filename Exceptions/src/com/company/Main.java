package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// L.B.Y.L. - Look Before You Leap, more common in Java, testing for not null before using
//        if else

    // E.A.F.P. - Easy to Ask for Forgiveness than Permission
    //        try and catch

//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));

//        System.out.println(divide(x,y)); will crash if run

//        int x = getInt();
//        int x = getIntLBYL(); // best for this scenario just because it's more straight forward logic
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for (int i=0; i<input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){ // checking to see if user input is a digit
                isValid = false;
                break;
            }
        }
        if (isValid){
            return Integer.parseInt(input);
        }
        return 0; // if input wasn't a digit, we return 0.
    }

    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        System.out.printf("Please enter an integer ");
        try {
            return s.nextInt();
        } catch (InputMismatchException e){ // if input isn't matched or isn't an int
            return 0;
        }
    }

    private static int divideLBYL(int x, int y){
        if (y != 0){
            return x/y;
        } else {
            return 0;
        }
    }
    private static int divideEAFP(int x, int y){
        try {
            return x/y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x/y; // program will crash w/o either E.A.F.P. or L.B.Y.L.
    }
}
