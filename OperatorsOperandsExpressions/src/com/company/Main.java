package com.company;

public class Main {
    // Operand - any object that is manipulated by an operator
    // For ex: int myVar = 15 + 12;
    // + is the operator & 15 and 12 are the operands
    // For ex: int myVar = 7 * 2;
    // * is the operator & 7 and 2 are the operands

    // Expressions are formed by combining variables, literals, method return values and operators
    // 15 + 12 is the expression above and the value returned is 27.
    // In double mySalary = hoursWorked * hourlyRate; hoursWorked * hourlyRate is the expression


    public static void main(String[] args) {
        int result = 1 + 2;
        System.out.println("1 + 2 = "+ result);
        result = result * 10; // 30
        System.out.println("3 * 10 =" + result);
        result = result / 1; // 30
        System.out.println("30/1 = " + result);
        result = result % 3; // 30/3 = 3 with no remainder so 0
        System.out.println("3 with a remainder of " + result);

        result++; //same increment as Python and Js, 0 incremented up by 1 = 1
        System.out.println("0 incremented up by 1 = " + result);
        result--; //same increment as Python and Js, 0 incremented down by 1 = 0
        System.out.println("0 incremented down by 1 = " + result);

        result += 2; // result = result + 2 or result += 2
        System.out.println("result += 2 or result + 2 = result = " + result); //2
        result *= 10; // result = result * 10 or result += 10
        System.out.println("result *= 10 or result * 10 = result = " + result); // 20
        result /= 4; // result /= 4 or result / 4 = result
        System.out.println("result /= 4 or result / 4 = result = " + result); // 5

        // if-then statement is conditional logic
        boolean isAlien = false;
        if (isAlien == false) { // here "==" is strict comparison like in JS "===" is
            System.out.println("It is not an alien!"); // here I'm finally using white space and indenting
            System.out.println("Am I scared of aliens!");
        }

        int topScore = 100;
        if (topScore > 100){
            System.out.println("You got the high score!");
        }

        topScore = 80;
        int secondTopScore = 60;
        if (topScore > secondTopScore && topScore < 100) {
            System.out.println("You got the second highest score: " + topScore);
        }

        boolean isCar = false;
//        if(isCar = true){ // make sure to always use '==' instead of '=' when evaluating truth statements
//            System.out.println("This is not supposed to happen "); // here the if statement is actually assigning isCar to true
//        }
        if ( isCar != true) { // in Java != takes place of JS's !==
            System.out.println("Still can;t find your car huh?");
            boolean wasCar = !isCar ? true : false;
            if (wasCar){
                System.out.println("What happened you use to have a car?");
            }
        }

        int ageOfClient = 20;
        boolean isEighteenOrOver = ageOfClient >= 18? true: false;
        System.out.println("is the client 18 or over? Response:" + isEighteenOrOver);

        //Operator challenge
        double firstVar = 20.00d;
        double secondVar = 80.00d;
        boolean isRemainderZero = (((firstVar + secondVar) * 100.00 ) % 40.00) == 0? true: false; //250 no remainder
        System.out.println("isRemainderZero:" + isRemainderZero);
        if (!isRemainderZero){
            System.out.println("Got some remainder");
        }
    }
}
