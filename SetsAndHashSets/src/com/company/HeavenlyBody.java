package com.company;

import java.util.HashSet;
import java.util.Set;

public  class HeavenlyBody { // took away final keyword to be able to create subclasses
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes { // enum, Java's way of grouping constants together
                            // defining a type of BodyTypes, enums use types accepting valid types
                            // enum gives an error at compile time
                            // nested enums are automatically static
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody moon){ // option to add a moon to the HeavenlyBody
        if (moon.getBodyType() == bodyType.MOON)
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){ // satellites getters will create a new hashSet & return it
        return new HashSet<>(this.satellites); // restricting access to original hashSet
    }


    @Override // if I get the method signature wrong the code won't compile
    // marked method as final in case equals aren't symmetric
    public final boolean equals(Object object){ // changed HeavenlyBody type to Object
        if (this == object){        // to override the method and not overload it
            return true;            // with a different parameter
        }
        if (object instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) object;
            if (this.name.equals(theObject.getName())){
                return this.bodyType == theObject.getBodyType();
            }
        }
        return false;
        // implemented equals and hashcode to get troubleshooting code below to work
//        System.out.println("object.getClass ()  is " + object.getClass());
//        System.out.println("this.getClass ()  is " + this.getClass());
//        if((object == null) || (object.getClass() != this.getClass())){
//            return false; // null or doesn't equal
//        }
//        String objectName = ((HeavenlyBody)object).getName();
//        return this.name.equals(objectName);
    }

    @Override
    public String toString() {
        return this.name +": " + this.bodyType +", "+ this.orbitalPeriod; // Java implicitly calls to string method
    }                                                                       // with concatenation

    @Override
    public final int hashCode() {
        System.out.println("HashCode called");
        return this.name.hashCode() + 57 + this.bodyType.hashCode(); // generate hashCodes that when compare objects using
        // equals will have the same hashCode
    }
}


