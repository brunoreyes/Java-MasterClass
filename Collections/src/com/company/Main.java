package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // deep copy is a copy where the elements aren't just references but are themselves copied
    // shallow copy is being referenced



    public static void main(String[] args) {
        Theatre theatre = new Theatre("AMC", 8, 12);
       // theatre.getSeats();  // commented out to save terminal space
        if (theatre.reserveSeat("D12")){
            System.out.println("Please Pay for D12");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        // calling reserveSeat() the 2nd time returns "Sorry, seat is taken"
        if (theatre.reserveSeat("D12")){
            System.out.println("Please Pay for D12");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER); // using comparator PRICE_ORDER
        printList(priceSeats);

//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); // copy of the original list ( shallow copy)
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat reversed");
////        Collections.shuffle(seatCopy); // shuffle or randomize list order
//        Collections.reverse(seatCopy); // reverse list order
//        System.out.println(seatCopy);
//        System.out.println("Printing theatre.seat");
//        System.out.println(theatre.seats);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);

//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size()); // only seats the capacity but doesn't get any elements
//        Collections.copy(newList, theatre.seats); //
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() +": $" + seat.getPrice() +"," );
        }
        System.out.println(); // separate line
        System.out.println("================================");

    }


//    public static void sortList(List<? extends Theatre.Seat> list) {
//        for (int i=0; i < list.size() -1; i++){
//            for (int j=i+1; j < list.size(); j++){
//                if (list.get(i).compareTo(list.get(j)) > 0){
//                    Collections.swap(list, i, j ); // swapping index i for j
//                }
//            }
//        }
//    }
}
