package com.company;

public class Main {

    public static void main(String[] args) { //    public static void main(String[] args) { } is "main" method
        // int int = 5; // can't use common key words as variables https://en.wikipedia.org/wiki/List_of_Java_keywords

        // mile = 1.609344 kilometres
        double kilometres = (100 * 1.609344); //this is a double, the line is an expression w/o ';' or data type
        // while double kilometres = (100 * 1.609344); (the whole line) is a statement
        int highScore = 50;

        if (highScore == 50) { // highScore == 50, highScore = 50, "This is an expression", and score = 0 are all expressions
            System.out.println("This is an expression"); // statement b/c it contains a method call
        }

            // statements can be multiple lines
//            System.out.println("This is an expression" +
//                    ".." +
//                    "..");

        int score = 0; //this is a statement
        score++; // this is a statement
        // 'if' key word and code blocks
        if(score < 5000 && score > 1000){
            System.out.println("score is less than 5000");
        } else if (score < 1000){
            System.out.println("score is less than 1000");
        } else {
            System.out.println("Got here");
        }

        // no more need for these variables being native to this method when we passed in their values from this method.
        // & entered in the datatype and variable names when receiving them within the other method
        // boolean gameOver = true;
        // score = 800;
        // int levelCompleted = 5;
        // int bonus = 100;

        // here we are assigning a variable to the method result
        int finalScore = calculateScore(true, 800, 5, 100); // giving values for each passed values
        // calling the outside method 'calculateScore' within the method ''
        //Java creates the native variables within the outside method b/c we defined them within our parameter
        System.out.println("Your final score was " + finalScore);

        // To change the variable values I want to send, I update the values to what I want them to be. Like so:
        // calculateScore(false, 200, 3, 600);

        // here I'm testing out different methods
        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Tod", position); // 1

        position = calculateHighScorePosition(900);
        displayHighScorePosition("David", position); // 2

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Mariah", position); //3

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Bruno", position); //4

    }

    //public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        // A method if light-gray, signifies it's not being used

        // Define data types and variables via parameter and will assign them to to the
        //  corresponding values that are passed from "main" method

        // Void is a key word that signifies that I do not want to return something.
        // To return something, I change the word void to the data type I want to return, for ex: int
        if(gameOver){ // if gameOver is true
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore; // 2300 returning data type: int. Always Return Something, in all cases (if/else/else if)
        } else {
            return -1; // !gameOver or gameOver == false , return -1 indicates an error/ invalid value or value not found
        }
    }

    public static void displayHighScorePosition(String name, int position){
        System.out.println(name + " has position " + position + " on the high score table.");
    }

    public static int calculateHighScorePosition(int finalScore){
        int position = 4;
        if(finalScore > 1000){
            position = 1;
        } else if (finalScore > 500){
            position = 2;
        }else if (finalScore > 100){
            position = 3;
        }
        // return 4; // no need to have the else
        return position; // only having one return statement, sometimes seems as easier for other developers.
    }
    // DiffMerge allows you to compare a single file or whole folder and visually see differences side by side
    //  it's a great tool fo comparing files ands merging them on any OS
}
