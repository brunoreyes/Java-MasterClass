package com.company;

public class Calculator {
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        // here I am using class floor's getArea method
        // to calculate area (length * width)

        // as well as using class carpet's getCost method
        // to grab the cost of a carpet
        return floor.getArea() * carpet.getCost();
    }
}
