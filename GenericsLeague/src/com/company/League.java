package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League< T extends Team>{ // Type of team found in Team class
//    public class League<U extends Player, T extends Team>{
                    // To fix raw type issue from main class, I'll use U extends Player
    public String name;
    private ArrayList<T> league = new ArrayList<T>(); // ArrayList of same type league

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team){
        if (league.contains(team)){ // if the league contains the team, return false b/c it's already in there
            return false;           //      and there's no need to add a duplicate
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable(){
        Collections.sort(league); // sort works b/c within class Team, I've implemented the compareTo method
        for (T t : league){ // again, league is a parameterized type bounded by the league method
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
