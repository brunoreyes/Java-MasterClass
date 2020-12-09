package com.company;

public class SimpleCalculator {

    // Instance method are methods which require an object of its class to be created before it can be called.
    private double firstNumber; // object of class: SimpleCalculator
    private double secondNumber;
    // Static methods are the methods in Java that can be called without creating an object of class.


    // An instance method is a method of a class
        // so: getFirstNumber(), getSecondNumber() (getters), setFirstNumber(), setSecondNumber() (setters)
        // are all instance methods of class SimpleCalculator
        // btw, classes are capitalized & camelcase but methods are camel case.

    public void setFirstNumber(double firstNumber){
//        double validNumber = firstNumber;
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber){
//        double validNumber = secondNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber(){
        return firstNumber;
    }

    public double getSecondNumber(){
        return secondNumber;
    }

    public double getMultiplicationResult(){ //return the product of field values: firstNumber + secondNumber
        return firstNumber * secondNumber;
    }

    public double getDivisionResult(){ //return the quotient of field values
        return (secondNumber == 0? 0 : firstNumber/secondNumber);
    }

    public double getAdditionResult(){ //return the sum of field values
        return firstNumber + secondNumber;
    }

    public double getSubtractionResult(){ //return the difference of field values
        return firstNumber - secondNumber;
    }


}
