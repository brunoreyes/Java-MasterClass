package com.company;

public class ComplexNumber {
    // a complex number is 'a + bi'
    // where a = real part & b = imaginary part
    // summing/subtracting two complex numbers goes as follows:
    // (3 + 2i) + (4 - 3i) = 7 + -i  || (-2 + 4i) - (3 - 2i) = 1 + 6i

    // fields or instance variables
    private double realNumber;
    private double imaginaryNumber;

    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }

    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public void add(double realNumber, double imaginaryNumber){
        // adding parameter values to fields
        this.realNumber += realNumber;
        this.imaginaryNumber += imaginaryNumber;
    }
    public void add(ComplexNumber complexNumber){
        // the first instance of overload method 'add()' allowed me
        // to pass double realNumber and double imaginaryNumber as
        // complexNumber.getRealNumber() & complexNumber.getImaginaryNumber()
        add(complexNumber.getRealNumber(),complexNumber.getImaginaryNumber());
    }

    public void subtract( double realNumber, double imaginaryNumber){
        // setting the value of the fields/ instance variables
        // to the subtracted version of them.
        this.realNumber -= realNumber;
        this.imaginaryNumber -= imaginaryNumber;
    }
    public void subtract(ComplexNumber complexNumber){
        // calling an overloaded method of subtract from another overloaded method of subtract
        subtract(complexNumber.getRealNumber(),complexNumber.getImaginaryNumber());
    }
}
