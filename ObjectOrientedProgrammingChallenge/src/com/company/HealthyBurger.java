package com.company;

public class HealthyBurger extends Hamburger {
    private String healthyAddition1Name;
    private double healthyAddition1Price;

    private String healthyAddition2Name;
    private double healthyAddition2Price;

    public HealthyBurger(double price, String meat){
        super("Healthy", price,meat, "Brown rye");
    }

    public HealthyBurger(String name, double price, String breadType, String meat) {
        super(name, price, breadType, meat);
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if(this.healthyAddition1Name != null){
            hamburgerPrice += this.healthyAddition1Price;
            System.out.println("Added "+ this.healthyAddition1Name + " for an extra $"+ this.healthyAddition1Price);
        }
        if(this.healthyAddition2Name != null){
            hamburgerPrice += this.healthyAddition2Price;
            System.out.println("Added "+ this.healthyAddition2Name + " for an extra $"+ this.healthyAddition2Price);
        }
      return hamburgerPrice;
    }

    public void addHealthyAddition1(String name, double price){
        this.healthyAddition1Name = name;
        this.healthyAddition1Price = price;
    }
    public void addHealthyAddition2(String name, double price){
        this.healthyAddition2Name = name;
        this.healthyAddition2Price = price;
    }







}
