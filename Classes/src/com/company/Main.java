package com.company;

public class Main {

    // public, private, and protected are access modifiers
    // public: means unrestricted access to class
    // private: no other class can access your class
    // protected: only classes within your package can access this class
    public static void main(String[] args) {

        // real world objects have two characteristics, the state and behavior: size, width, weight
        // behavior: booting up, loading objects on the DOM

        // a class is sort of a user-defined datatype

        // classes allow variables to be accessed by the classes, aka fields or member variables

        //private fields adhere to encapsulation, hiding fields and method variables to not be accessed publicly
        // by other classes

        // for ex:  private int doors

        Car porsche = new Car(); // defining an imported object from class: Car, Car and naming it: 'porsche'
        Car holden = new Car(); // initializing object Car by adding = new Car();
        // creating an object called porsche, based on the template: 'car'

        System.out.println("Model is "+ porsche.getModel()); // Model is null, null is the internal default state for a class and string
        porsche.setModel("Carrera"); // so we access the public method in class Car to update the value of model
        porsche.setModel("911"); // validation returns an Model is Unknown since it's not one of the valid classes
        System.out.println("Model is "+ porsche.getModel());

        SimpleCalculator calculator = new SimpleCalculator();

        calculator.setFirstNumber(9);
        System.out.println("firstNumber = "+ calculator.getFirstNumber());

        calculator.setSecondNumber(10);
        System.out.println("secondNumber = "+ calculator.getSecondNumber());

        System.out.println(calculator.getFirstNumber() +" * "+ calculator.getSecondNumber()+" = "+ calculator.getMultiplicationResult());
        System.out.println(calculator.getFirstNumber() +" / "+ calculator.getSecondNumber()+" = "+ calculator.getDivisionResult());
        System.out.println(calculator.getFirstNumber() +" + "+ calculator.getSecondNumber()+" = "+ calculator.getAdditionResult());
        System.out.println(calculator.getFirstNumber() +" - "+ calculator.getSecondNumber()+" = "+ calculator.getSubtractionResult());





    }
}
