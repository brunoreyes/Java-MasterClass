package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Generics are used to find bugs at compile time (writing code for the first time)
        // Generics specify type when creating a class


        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> minnesotaVikings = new Team<>("Minnesota Vikings");
        // proper assignment of a generic class, only joe meets type football player criteria
        minnesotaVikings.addPlayer(joe);

        Team<BaseballPlayer> minnesotaTwins = new Team<>("Minnesota Twins");
        minnesotaTwins.addPlayer(pat);

        Team<SoccerPlayer> minnesotaUnited = new Team<>("Minnesota United");
        minnesotaUnited.addPlayer(beckham);

        Team<SoccerPlayer> minnesotaNotATeam = new Team<>("Minnesota Not a Team");
//        minnesotaNotATeam.addPlayer("noOne"); // doesn't work, String isn't a subclass of player, see Team line 5

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);

        FootballPlayer banks = new FootballPlayer("Gordon");
        minnesotaVikings.addPlayer(banks);

        Team<FootballPlayer> newYorkGiants= new Team<>("New York Giants");
        Team<FootballPlayer> newEnglandPatriots= new Team<>("New York Giants");
        Team<BaseballPlayer> bostonRedSocks= new Team<>("Boston Red Socks");
        Team<BaseballPlayer> newYorkYankees= new Team<>("New York Yankees");

        minnesotaVikings.matchResult(newYorkGiants, 1, 0);
        minnesotaVikings.matchResult(newEnglandPatriots, 3, 8);

        minnesotaTwins.matchResult(bostonRedSocks, 2, 1);
        minnesotaTwins.matchResult(newYorkYankees, 1, 1);

        ArrayList<Integer> items = new ArrayList<>(); // <Integer> specifies the type of data saved to the ArrayList
                                                        // first declaration of <Integer> is satisfied
        items.add(1);
        items.add(2);
        items.add(3);
//        items.add("Bruno");
        items.add(4);
        items.add(5);

//        printDouble(items);
    }


//    private static void printDouble(ArrayList<Integer> n){
//        for (int i: n){
//            System.out.println(i * 2);
//        }

// old way: using raw types
//        for (Object i: n){
//            System.out.println((Integer) i * 2);
//        }



}
