package com.company;

public class Cylinder extends Circle{
    private double height;

    // takes in the instance variables of parent class: circle
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height < 0? 0:height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume() {
        return getArea() * height;
    }
}
