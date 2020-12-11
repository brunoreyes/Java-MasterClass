package com.company;

public class Wall {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public void setWidth(double width) {
        this.width = width < 0 ? 0 : width;
    }

    public void setHeight(double height) {
        // no need to place ternary in () or {}
        this.height = height < 0 ? 0 : height;
    }

    // default if no values are given
    public Wall() {
        this(200,200);
    }

    public Wall(double width, double height) {
        // if the width or height given in main is less than 0
        // than make this.measurement = 0
        this.width = width < 0 ? 0 : width;
        this.height = height < 0 ? 0 : height;
        }

}
