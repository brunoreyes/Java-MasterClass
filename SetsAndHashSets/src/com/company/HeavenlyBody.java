package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody { // took away final keyword to be able to create subclasses
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


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
        this.key = new Key(name, bodyType); // instantiating in constructor
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }



    public boolean addSatellite(HeavenlyBody moon) { // option to add a moon to the HeavenlyBody
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
            return this.key.equals(theObject.getKey());
//            if (this.name.equals(theObject.getName())){
//                return this.bodyType == theObject.getBodyType();
//            }
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
        return this.key.name +": " + this.key.bodyType +", "+ this.orbitalPeriod; // Java implicitly calls to string method
    }                                                                       // with concatenation

    @Override
    public final int hashCode() {
        System.out.println("HashCode called");
        return this.key.hashCode(); // generate hashCodes that when compare objects using
        // equals will have the same hashCode
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())){
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }
    }
}


