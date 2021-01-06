package com.company;

public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double balance ) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }


}
