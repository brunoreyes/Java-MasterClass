package com.company;

public class Vehicle {
     private int wheels;
     private int engine;
     private char size;

     private int currentVelocity;
     private int currentDirection;

    public int getCurrentVelocity() {
        return currentVelocity;
    }
    public int getCurrentDirection() {
        return currentDirection;
    }
    public int getWheels() {
        return wheels;
    }

    public int getEngine() {
        return engine;
    }

    public char getSize() {
        return size;
    }

    public double getCost() {
        return cost;
    }

    public boolean isHasSteeringWheel() {
        return hasSteeringWheel;
    }


    public void stop(){
        this.currentVelocity = 0;
    }

    private double cost;
     private boolean hasSteeringWheel;

    public Vehicle(int wheels, int engine, char size, double cost, boolean hasSteeringWheel) {
        this.wheels = wheels;
        this.engine = engine;
        this.size = size;
        this.cost = cost;
        this.hasSteeringWheel = hasSteeringWheel;
        this.currentDirection = 0;
        this.currentVelocity = 0;
    }
    public void move(int velocity, int direction){
        currentDirection = direction;
        currentVelocity = velocity;
        System.out.println("Vehicle.move() called. Vehicle.move is " +
                "moving at current velocity of: "+ currentVelocity +" at "+ currentDirection +" direction");
    }
    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at "+ currentDirection + " degrees.");
    }


}
