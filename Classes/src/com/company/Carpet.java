package com.company;

public class Carpet {
    private double cost;

    // recall constructors carry the same name as the class they reside in
    public Carpet(double cost) {
        this.cost = cost;
    }

    public void setCost(double cost) {
        this.cost = cost < 0? 0: cost;
    }

    public double getCost() {
        return cost;
    }
}
