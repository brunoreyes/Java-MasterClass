package com.company;

import java.util.Locale;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    private static final Integer INVALID_VALUE = -1;
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

        System.out.println("---------------------------------");
        System.out.println("printDayOfTheWeek Test");
        printDayOfTheWeek(7);
        printDayOfTheWeek(10);

        System.out.println("---------------------------------");
        System.out.println("printNumberInWord Test");
        printNumberInWord(1);
        printNumberInWord(10);

        System.out.println("---------------------------------");
        System.out.println("isLeapYear Test");
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));

        System.out.println("---------------------------------");
        System.out.println("getDaysInMonth Test");
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

        System.out.println("---------------------------------");
        System.out.println("isOdd Test");
        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd(-1));

        System.out.println("---------------------------------");
        System.out.println("sumOdd Test");
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

        System.out.println("---------------------------------");
        System.out.println("sumDigits Test");
        System.out.println(sumDigits(2199918));
        System.out.println(sumDigits(1));

        System.out.println("---------------------------------");
        System.out.println("isPalindrome Test");
        System.out.println(isPalindrome(2199918));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));

        System.out.println("---------------------------------");
        System.out.println("sumFirstAndLastDigit Test");
        System.out.println(sumFirstAndLastDigit(121));
        System.out.println(sumFirstAndLastDigit(-121)); // returns -1 for invalid
        System.out.println(sumFirstAndLastDigit(5)); // returns 10 (5+5 since first and last digit are the same)
        System.out.println(sumFirstAndLastDigit(999));

        System.out.println("---------------------------------");
        System.out.println("getAndSumEvenDigits Test");
        System.out.println(getAndSumEvenDigits(888));
        System.out.println(getAndSumEvenDigits(120));
        System.out.println(getAndSumEvenDigits(-120));

        System.out.println("---------------------------------");
        System.out.println("hasSharedDigit Test");
        System.out.println(hasSharedDigit(45,50));
        System.out.println(hasSharedDigit(40,50));
        System.out.println(hasSharedDigit(10,99));
        System.out.println(hasSharedDigit(9,99));

        System.out.println("---------------------------------");
        System.out.println("hasSameLastDigit Test");
        System.out.println(hasSameLastDigit(9,99,999));
        System.out.println(hasSameLastDigit(89,98,98));
        System.out.println(hasSameLastDigit(19,29,79));
        System.out.println(hasSameLastDigit(1,29,-79));

        System.out.println("---------------------------------");
        System.out.println("getGreatestCommonDenominator Test");
        System.out.println(getGreatestCommonDenominator(36,18));
        System.out.println(getGreatestCommonDenominator(17,19));
        System.out.println(getGreatestCommonDenominator(7,19));
        System.out.println(getGreatestCommonDenominator(17,9));

        System.out.println("---------------------------------");
        System.out.println("printFactors Test");
        printFactors(2);
        printFactors(4);
        printFactors(7);
        printFactors(-1);

        System.out.println("---------------------------------");
        System.out.println("isPerfectNumber Test");
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(8));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(-1));

        System.out.println("---------------------------------");
        System.out.println("getDigitCount Test");
        System.out.println(getDigitCount(23));
        System.out.println(getDigitCount(2334));
        System.out.println(getDigitCount(233));
        System.out.println(getDigitCount(2));
        System.out.println(getDigitCount(-23));

        System.out.println("---------------------------------");
        System.out.println("reverse Test");
        System.out.println(reverse(42));
        System.out.println(reverse(4202));
        System.out.println(reverse(-4202));
        System.out.println(reverse(23));

        numberToWords(302);
        numberToWords(100);
        numberToWords(-100);

        System.out.println(canPack(2,1,11));
        System.out.println(canPack(2,-1,11));
        System.out.println(canPack(-2,1,11));
        System.out.println(canPack(2,1,-1));
        System.out.println(canPack(1,2,7));
        System.out.println(canPack(1,3,7));
        System.out.println(canPack(10,60,50));

        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
        System.out.println(getLargestPrime(17));


        printSquareStar(10);
        printSquareStar(4);

        System.out.println(getBucketCount(200,200,10));
        System.out.println(getBucketCount(200,10));
        System.out.println(getBucketCount(200,200,10,30));

    }

    public static boolean canPack(int bigCount, int smallCount,int goal){
        if ( bigCount < 0 || smallCount < 0 || goal < 0 ) { // big count = 5, small count = 1, big + small == goal
            return false;
            // it's okay if additional smallCount bags exceed the goal but not bigCount
        } bigCount *= 5; // making bigPack 5 x more than smallCount
        return (bigCount + smallCount) >= goal && smallCount >= goal % 5;
    }

    // a prime number is a natural number greater than 1 but isn't the product of two smaller numbers
    // so a prime number isn't the product of two numbers not accounting for 1 being one of the numbers
    public static int getLargestPrime(int number){
        if(number < 2) return -1; // a prime number can't be 1 or a negative number
        int unChangedNumberValue = number;
        for(int i=number/2; i>1; i--){ //we start off from half the number, work down by 1 until !i>1
            if(number % i == 0) number = i;
        } return number == unChangedNumberValue? -1 : number; // if largest prime number = number return -1
    }

    public static void printSquareStar(int num){
        if (num < 5) System.out.println(INVALID_VALUE_MESSAGE);
        else {
            for(int row = 0; row < num; row++){
                for(int col = 0; col <num; col++ ) { // nested for loop
                    if(row == 0 || row == num - 1 || col == 0 || col == num - 1 || row == col || row + col == num -1 ){
                        System.out.print("*"); // print() prints a space and does not move to another line
                    } else {
                        System.out.print(" ");}
                }
                System.out.println();  // moving to another line can be done with an empty println() call
            }
        }
    } //output:
    //**********
    //**      **
    //* *    * *
    //*  *  *  *
    //*   **   *
    //*   **   *
    //*  *  *  *
    //* *    * *
    //**      **
    //**********

    // overload function
    public static int getBucketCount(double width,double height,double areaPerBucket,int extraBuckets){
        if(width<=0||height<=0||areaPerBucket<=0||extraBuckets<0) return -1;
        return (int)Math.ceil((height*width)/areaPerBucket)-extraBuckets;
    }
    public static int getBucketCount(double width,double height,double areaPerBucket){
        return getBucketCount(width, height, areaPerBucket,0);
    }
    public static int getBucketCount(double area,double areaPerBucket){
        return getBucketCount(area,1,areaPerBucket);//area=width*height
    }

    //sumDigits of a number
    public static int sumDigits(int number){ // quotient is two numbers divided
        if(number >= 10){
            int sum = 0; // initializing variable sum outside and before the while loop
            while (number != 0){ // while number isn't 0 keep the loop going,
                // number = 0 when number is less than 10, for ex: with 9, number = number/10 or 9 = 9 / 10 = 0,
                sum += number % 10; // getting the last integer from a number using remainder. For ex: 219 is 9
                number /= 10; // decreasing the number by a tenth. For ex: 289 becomes 28
            } return sum;
        } else return -1; // take into account single digit and negative numbers
    }

    // palindrome is 12321 or 14541, a number that's the same in reverse
    public static boolean isPalindrome(int number){
        int regularNumber = number; // unchanged value of number that we compare reverse to after the while loop finishes
        int reverse = 0;
            while (number != 0 || number < 0) {
            // '-' a negative int doesn't change the outcome b/c the negative is carried within the remainder numbers within the reverse function
                int lastDigit = number % 10; // gathering last digit of number
                reverse = (reverse * 10) + lastDigit; // increasing the place value of reverse & adding the last digit to reverse
                number /= 10; // removing the last digit of number by dividing it by 10. for ex: 111/10 == 11 w/ no remainder
            } return regularNumber == reverse;
    }

    public static int sumFirstAndLastDigit(int number){ // palindrome is 12321 or 14541, a number that's the same in reverse
        if (number < 0) {
            return -1;
        }
        int first = number;
        int last = number % 10; // if 435, 435 % 10 = remainder of 5 ( last number of int)
            while(first >=10){ // 1st loop: 435/10 = 43, 2nd loop: 43/10 = 4, since 4 is < 10, loop stops & first = 4 (first number of int)
                first /= 10; // dividing the variable by 10, decreasing by 1 tenth everytime
            } return first + last; // sum of first and last digit
    }

    public static int getAndSumEvenDigits(int number){
        if (number < 0){
            return -1;
        }
        int sum = 0;
        while ( number > 0){ // condition: goes until number reaches 0
            // 121 lp1: numToChk=1 > not added to sum > number = 12, lp2: numToChk=2 > sum +=2 > num = 1
            int numToCheck = number % 10;
            if (numToCheck % 2 == 0){
                sum += numToCheck;
            } number /= 10; // incrementing down by a tenth
        } return sum;
    }


    public static boolean hasSharedDigit(int firstNumber, int lastNumber) {
        int firstNumberRemainder = 0;
        int lastNumberRemainder = 0;
        int lastNumberReset = lastNumber;
        if ((firstNumber < 10 || firstNumber > 99)
                || (lastNumber < 10 || lastNumber > 99)) { //all if conditionals false, so skips down to else line 9
            return false;
        } else {
            while (firstNumber > 0) {  //outer while loop, first time through 34 > 0, true continues
                firstNumberRemainder = firstNumber % 10;  //34 % 10 = 4
                lastNumber = lastNumberReset;  //23 = 23 resets when inner loop has finished executing, so in second iteration firstNumber digit 3 will be compared to each digit in last number when goes through the inner while loop again
                while (lastNumber > 0) {  //inner while loop 23 > 0, true, inner loop will run twice, second time 2 > 0, true
                    lastNumberRemainder = lastNumber % 10; //first iteration 23 % 10 = 3, second time 2 % 10 = 2
                    if (lastNumberRemainder == firstNumberRemainder) {  // first iteration 4 != 3, second time 4 != 2, skips down to line 18
                        return true;
                    } lastNumber = lastNumber / 10;  //after first iteration 23 becomes 2, second iteration 2 becomes 0; inner while loop completes, skips to line 20
                } firstNumber = firstNumber / 10;  //34 becomes 3, outer while loop runs second iteration
            }
        }
        return lastNumberRemainder == firstNumberRemainder;  //the second time through the outer while loop 3 == 3 in the first time through the inner while loop and return true
    }

    public static boolean hasSameLastDigit(int numOne, int numTwo, int numThree){
        if ((numOne < 10 && numOne > 1000) && (numTwo < 10 && numTwo > 1000) && (numThree < 10 && numThree > 1000)){
            return false;
        } else {
            int lastNumOne = numOne % 10;
            int lastNumTwo = numTwo % 10;
            int lastNumThree = numThree % 10;
            return lastNumOne == lastNumTwo && lastNumTwo == lastNumThree;
            }
        }

    public static int getGreatestCommonDenominator(int one, int two){
        // neither one or two can be less than 10 or else return -1 for invalid
        if (one < 10 || two < 10){
            return -1;
            // finding the smallest of one & two & iterating down by 1, find the GCD (greatest common denominator/factor/divisor) first
            // (rather than finding the LCD), only returning i if divisible by both one and two with no remainder.
        } for(int i = Math.min(one,two); i >= 1; i--){ // in some cases like one:19 & two:17, 1 will be the GCD
            if (one % i == 0 && two % i == 0)
                return i;
        } return -1;
    }

    // factors are numbers which divide wholly without leaving a remainder: factor of 4 is: 4,2,1
    public static void printFactors(int number){
        if (number < 1){
            System.out.println(INVALID_VALUE_MESSAGE);
        } for (int i = number; i >=1; i--){
            if (number % i == 0){
                System.out.println(i);
            }
        }
    }

    // a Perfect number is a number which is equal to the sum of it's proper positive divisors: for ex 6: 6 % 3,2,1 = 0, & 3+2+1 = 6
    public static boolean isPerfectNumber(int number){
        if(number < 1){
            return false;
        }
        int sum = 0;
        for (int i = 1; i < number; i++){ // starting from 1 and incrementing up to but not including number: for ex 6: 1,2,3 but not 6
            if(number % i == 0){
                sum += i;
            }
        } //        System.out.println(sum);
        return sum == number;
    }

    public static int getDigitCount(int number){
        if (number < 0){
            return -1;
        } int count = 0;
        while( number > 0){
            count++;
            number /= 10;
        } return count;
    }

    public static int reverse(int number) {
        if (number < 0) {
            return -1;
        }
        int reverse = 0;
        while (number != 0) {
            int lastDigit = number % 10; // gathering last digit of number
            reverse = (reverse * 10) + lastDigit; // increasing the place value of reverse & adding the last digit to reverse
            number /= 10; // removing the last digit of number by dividing it by 10. for ex: 111/10 == 11 w/ no remainder
        } return reverse;
    }

    public static void numberToWords(int number){
        if (number < 0){
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {
            int numberLength = getDigitCount(number); // digit count ensures that we get all digits for a number like 100, 3 digits total
            int numberReversed = reverse(number); // numberLength protects against numberReversed = 1 coming from number: 100
            // we reverse the number once, and reverse them again when we grab lastDigit
            //System.out.println(reverse(number));
            while (numberLength > 0){ // condition
                // until the numberLength turns into 0 which is no longer greater than zero.
                    int lastDigit = numberReversed % 10;
                    numberLength --; //increment
                    switch (lastDigit){
                        case 1:
                            System.out.println("one");
                            break;
                        case 2:
                            System.out.println("two");
                            break;
                        case 3:
                            System.out.println("three");
                            break;
                        case 4:
                            System.out.println("four");
                            break;
                        case 5:
                            System.out.println("five");
                            break;
                        case 6:
                            System.out.println("six");
                            break;
                        case 7:
                            System.out.println("seven");
                            break;
                        case 8:
                            System.out.println("eight");
                            break;
                        case 9:
                            System.out.println("nine");
                            break;
                        default:
                            System.out.println("zero");
                            break;
                    }
                numberReversed /= 10; // moving numberReversed decimal place left by one.
            }
        }
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
