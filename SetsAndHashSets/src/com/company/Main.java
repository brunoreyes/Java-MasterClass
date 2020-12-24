package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


//  Sets are no defined order and chaotic, but a set cannot contain duplicates

//  Sets have a generic interface with methods .add() .remove() .clear() .isEmpty() .contains() and .size()

//    The Hash set uses hashes to store items but only keys not values

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp); // .put( value, key)
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp); // .put( value, key)
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp); // .put( value, key)
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp); // jupiter becomes temp

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets:");
        for (HeavenlyBody planet : planets){
            System.out.println("\t" + planet.getName());
        }
        HeavenlyBody body = solarSystem.get("Jupiter"); // moons when Jupiter is temp
        System.out.println();
        System.out.println("Moons of " + body.getName() + ":");
        for (HeavenlyBody jupiterMoon: body.getSatellites()){
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet: planets){
            // In set theory, a union of two or more seats is a set containing all elements of the sets
            // sets don't contain duplicates, so each element in a union will only appear once even
            // if it was present in either set.

            // .addAll() generates a set union, looping through all planets and calling
            // getSatellites.
            moons.addAll(planet.getSatellites());
        }
        System.out.println();
        System.out.println("All Moons:"); // each moon was added to the moons Hashset via satellites
        for (HeavenlyBody moon : moons ){  // printing each moon from the moons HashSet
            System.out.println("\t" + moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto); // this pluto isn't a ref of the other temp pluto

        for (HeavenlyBody planet: planets){
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
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

