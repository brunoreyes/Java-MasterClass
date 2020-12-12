package com.company;

public class Lambo extends Car {

    private int suicideDoors;
    private int mediaPlayer;
    private int status;

    public Lambo(int wheels, int engine, char size, double cost, boolean hasSteeringWheel, int changingGears, int selfDriving, String color, int seats, int suicideDoors, int mediaPlayer, int status) {
        super(4, 1, 'L', 250000, true, 1, 2, "Yellow", 2);
        this.suicideDoors = suicideDoors;
        this.mediaPlayer = mediaPlayer;
        this.status = status;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() +  rate;
        if(newVelocity == 0){
            stop();
            changeGear(1);
        } else if(newVelocity > 0 && newVelocity <= 10){
            changeGear(1);
        } else if(newVelocity > 10 && newVelocity <= 20){
            changeGear(2);
        } else if(newVelocity > 20 && newVelocity <= 30){
            changeGear(3);
        }else {
            changeGear(4);
        }

        if(newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
