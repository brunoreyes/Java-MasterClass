package com.company;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){ // option to add a moon to the HeavenlyBody
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){ // satellites getters will create a new hashSet & return it
        return new HashSet<>(this.satellites); // restricting access to original hashSet
    }


    @Override // if I get the method signature wrong the code won't compile
    public boolean equals(Object object){ // changed HeavenlyBody type to Object
        if (this == object){        // to override the method and not overload it
            return true;            // with a different parameter
        }
        // implemented equals and hashcode to get troubleshooting code below to work
        System.out.println("object.getClass ()  is " + object.getClass());
        System.out.println("this.getClass ()  is " + this.getClass());
        if((object == null) || (object.getClass() != this.getClass())){
            return false; // null or doesn't equal
        }
        String objectName = ((HeavenlyBody)object).getName();
        return this.name.equals(objectName);
    }

    @Override
    public int hashCode() {
        System.out.println("HashCode called");
        return this.name.hashCode() + 57; // generate hashCodes that when compare objects using
        // equals will have the same hashCode
    }
}


