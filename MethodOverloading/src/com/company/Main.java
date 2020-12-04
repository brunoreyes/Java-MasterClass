package com.company;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    private static final Integer INVALID_VALUE = -1;
        // final makes a variable constant or final so we can't change it anywhere
        //    static is for using variables in static methods
    public static void main(String[] args) {
        System.out.println("calculateScore");
        int newScore = calculateScore("Ernie",10);
        System.out.println("Ernie hacked the leaderboards and has a new score of "+ newScore +" points");
        calculateScore(75); // 2nd overloaded method of calculateScore
        calculateScore(); // 3rd overloaded method of calculateScore
        System.out.println("Ernie hacked the leaderboards and has a new score of "+ newScore +" points");
        System.out.println("--------------------");
        System.out.println("calcFeetAndInchesToCentimeters");
        calcFeetAndInchesToCentimeters(157);
        calcFeetAndInchesToCentimeters(13,1);
        System.out.println("--------------------");
        System.out.println("getDurationString");
        System.out.println( getDurationString(65L,45L));
        System.out.println( getDurationString(3945L));
        System.out.println( getDurationString(-1L)); // testing for invalid
        System.out.println( getDurationString(1L));
        // testing for seconds < 10 adding leading zero for single digits
        System.out.println("--------------------");
        System.out.println("area");
        System.out.println( area(10));
        System.out.println( area(-1));
        System.out.println( area(10,20));
        System.out.println( area(-1,20));
        System.out.println( area(1,-1));

        System.out.println("--------------------");
        System.out.println("printYearsAndDays");
        printYearsAndDays(2020202020);
        printYearsAndDays(-1);

        System.out.println("--------------------");
        System.out.println("printEqual");
        printEqual(-1,1,1);
        printEqual(1,-1,1);
        printEqual(1,1,-1);
        printEqual(1,1,1);
        printEqual(1,2,3);
        printEqual(1,1,2);

        System.out.println("--------------------");
        System.out.println("isCatPlaying");
        System.out.println(isCatPlaying(true, 40));
        System.out.println(isCatPlaying(true, 46));
        System.out.println(isCatPlaying(false, 25));
        System.out.println(isCatPlaying(false, 24));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(true, 24));




    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player "+ playerName + " scored "+ score + " points");
        return score * 1000;
    }

    // Method Overloading is when you have the same name for two methods but one has a dif # of parameters
    //  - It's a feature that allows to use the same method name so long as different arguments or parameters are used
    //  - Creating multiple methods with the same name and different implementations
    //  - Calls to an overloaded method will run a specific implementation of that method.
    //  - The overloaded method that's chosen is the one with which inputs match the # & type of parameters.

    //  println performs method overloading, bieng able to take in multiple # and types of parameters.

    // Never name a method name like this: sumTwoNumber(), sumThreeNumber(), and sumFourNumber()
    // Instead write like this, to be able to overload and use the method again: sum()

    public static int calculateScore(int score){
        System.out.println("Unnamed Player scored "+ score + " points");
        return score * 1000;
    }
    public static int calculateScore(){
        System.out.println("No Player scored no points");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet >= 0 && 0 <= inches && inches <= 12) {
            int centimeters = (int) ((feet * 12 * 2.54) + (inches * 2.54)); // 1 inch = 2.54 cm && 1 ft = 12 in
            System.out.println( (int) feet + " ft & " + (int) inches + " in = " + centimeters +" cm");
            return centimeters;
        } else return -1;
    }
    public static double calcFeetAndInchesToCentimeters(double inches){
        if (0 <= inches) {
            double feet = (int) (inches / 12); // 1 inch = 2.54 cm && 1 ft = 12 in
            double remainingInches = (int) inches % 12;
            System.out.println( (int) inches + " in = " + (int) feet + " ft & "+ (int) remainingInches + " in");
            // calling overloaded method 1 from overloaded method 2
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        } else return -1;
    }

    private static String getDurationString(long minutes, long seconds){
        if (0 > minutes || 0 > seconds || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }
        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h ";
        String minutesString = remainingMinutes + "m ";
        String secondsString = seconds + "s";

        if(hours < 10){
            hoursString = "0" + hoursString;
        }
        if(remainingMinutes < 10){
            minutesString = "0" + minutesString;
        }
        if(seconds < 10){
            secondsString = "0" + secondsString;
        }
        return hoursString + minutesString + secondsString;
    }
    private static String getDurationString(long seconds){
        if (0 <= seconds) {
            long minutes = seconds / 60;
            long remainingSeconds = seconds % 60;
            return  getDurationString(minutes,remainingSeconds);
        } else return INVALID_VALUE_MESSAGE;
    }

    public static double area(double radius){
        if (radius < 0 ){
            return INVALID_VALUE;
        } return radius * radius * Math.PI;

    }
    public static double area(double x, double y){
        if ( x < 0 || 0 > y ){
            return INVALID_VALUE;
        }
        return x * y;
    }

    public static void printYearsAndDays(long minutes){
        if (minutes < 0){
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {
            int years = (int) minutes/525600; // dividing minutes by minutes of a year
            int remainingMinutes =  (int) minutes % 525600; // getting remainder of minutes from year
            int days = remainingMinutes / 1440; // diving remainder by minutes in a day
            // not calculating the remainder of minutes of a day;
            System.out.println(years + " y " + days + " d");
        }


    }

    public static void printEqual(int a, int b, int c){
        if ( a < 0 || b < 0 || c < 0 ){
            System.out.println(INVALID_VALUE_MESSAGE);
        }
        else if ( a == b && b == c) {
            System.out.println("All numbers are equal");
        }
        else if ( a != b && b != c) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }

    public static boolean isCatPlaying(boolean summer, int temp){
        return ((summer && 25 <= temp && temp <= 45) ||(!summer && 25 <= temp && temp <= 35));
    }

}
