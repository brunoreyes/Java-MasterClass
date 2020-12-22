package com.company;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("AMC", 8, 12);
       // theatre.getSeats();  // commented out to save terminal space
        if (theatre.reserveSeat("H11")){
            System.out.println("Please Pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        // calling reserveSeat() the 2nd time returns "Sorry, seat is taken"
        if (theatre.reserveSeat("H11")){
            System.out.println("Please Pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
