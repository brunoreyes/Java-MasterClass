package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


//  Sets are no defined order and chaotic, but a set cannot contain duplicates

//  Sets have a generic interface with methods .add() .remove() .clear() .isEmpty() .contains() and .size()

//    The Hash set uses hashes to store items but only keys not values

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
//        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        HeavenlyBody temp = new Planet("Mercury", 88);

        solarSystem.put(temp.getKey(), temp); // .put( value, key)
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp); // .put( value, key)
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp); // .put( value, key)
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp); // jupiter becomes temp

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Planets:");
        for (HeavenlyBody planet : planets){
            System.out.println("\t" + planet.getKey());
        }
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET)); // moons when Jupiter is temp
        System.out.println();
        System.out.println("Moons of " + body.getKey() + ":");
        for (HeavenlyBody jupiterMoon: body.getSatellites()){
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet: planets){
//            // In set theory, a union of two or more seats is a set containing all elements of the sets
//            // sets don't contain duplicates, so each element in a union will only appear once even
//            // if it was present in either set.
//
//            // .addAll() generates a set union, looping through all planets and calling
//            // getSatellites.
            moons.addAll(planet.getSatellites());
        }
        System.out.println();
        System.out.println("All Moons:"); // each moon was added to the moons Hashset via satellites
        for (HeavenlyBody moon : moons ){  // printing each moon from the moons HashSet
            System.out.println("\t" + moon.getKey());
        }

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto); // this pluto isn't a ref of the other temp pluto

        for (HeavenlyBody planet: planets){
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
            System.out.println(planet);
        }

        HeavenlyBody earthOne = new Planet("Earth", 365);
        HeavenlyBody earthTwo = new Planet("Earth", 365);

        // Symmetric bc one equals the other and vice-versa
        System.out.println(earthOne.equals(earthTwo));
        System.out.println(earthTwo.equals(earthOne));
        System.out.println(earthOne.equals(pluto));
        System.out.println(pluto.equals(earthOne));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("Solar system consist of:");
        for (HeavenlyBody heavenlyBody : solarSystem.values()){
            System.out.println(heavenlyBody);
        }
        Object o = new Object();
        o.equals(o); // if 2 objects compare equal they must have the same hash code
        "pluto".equals("");
        // string class has uses it's own equals() method that's different
        // from the original equals() method

        // the duplicate pluto wasn't added due to the implementation of the override method: equal
        // and the HashCode method within class HeavenlyBody

//        The equals method implements an equivalence relation on non-null object references:
//
//        - It is reflexive: for any non-null reference value x, x.equals(x) should return true.
//        - It is symmetric: for any non-null reference values x and y, x.equals(y) should return
//              true if and only if y.equals(x) returns true.
//        - It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns
//              true and y.equals(z) returns true, then x.equals(z) should return true.
//        - It is consistent: for any non-null reference values x and y, multiple invocations of
//              x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
//        - For any non-null reference value x, x.equals(null) should return false.
    }
}

