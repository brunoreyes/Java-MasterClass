package com.company;

// Polymorphism gives unique functionality to a class that inherits from a base class.

// Alternative way of creating non-reusable classes
class Movie {
    private String name;

    public Movie(String name){
        this.name = name;
    }
    public String plot(){
        return "No plot here"; // default return string
    }

    public String getName() {
        return name;
    }
}

// below is a total of 5 classes that extend or inherit from the Movie class
// all initialized from their own constructors and pass the name of the particular movie to the base class Movie
// 4 of the 5 movies below have plot methods and use the override to override the base plot method of class Movie
class Jaws extends Movie {
    public Jaws(){
        super("Jaws"); // using super to access the
        // main constructor of class Movie (Movie) and setting it to "Jaws"
    }
    public String plot(){
        return "A shark eats a lot of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay(){
        super("Independence Day");
    }
    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner(){
        super("Maze Runner");
    }
    @Override
    public String plot() {
        return "Kids try to escape a maze";
    }
}

class StarWars extends Movie {
    public StarWars(){
        super("Star Wars");
    }
    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

class Forgettable extends Movie{
    public Forgettable(){
        super("Forgettable");
    } // no plot method
}

public class Main {

    public static void main(String[] args) {
        for(int i = 1; i < 6; i++){
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + " : " + movie.getName() + "\n" +
                    "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
        int randomNumber = (int) (Math.random() * 5) + 1; // math.random returns a num between 0 and 1,
        // if I multiply it by 5 it will become a number between 0 - 4; and then if I add 1 it'll return a number from 1-5
        System.out.println("Random number generated is: "+ randomNumber);
        switch (randomNumber){
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgettable();
        }
        return null;
    }
}
