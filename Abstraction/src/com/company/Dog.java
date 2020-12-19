package com.company;

public class Dog extends Animal{ // have to implement abstract methods to extend from an abstract class

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println( getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println( getName() + " is breathing");
    }
}
