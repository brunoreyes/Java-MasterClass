package com.company;

public class Lamp {
    private String style;
    private boolean battery;
    private int globalRating;


    public Lamp(String style, boolean battery, int globalRating) {
        this.style = style;
        this.battery = battery;
        this.globalRating = globalRating;
    }

    public void turnOn(){
        System.out.println("Lamp -> Turn On");
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobalRating() {
        return globalRating;
    }
}
