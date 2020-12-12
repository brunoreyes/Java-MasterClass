package com.company;

// car is a (is a relationship) vehicle, that's essentially what inheritance is.
public class Car extends Vehicle{
    private int doors;
    private int engineCapacity;

    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }
    // composition is a has a relationship like a laptop has a keyboard
}
