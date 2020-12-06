package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// Control flow statements: switch, for, while and do-while
        // if, else if, and else
        int value = 2; // 1 // 3
        if (value == 1){
            System.out.println("Value was 1");
        } else if ( value == 2){
            System.out.println("Value was 2");
        } else {
            System.out.println("Value was not 1 or 2");
        }

        // Switch statement equivalent of the above if else statement
        int switchValue = 3; // testing out 2 and 3 as well (3 is neither 1 or 2)
        // Best to use switch when testing different values for the same variable
        switch(switchValue){
            case 1: // the 1 in case 1: indicates the value of the variable
                System.out.println("Value was 1");
                break; // terminates the enclosing switch statement and runs code that comes after the full switch function
            case 2:
                System.out.println("Value was 2");
                break; // Always to remember to place a "break" at the end of each case
            case 3:case 4:case 5: // here we are testing out if the value of the variable is 3,4, or 5
                // and giving a generalized message for the 3-5
//                System.out.println("was a 3 or 4 or 5");
                System.out.println(switchValue + " was found"); // the actual value
                break;
            default: // equivalent to keyword "else"
                System.out.println("Value wasn't 1,2,3,4,5");
                break; // leave in however it's not necessary on the last default since its the last statement to run
        }
        // code continues to be processed starting here after a break

        char switchChar = 'A'; // char values are wrapped around single quotes instead of string's double quotes
        switch(switchChar){
            case 'A':case 'B':case 'C':case 'D':case 'E':
                System.out.println( "switchChar: " + switchChar + " was found"); // the actual value
                break;
            default:
                System.out.println("Switch char wasn't found");
                break; // not needed but is kept
        }

        String jMonth = "january";
        switch(jMonth.toLowerCase()){ // toLowerCase will generalize String, in case user types capitals or uppercase
            case "january": // now all the cases will work if they're all in lower case
                System.out.println( "Jan");
                break;
            case "june":
                System.out.println( "Jun");
                break;
            case "july":
                System.out.println( "Jul");
                break;
            default:
                System.out.println("No months beginning with J found");
                break; // not needed but is kept
        }
        printDayOfTheWeek(7);
        printDayOfTheWeek(10);
        printNumberInWord(1);
        printNumberInWord(10);
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));

        System.out.println(getDaysInMonth(1,2020));
        System.out.println(getDaysInMonth(2,2020)); //accounts for leap year w/ Feb = 29
        System.out.println(getDaysInMonth(2,2018));
        System.out.println(getDaysInMonth(-1,2018));
        System.out.println(getDaysInMonth(2,-2020));

//           for statement is called the for loop: repeatedly loops something until a particular condition is satisfied
        //for(init; termination; increment){ // like python and js for loop, start, end, increment by
//            for(int i=2; i<9; i+=2) // start at 2, go to 8, by 2
//            for(int i=8; i=>2; i--) start at 8, and work back to two

        // using a for loop we can calculate the interest rate from 1-5% in one line
        for(int i=0; i<5; i++){ // int, condition, increment
            System.out.println("120 at interest rate of " + i
                    + "% = " + String.format("%.2f", calculateInterest( 120, i)) );
            //string.format("%.2f,number) converts number to only having two decimals
        }

        // if I find three prime numbers in a range of numbers, the loop is exited
        int count = 0;
        for(int i=1; i<10; i++){ // everytime the loop goes through is called an iteration
            if(isPrime(i)){
                count++;
                System.out.println("Number " + i + " is a prime number");
                if (count == 3){
                    System.out.println("3 prime numbers have been found now exiting loop");
                    break;
                }
            }
        }

        // function that finds numbers that are both divisible by 3 & 5 out of a range of numbers and
//        breaks out of the loop when 5 divisible numbers are found and sums them together.
        int countNumDivByThreeAndFive = 0;
        int sum = 0;
        for(int i=1; i<=1000; i++){

            if((i % 3 == 0) && (i % 5 == 0)){
                countNumDivByThreeAndFive++;
                sum += i;
                System.out.println(i + " is divisible by both 3 & 5");
            }
            if(countNumDivByThreeAndFive == 5){
                break;
            }
        }
        System.out.println(sum + " is the sum of all number divisible by both 3 & 5");

        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd(-1));
        System.out.println(sumOdd(2,5));
        System.out.println(sumOdd(-2,5));

        // while loop going from 1 to 5
        int countValue = 1;
        while(countValue != 6){
            System.out.println("Count value is "+ countValue);
            countValue++; // remember to increment the count or you'll get an infinite loop
        }

        // FOR LOOP isn't identical to the top
        for(countValue = 1; countValue !=6; countValue++){
            System.out.println("Count value is "+ countValue);
        }

//        or this version of the while loop
        countValue = 1; // int
        while (true){ // condition
            if(countValue == 6){
                // when if statement comes before the count increment and print it'll only go up to 5
                break;
            }
            System.out.println("Count value is "+ countValue);
            countValue++;// increment
        }

//        while do statements
        countValue = 1; // resetting countValue to = 1
        do { // do while will always execute at least once
            System.out.println("Count value is "+ countValue);
            countValue++;

//            if(count>100){
//                break;
//            }

        } while(countValue !=6); // for do while loop, ";" is required after the do {statement} while(condition)

        int number = 4;
        int finishNumber = 20;
        int countEven = 0;
        // while (condition) { statement }: while loop will run as long as the condition is satisfied
        while (number <= finishNumber){
            number++;

            if(!isEven(number)){
                continue; // if false by pass the print statement for even numbers
            }
            countEven++;
            System.out.println("Even number "+ number);
            if(countEven == 5){
                System.out.println(countEven + " Even numbers were found" );
                break;
            }
        }

        System.out.println(sumDigits(211));
    }

    //sumDigits of a number
    public static int sumDigits(int number){
        if(number >= 10 && number <100){
            int remainder = number % 10;
            int quotient = number / 10;
            int sum = remainder + quotient;
            return sum;
        if(number >= 100 && number < 1000)
            int first = number % 100;
        } else return -1; // take into account single digit and negative numbers
    }


    public static double calculateInterest(double amount, double interestRate ) {
        return (amount *(interestRate/100));
    }

    // a prime number is a natural number greater than 1 but isn't the product of two smaller numbers
    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2; i <= (long) Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isOdd(int number){
        if (number > 0){
            return number % 2 !=0;
        } else return false;
    }

    // find all odd numbers in a range and find their sum
    public static int sumOdd(int start, int end){
        if (start > 0 && end >= start && end > 0){
            int sum = 0;
            for(int i = start; i <= end; i++){
                if(isOdd(i)){
                    sum += i;
                }
            }
            return sum;
        } else return -1;
    }


    public static boolean isEven(int number){
        if (number > 0){
            return number % 2 == 0; // returns true or false
        } else return false;
    }

    public static void printDayOfTheWeek(int day) {
        switch (day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Day");
                break;
        }
    }


    public static void printNumberInWord(int number) {
        switch (number){
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }
    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999){
            return (( year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
        } else return false;
    }

    public static int getDaysInMonth(int month, int year ) {
        if ((year >= 1 && year <= 9999) && (month >= 1 && month <= 12)) {
            int daysOfMonth = 0;
            switch (month) {
                case 1:case 3:case 5:case 7: case 8:case 10:case 12:
                    daysOfMonth = 31; // return ends a switch statement as well
                    break;
                case 4:case 6:case 9: case 11:
                    daysOfMonth = 30;
                    break;
                case 2:
                    daysOfMonth = (isLeapYear(year) ? 29 : 28);
                default:
                    break;
            }
        return daysOfMonth;
        } else return -1;
    }



}
