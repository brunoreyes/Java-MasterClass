package com.company;

import java.util.ArrayList;

public class Team<T extends Player> { // <T> is a type parameter, extends Player restricts the type of class
    private String name;            // T is now a single bounded-type parameter only accessible to any class derived
    int played = 0;                 // from class Player. (Java allows multiple bounds)
    int won = 0;                    // public class Team<T extends Player & Coach & M..> (Coach and M have to be interfaces)
    int lost = 0;
    int tied = 0;



    private ArrayList<T> members = new ArrayList<>();// ArrayList<Class> nameforClass  = new ArrayList<>()

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            System.out.println(((Player) player).getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(((Player) player).getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            won++;
            message = " beat ";
        } else if ( ourScore == theirScore){
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }
}
