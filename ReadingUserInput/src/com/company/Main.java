package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();
//        userInputMinAndMax();
//        sumUsersTenInputtedNumbersShouldBeItsOwnClass();
//        nameAndBirthYearShouldBeItsOwnClass();
    }


    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in); // we can create as many scanners we need with key word: 'new'
        int counter = 0;
        int sum = 0;
        boolean isAnIntIsTrue = true;
        while (isAnIntIsTrue){
            int order = counter + 1; // counter starts at 0 so adding 1 makes 1st message
            System.out.println("Enter a number ");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt){ int number = scanner.nextInt();
                counter++; // only increments on valid number input & starts with 0
                sum += number;
            } else {isAnIntIsTrue = false;
            } scanner.nextLine();
        }
        System.out.println(counter);
        long average = Math.round(sum / counter);
        System.out.println("sum = "+ sum + " & average = "+ average);
        scanner.close();
    }

    public static void userInputMinAndMax(){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int min = 0;
        int max = 0;
//        int max = 2147483647; extreme ends of both min and mac of ints
//        int min = -2147483648;
//        int max = Integer.MAX_VALUE;  //extreme ends of both min and mac of ints
//        int min = Integer.MIN_VALUE;
        boolean first = true;

        while(counter < 3){
            System.out.println("Enter number: ");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt){ int number = scanner.nextInt();
                counter++; // only increments on valid number input & starts with 0
                if (first){first= false; min = number; max=number;} // only happens on the first input
                if (number > max){ max = number;}
                if (number < min){min = number;}
            } else {System.out.println("Invalid number");
            } scanner.nextLine();
        }
        System.out.println("min = "+ min +" and max = "+ max);
        scanner.close();
    }

    public static void sumUsersTenInputtedNumbersShouldBeItsOwnClass(){
        Scanner scanner = new Scanner(System.in); // we can create as many scanners we need with key word: 'new'
        int counter = 0;
        int sum = 0;

        while (counter < 10){
            int order = counter + 1; // counter starts at 0 so adding 1 makes 1st message
            System.out.println("Enter number #"+ order + ":");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt){ int number = scanner.nextInt();
                counter++; // only increments on valid number input & starts with 0
                sum += number;
                //if(counter == 10){break;} // setting the counter to = 10, only needed if while (true){}
            } else {System.out.println("Invalid number");
            } scanner.nextLine();
        }
        System.out.println("sum = "+ sum);
        scanner.close();
    }

    public static void nameAndBirthYearShouldBeItsOwnClass(){

        // Scanner(System.in) allows to type input into the console and use the inputted value within our program
        Scanner scanner = new Scanner(System.in); // we can create as many scanners we need with key word: 'new'
        System.out.println("Enter your year of birth: ");

        boolean hasNextInt = scanner.hasNextInt(); //checks to see if the next input is an int
        if(hasNextInt) {

            int yearOfBirth = scanner.nextInt(); // assigned inputted value to yearOfBirth as an int instead of a String
            scanner.nextLine(); // handle next line character: 'Enter' key so it doesn't skip over, allowing any new input
            // to go smoothly
            System.out.println("Enter your name: ");
            String name = scanner.nextLine(); // reading the line we inputted from the console and assigning it to name
            int age = 2020 - yearOfBirth; // calculating current age RECALL put year of birth 1995

            if (age >= 0 && age <= 125) { // checking the range of age
                System.out.println("Your name is " + name + ", and you are " + age + " years old");
            } else System.out.println("Invalid year of birth");

        } else {
            System.out.println("Unable to parse year of birth.");
        }
        scanner.close();}
}


