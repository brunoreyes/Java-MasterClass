package com.company;

public abstract class Bird extends Animal implements CanFly{ // extending from a class and implementing from a interface
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println( getName() + " is pecking");

    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping it's wings");
    }

    // public abstract void fly(); // abstract class that is extending from another abstract class
    // moved functionality to CanFly to be inclusive for non-bird flyers like bugs and bats
    // and here we are implementing said functionality
    @Override
    public void breathe() {
        System.out.println( getName() + " is breathing");
    }


}
