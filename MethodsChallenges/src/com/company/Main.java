package com.company;
import java.text.NumberFormat; // adding commas or formatting to numbers
import java.util.Locale; // in local preference: US

public class Main {

    public static void main(String[] args) {
        int number = 1234567;
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String numberAsString = numberFormat.format(number);
        System.out.println(numberAsString);

        System.out.println("toMilesPerHour Test");
        toMilesPerHour(1.5);
        toMilesPerHour(10.25);
        toMilesPerHour(-5.6);
        toMilesPerHour(25.42);
        toMilesPerHour(75.114);
        System.out.println("---------------------------------");
        System.out.println("printConversion Test");
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);
        System.out.println("---------------------------------");
        System.out.println("printMegaBytesAndKiloBytes Test");
        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(-1024);
        printMegaBytesAndKiloBytes(5000);
        printMegaBytesAndKiloBytes(123456);
        System.out.println("---------------------------------");
        System.out.println("shouldWakeUp Test");
        System.out.println(shouldWakeUp(true, 1));
        System.out.println(shouldWakeUp(false, 2));
        System.out.println(shouldWakeUp(true, 8));
        System.out.println(shouldWakeUp(true, -1));
        System.out.println("---------------------------------");
        System.out.println("isLeadYear Test");
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2200));
        System.out.println(isLeapYear(2300));
        System.out.println(isLeapYear(2500));
        System.out.println(isLeapYear(2400));
        System.out.println("---------------------------------");
        System.out.println("areEqualByThreeDecimalPlaces Test");
        System.out.println(areEqualByThreeDecimalPlaces(-3.175, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, -3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));
        System.out.println(areEqualByThreeDecimalPlaces(-3.1759, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(-3.176, -3.175));
        System.out.println("---------------------------------");
        System.out.println("hasEqualSum Test");
        System.out.println(hasEqualSum(1,1,1));
        System.out.println(hasEqualSum(1,1,2));
        System.out.println(hasEqualSum(1,-1,0));
        System.out.println("---------------------------------");
        System.out.println("hasTeen Test");
        System.out.println(hasTeen(9,99,19));
        System.out.println(hasTeen(23,15,42));
        System.out.println(hasTeen(22,23,34));



    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0L) {
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
        if (kilometersPerHour > 0) {
            long kiloInMiles = Math.round(kilometersPerHour * 0.621371);
            System.out.println(kilometersPerHour + " kph = " + kiloInMiles + " mph");
        } else {
            System.out.println("Invalid Value");
        }
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US); // add commas to # in local preference

        if (kiloBytes > 0) {
            int megabytes = Math.round(kiloBytes / 1024); // 1 MB (megabytes) = 1024 KB (kilobytes)
            int remainingKilobytes = Math.round(kiloBytes % 1024);
            System.out.println(
                    numberFormat.format(kiloBytes) + " KB = " +
                            numberFormat.format(megabytes) + " MB and " +
                            numberFormat.format(remainingKilobytes) + " KB"
            ); // since each value can get up to 1,000 (even KB goes up to 1,024). I decided to add formatting to all.
        } else {
            System.out.println("Invalid Value");
        }
    }

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if ((0 <= hourOfDay && hourOfDay <= 23) && (isBarking && (8 > hourOfDay && hourOfDay < 22))) {
            return true;
            } else return false;
    }

    public static boolean isLeapYear(int year) {
        if (1 <= year && year <= 9999) {
            if (year % 100 == 0 && year % 400 == 0) { // if evenly divisible by 100 and 400, then it's a leap year
                return true;
            } else return false;
        } else return false;
    }

    public static boolean areEqualByThreeDecimalPlaces(double x, double y) {
        return (((int) (x * 1000)) == ((int) (y * 1000)));
    }
//        return (((x - y) < 0 && ((x - y) > -0.001)) || ((x - y) >= 0 && Math.abs(x - y) < 0.001));
// Notes below
//  200.001 - 200.003 = abs(-.002) and since absolute value = .002 , is false
//  200.003 - 200.001 = .002 so false still, but 200.0031 - 200.003 = .0001

    public static boolean hasEqualSum(int a, int b, int c){
        return (a+ b == c);
    }

    public static boolean hasTeen(int a, int b, int c){
        return (13 <= a && a <= 19 || 13 <= b && b <= 19 || 13 <= c && c <= 19);
    }

}
