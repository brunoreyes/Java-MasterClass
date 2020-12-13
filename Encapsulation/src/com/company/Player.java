package com.company;

// this class represents non-encapsulation
public class Player {

    // non-encapsulated variables b/c the scope is now set to public
    public String name; // changing a name of an instance variable/ field can be tedious when having to edit from every angle
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        this.health = this.health - damage;
        if(this.health<=0){
            System.out.println("Player knocked out");
            // reduce # of lives remaining for player
        }
    }
    public int healthRemaining(){
        return this.health;
    }
}
