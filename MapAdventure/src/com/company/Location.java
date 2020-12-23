package com.company;

import java.util.HashMap;
import java.util.Map;

// based on Colossal Cave Adventure Game
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits; // Map<key StringType, value IntType, key is a direction

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        this.exits.put("Q",0); //adding the ability to quit out of the program from any location
    }

    public void addExit(String direction, int location){
        exits.put(direction, location);
    }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); // returning new hashmap of exits
        // nothing outside of class can change exits

        // the getter returns a copy of the exits so if the calling program wants to add/remove
        // mappings from it, then the exits mapping field will not be affected by it
    }
}
