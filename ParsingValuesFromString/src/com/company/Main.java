package com.company;

public class Main {

    public static void main(String[] args) {
        // Parsing values from a string is to convert values from datatype 'String' into another datatype like 'int'
        String numberAsString = "2018";
        System.out.println("numberAsString= " + numberAsString);

        // parsing methods can convert a string into various primitive data types
        // newDataType variableName = NewDataType.parseNewDataType(variableOfOldDataType)
        int number = Integer.parseInt(numberAsString); // Interger is a wrapper class of datatype: int
        // parseInt() tries to convert the string into an integer using Integer. <- the type converting to.
        // for ex if i wanted to convert to double Double.parseInt()

        System.out.println("numberString + 1 = " + number + 1); // 20181 Java appended with the string
        System.out.println("number + 1 = " + (number + 1)); // 2019 Java added to the converted int

        numberAsString = "2018.125";
        double doubleNumber = Double.parseDouble(numberAsString);
        System.out.println("new number as double = " + doubleNumber);

    }
}
