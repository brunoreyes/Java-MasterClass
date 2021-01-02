package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// based on Colossal Cave Adventure Game
public class Location {
    private final int locationID; // once these have been set they cannot be changed b/c of final
    private final String description; // ensuring that fields can't be changed in the future
    private final Map<String, Integer> exits; // Map<key StringType, value IntType, key is a direction

    private long serialVersionUID = 1l;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null){
            this.exits = new LinkedHashMap<String, Integer>(exits); // Utilizing LinkedHashMap to have ordered elements
        } else { // if null was passed in as a user's inputted exit choice
            this.exits = new LinkedHashMap<String, Integer>(); // this time not passing any valid data
        }

        this.exits.put("Q",0); //adding the ability to quit out of the program from any location
    }

    protected void addExit(String direction, int location){
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits); // returning new hashmap of exits
        // nothing outside of class can change exits

        // the getter returns a copy of the exits so if the calling program wants to add/remove
        // mappings from it, then the exits mapping field will not be affected by it
    }
}
