package com.company;

public class Circle {
    // field or instance variable
    private double radius;

    // constructor that initializes the radius field
    public Circle(double radius) {
        this.radius = radius < 0 ? 0: radius;
    }

    public double getRadius() {
        return radius;
    }

    // returning the area of a circle = r * r(PI)
    public double getArea(){
        // Math.pow (number, power) = number ^ power
        // For ex: if Math.pow (3, 5) = 3 * 3 * 3 * 3 * 3
        // radius^2(Pi) = r * r(PI)
        return (Math.pow(radius,2) * Math.PI);
    }
}
