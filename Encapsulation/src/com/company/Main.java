package com.company;

public class Main {

    public static void main(String[] args) {
	// Encapsulation stops outside classes or code from accessing the inner workings of a class
        Player player = new Player();
        // since we didn't create a constructor in class Player, a default constructor has been created
        // and now I have to manually set the values of class Player's fields/ instance variables
        player.name = "Bruno";
        player.health = 20;
        player.weapon = "Sword";

        System.out.println("Player: "+ player.name +
                ", Health: "+ player.health +
                ", Weapon: "+ player.weapon);
        int damage = 10;
        player.loseHealth(damage);
        System.out.println(player.name + " takes "+damage +
                " points of damage and has a remaining health of " +
                player.healthRemaining()+ " points");
        damage = 11;
        player.health = 200; // able to access fields directly might not be what I want, best to keep these fields private
        player.loseHealth(damage);
        System.out.println(player.name + " now takes "+damage +
                " points of damage and has a remaining health of " +
                player.healthRemaining()+ " points");

        // Encapsulated version of Player
        EncapsulatedPlayer encapsulatedPlayer = new EncapsulatedPlayer("Bruno",50,"Sling Shot");
        System.out.println("Player: "+ encapsulatedPlayer.getName() +
                ", Health: "+ encapsulatedPlayer.healthRemaining() +
                ", Weapon: "+ encapsulatedPlayer.getWeapon());
        encapsulatedPlayer.loseHealth(10);
        System.out.println(encapsulatedPlayer.getName() + " now has a remaining health of " +
                encapsulatedPlayer.healthRemaining()+ " points");

        // Encapsulated  Printer
        Printer duplexPrinter = new Printer(0,10,true);
        System.out.println("The " + (duplexPrinter.isDuplexPrinter()?"Duplex":"Regular") +
                " printer has printed " + duplexPrinter.getNumOfPagesPrinted() +
                " pages and has a toner level of "+ duplexPrinter.getTonerLevel());

        duplexPrinter.addToner(10);
        duplexPrinter.addToner(20);
        duplexPrinter.addToner(70);

        duplexPrinter.printPage(7);
        duplexPrinter.printPage(20);
        duplexPrinter.printPage(-10);
        Printer regularPrinter = new Printer(0,5,false);
        System.out.println("The " + (regularPrinter.isDuplexPrinter()?"Duplex":"Regular") +
                " printer has printed " + regularPrinter.getNumOfPagesPrinted() +
                " pages and has a toner level of "+ regularPrinter.getTonerLevel());

        System.out.println(regularPrinter.addToner(10));
        System.out.println(regularPrinter.addToner(20));
        System.out.println(regularPrinter.addToner(70));

        regularPrinter.printPage(10);
        regularPrinter.printPage(20);
        regularPrinter.printPage(-10);









    }
}
