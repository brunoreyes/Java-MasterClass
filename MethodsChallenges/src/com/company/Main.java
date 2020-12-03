package com.company;

public class Main {

    public static void main(String[] args) {
        toMilesPerHour(1.5);
        toMilesPerHour(10.25);
        toMilesPerHour(-5.6);
        toMilesPerHour(25.42);
        toMilesPerHour(75.114);
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);

    }
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0L){
//            long invalid = -1L;
//            System.out.println(invalid);
            return -1L; // -1 indicating an invalid value
        } else {
            long kiloInMiles = Math.round(kilometersPerHour * 0.621371); //1km = .621371 ml so .62.. * #km = ml
//            System.out.println(kiloInMiles);
            return kiloInMiles;
        }
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour > 0){
        long kiloInMiles = Math.round(kilometersPerHour * 0.621371);
        System.out.println(kilometersPerHour + " kph = " + kiloInMiles + " mph");
        } else {
            System.out.println("Invalid Value");
        }
    }
}
