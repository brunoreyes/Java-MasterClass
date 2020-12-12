package com.company;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
	    Case theCase = new Case("220B", "Dell","240",dimensions);
	                                                                                            // creating an instance of a variable
	    Monitor theMonitor = new Monitor("27th inch beast", "Acer", 27,new Resolution(2540, 1440));

	    Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4,6,"v2,44");
	    PC thePC = new PC(theCase, theMonitor, theMotherboard);
	    thePC.powerUp();

	    // Composition: case, monitor and motherboard are a part of a computer but aren't a individual computers
	    // here we are getting the object: Class Monitor from Class PC, and accessing Class Monitor's drawPixelAt() Method
//	    thePC.getMonitor().drawPixelAt(1500,1200,"red");

	    // here we are accessing thePC's motherboard class and calling it's loadProgram method
//	    thePC.getMotherboard().loadProgram("Windows 1.0");

//	    thePC.getTheCase().pressPowerButton();


    }
}
