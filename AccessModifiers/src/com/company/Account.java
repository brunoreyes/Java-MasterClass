package com.company;

import java.util.ArrayList;

public class Account {
    private String accountName; // changed from public to private
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;

        // when constructing an Arraylist, create a new instance of the list with the same type (here it's Integer)
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if (amount > 0){
            transactions.add(amount);
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums");
        }
    }

    public void withdrawl(int amount){
        int withdrawl = -amount;
        if (withdrawl < 0){
            this.transactions.add(withdrawl);
            this.balance += withdrawl;
            System.out.println(amount + " withdrawn. Balance is now " +  this.balance);
        } else {
            System.out.println("Cannot withdraw negative sums");
        }
    }

    public void calculateBalance(){
        this.balance = 0;
        for (int i: this.transactions){
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }

}
