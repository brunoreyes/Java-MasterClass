package com.company;

import java.util.Locale;

public class Car {
    private int doors;
    private int wheels;
    private String model; // string is a class so we can have a class (String) within a class (Car)
    private String engine;
    private String colour;

    // creating a publicly accessible  method
    public void setModel(String model){ // setter method: a method that sets the state for an object
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera")|| validModel.equals("commodore")){
            this.model = model; // here we are updating the value 'private String model;'// above,
        } else {
            this.model = "Unknown";
        }
        // with content passed within setModel's parameter: (String model)
    }

    public String getModel(){ // getter method that gets the info for a particular object
        return this.model;
    }
}
