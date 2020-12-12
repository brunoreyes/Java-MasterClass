package com.company;

public class PC {
    //Composition; "comprising of"
    // PC is comprised of instance variables that are Classes themselves

    // with composition theres no need for inherit, making it easier to gather information
    // from multiple classes instead of just one
    private Case theCase; // case is a reserved key word
    private Monitor monitor;
    private Motherboard motherboard;

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        // Does fancy graphics
        monitor.drawPixelAt(1200, 50, "yellow");
    }


    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }
}
