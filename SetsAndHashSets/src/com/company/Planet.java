package com.company;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) { // instead of accepting bodyType as a param b/// c it'll always
        super(name, orbitalPeriod, BodyTypes.PLANET); // be a planet, we want to pass the enum constant instead
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
