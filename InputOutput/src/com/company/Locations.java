package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException{ // throwing an exception
        try (DataOutputStream locationFile =
             new DataOutputStream((new BufferedOutputStream(new FileOutputStream("locations.dat"))))) {
                                                        // .dat file is used bc it has binary written within it
                                                        // locations and exits are now all written within same file
            for (Location location: locations.values()){
                locationFile.writeInt((location.getLocationID()));
                locationFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " : " +
                        location.getDescription());
                System.out.println("Writing " + (location.getExits().size() -1) + " exits.");
                locationFile.writeInt(location.getExits().size() -1); // deducted one to avoid recording quit
                for (String direction: location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")){
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locationFile.writeUTF(direction);
                        locationFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
//        try(BufferedWriter locationFile = new BufferedWriter(new FileWriter("locations.txt"));
//            BufferedWriter directionFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            // the location and description is being written first
//            for (Location location : locations.values()){
//                locationFile.write(location.getLocationID() +"," + location.getDescription() +"\n");
//                // looping through the location, going through all of the exits for the given location
//                for (String direction: location.getExits().keySet()){
//                    if (!direction.equalsIgnoreCase("Q")){ // avoiding the quit options
//                        directionFile.write(location.getLocationID() + "," +
//                                direction + "," +location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }
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
        try( Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) { // has to be initialized outside of try block in order to use it
                                            // Implemented BufferedReader to read in chucks rather than in characters

            // FileReader isn't closed b/c when scanner is closed, everything
            // the source for a scanner must be an object that has a readable interface.
            // Scanner automatically closes down making us not have to close down the scanner.

            scanner.useDelimiter(",");
            // useDelimiter() lets scanner know our info should be separated, in this case by a comma
            while (scanner.hasNextLine()){
                int locationNumber = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String descriptionString = scanner.nextLine();
                System.out.println("Imported location: " + locationNumber + ": " + descriptionString);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(locationNumber, new Location(locationNumber, descriptionString, tempExit));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        // Now reading the exits
        // to read files we create file reader objects, then buffered the streams so large chunks of data are read into
        // memory using BufferedReader preventing excessive access to the disk, so data is only read from the disk when
        // the buffer is empty, otherwise the file reader continues to take data from the memory buffer. Reducing disc
        // access time
        try (BufferedReader directionFile = (new BufferedReader(new FileReader("directions_big.txt")))){
            String input;
            while ((input = directionFile.readLine()) != null ){
//                int locationNumber = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter()); // going to the next comma (delimiter)
//                String destination = scanner.nextLine();
//                int destinationNumber = Integer.parseInt(destination); // converting the String to an int
                String[] data = input.split(",");
                int locationNumber = Integer.parseInt(data[0]);
                String direction = data[1];
                int destinationNumber = Integer.parseInt(data[2]);

                System.out.println(locationNumber + ": " + direction + ": " + destinationNumber);
                Location location = locations.get(locationNumber);
                location.addExit(direction, destinationNumber);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
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
