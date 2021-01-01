package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException{ // throwing an exception
        // the caller must catch the exception or specify it will throw it.

        // Try with Resources like this automatically ensure the file will close
        // whether or not an exception occurs, suppressing the exception and
        // throwing the exception from the try block
        try(FileWriter locationFile = new FileWriter("locations.txt")) {
            for (Location location : locations.values()){
                locationFile.write(location.getLocationID() +", " + location.getDescription() +"\n");
            }
        }
//        FileWriter locationFile = null; // Have to initialize outside of try and catch/finally block
//                                        // because those blocks introduce their own scopes
//        try { // Try block must be followed by a catch or finally block
//
//            // Make sure not to have any duplicated files within the project or else won't be created
//            locationFile = new FileWriter("locations.txt");
//            for (Location location: locations.values()){
//                // Writing data in string format and storing it in recently created file: locations.txt
//                locationFile.write(location.getLocationID() +
//                        ", " + location.getDescription() + "\n");
////                throw new IOException("test exception thrown while writing"); // testing throw
//                // remove throw statement after production
//            }
//
//        }
//        // Got rid of catch IOException block's because I've accounted for the exception via throwing it
////        catch (IOException e){ // an alternative to catching is throwing an exception back up the callstack
////            System.out.println("In catch block");
////            e.printStackTrace();
////        }
//        finally {
//            System.out.println("In finally block");
//            // try & catch checking to see if location file is null and not allowing null files to be closed
//
//            // got rid of try and catch for this method b/c catch functionality was taken care of in throw above
////            try {
//                // Ensuring code doesn't crash
//                if (locationFile != null){
//                    System.out.println("Attempting to close location file");
//                    // Remember to CLOSE streams to avoid resource leaks & locked files errors
//                    locationFile.close();
//                }
////            }
//            // Got rid of catch IOException block's because I've accounted for the exception via throwing it
//
////            catch (IOException e){
////                e.printStackTrace();
////            }
//        }
    }

    static {
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
