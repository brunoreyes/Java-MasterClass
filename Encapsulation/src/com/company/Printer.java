package com.company;

public class Printer {
    private int tonerLevel = 0;
    private int numOfPagesPrinted;
    private boolean isDuplexPrinter; // duplex printer - capable of printing on both sides

    public Printer(int tonerLevel, int numOfPagesPrinted, boolean isDuplexPrinter) {
        if(tonerLevel > -1 && tonerLevel <=100){
            this.tonerLevel = tonerLevel;
        } else this.tonerLevel = -1;
        this.numOfPagesPrinted = numOfPagesPrinted;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumOfPagesPrinted() {
        return numOfPagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }

    public int addToner(int tonerAdded){
        if (tonerAdded > 0 && tonerAdded <= 100) {
            if(this.tonerLevel + tonerAdded > 100){
                return -1;
            } else {
                this.tonerLevel += tonerAdded;
                System.out.println("You've added "+ tonerAdded + "% of toner. Total toner: " + this.tonerLevel+"%");
                if (this.tonerLevel == 100){
                System.out.println("Toner has been field to 100% capacity");
            }
            return this.tonerLevel;
            }
        } else return -1;
    }

    public void printPage(int numOfPagesPrinted){
        int pagesToPrint = numOfPagesPrinted;
        if (numOfPagesPrinted > 0) {
            if(isDuplexPrinter){
                pagesToPrint = (numOfPagesPrinted / 2)+(numOfPagesPrinted % 2);
                // for double pg printing + remainder, rounding up if 7 pgs printed then it is 7/2 + 7%2 or 3 + 1 = 4
            }
            this.numOfPagesPrinted += pagesToPrint;
            System.out.println("You've just printed " + pagesToPrint + " pgs on a "+(isDuplexPrinter?"Duplex ":"Regular ") +"printer. Total pgs printed: " + this.numOfPagesPrinted);
        } else System.out.println("Please input a proper amount of pages to print");

    }
}
