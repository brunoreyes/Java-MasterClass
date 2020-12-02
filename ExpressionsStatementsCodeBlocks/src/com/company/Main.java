package com.company;

public class Main {

    public static void main(String[] args) {
	    // int int = 5; // can't use common key words as variables https://en.wikipedia.org/wiki/List_of_Java_keywords

        // mile = 1.609344 kilometres
        double kilometres = (100 * 1.609344); //this is a double, the line is an expression w/o ';' or data type
        // while double kilometres = (100 * 1.609344); (the whole line) is a statement
        int highScore = 50;

        if (highScore == 50){ // highScore == 50, highScore = 50, "This is an expression", and score = 0 are all expressions
            System.out.println("This is an expression"); // statement b/c it contains a method call


            // statements can be multiple lines
            System.out.println("This is an expression" +
                    ".." +
                    "..");

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

            boolean gameOver = true;
            score = 800;
            int levelCompleted = 5;
            int bonus = 100;
            if(gameOver == true){
                int finalScore = score + (levelCompleted * bonus);
                finalScore += 1000;
                System.out.println("Your final score was "+ finalScore); //2300
            }
        }

    }
}
