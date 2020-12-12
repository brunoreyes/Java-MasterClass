package com.company;

public class Car extends Vehicle{
    private int changingGears;
    private int selfDriving;
    private String color;
    private int seats;

    public Car(int wheels, int engine, char size, double cost, boolean hasSteeringWheel, int changingGears, int selfDriving, String color, int seats ) {
        super(4, 1, size, cost, true);
        this.changingGears = 1;
        this.selfDriving = selfDriving;
        this.color = color;
        this.seats = seats;
    }

    public void changeGear(int currentGear){
        this.changingGears = currentGear;
        System.out.println("Car.changeGear(): Changed to gear "+ this.changingGears);
    }
    public void changeVelocity(int speed, int direction){
        System.out.println("Car.changeVelocity() called: Velocity:"+speed +", Direction:"+direction);
        move(speed,direction);
    }


}
