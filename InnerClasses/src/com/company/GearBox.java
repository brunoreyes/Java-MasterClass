package com.company;

import java.util.ArrayList;
public class GearBox  { // base class
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGears){
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);

        for (int i=0; i < maxGears; i++){
            addGear(i, i * 5.3);  // calling addGear, improving encapsulation,
                                        // making objects only know about objects that they need to know about.
            // Nothing, apart form the gearBox needs to have access to any details about gears class, making it a private int class

        }
    }
    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }
    public void addGear(int number, double ratio){ // adding gears to gearbox
        // this method is better to be apart of gearbox constructor rather than separate call,
        // since it part of building the gearBox, not using it.
        if((number > 0) && (number  <= maxGears)){
            this.gears.add(new Gear(number, ratio));
        }
    }
    public void changeGear(int newGear){
        if ((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn){ // newFear can = 0, b/c 0 is neutral
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }
    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("I'm not moving!!");
            return 0.0;
        } return revs * gears.get(currentGear).getRatio();
    }
    // local classes like Gear increase encapsulation b/c they are only declared in the block that uses them
    private class Gear { // inner class, within the gearBox class I've written all the functionality within the Gear class
                        //  Creating new instances of the gear and saving it into the ArrayList gears
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio){
            this.gearNumber = gearNumber; // refers to the Gear class itself
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs *( this.ratio);
        }
    }
}
