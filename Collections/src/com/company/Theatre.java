package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class Theatre {

    private final String theatreName;
    //private Collection<Seat> seats = new ArrayList<>(); // List object Seat of seats // brute force search, bad performance
    private List<Seat> seats = new ArrayList<>();



    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d",seatNum)); // start with single 0 if single num
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
//        Seat requestedSeat = null;
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        //Searches the specified list for the specified object using the binary search algorithm.
        // The list must be sorted into ascending order according to the specified comparator
        // (as by the sort(List, Comparator) method), prior to making this call.

        // binary search function; reducing by half each time
        if (foundSeat >= 0){ // i.e if it exists (-1) means doesn't exist
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        // binary code example
//        int low = 0;
//        int high = seats.size()-1;
//
//        while (low <= high) {
//            System.out.print(".");
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
//    }

//        for (Seat seat: seats) { // for Seat in seats loop
//            System.out.println(".");
//            if (seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    //for testing
    public void getSeats(){
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat>{ // comparison that fulfills the interface
        private final String seatNumber;        // utilizing the compareTo method built in the seat class
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }
        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
