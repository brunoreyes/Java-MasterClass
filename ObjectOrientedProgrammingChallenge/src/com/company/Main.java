package com.company;

import java.text.DecimalFormat;

public class Main {
    private static DecimalFormat decimalFormatter = new DecimalFormat("#.##"); // formatting the total to
                                                    // only reveal 2 decimal points
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", 3.56, "White", "Sausage");
        double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger cost: $"+ decimalFormatter.format(hamburger.itemizeHamburger()));

        HealthyBurger healthyBurger = new HealthyBurger(5.50, "Chicken");
        healthyBurger.addHealthyAddition1("Egg",2.15);
        healthyBurger.addHealthyAddition1("Lentils",1.50);
        System.out.println("Total Healthy Burger cost: $"+ healthyBurger.itemizeHamburger());
        // here itemizeHamburger() is called within the overridden version of it that's within class Healthy burger

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizeHamburger();
    }
}
