package com.company;

public class EncapsulatedPlayer {
    private String name;
    private int hitPoints = 100; //default of 100
    private String weapon;

    public String getName() {
        return name;
    }


    public String getWeapon() {
        return weapon;
    }

    public EncapsulatedPlayer(String name, int health, String weapon) { // se these are the parameters that the user is told to input
        // but I am using hitPoints in place of health and returning hitPoints when health is requested
        this.name = name;
        this.weapon = weapon;
        // i.e. only values between 1-100 are accepted as health
        if(health > 0 && health <=100){
            this.hitPoints = health; // which in this case is defaulted to 100, so if a 200 or -200 is passed, it changes into 100.
        }
    }

    public void loseHealth(int damage){
        this.hitPoints -= damage;
        if(this.hitPoints <= 0){
            System.out.println("Player has been knocked out");
        }
    }

    public int healthRemaining(){
        return this.hitPoints;
    }
}
