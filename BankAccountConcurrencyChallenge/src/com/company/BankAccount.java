package com.company;

public class BankAccount {
    private double balance;
    private String accountNumber;

    // Make the BankAccount class Threadsafe using synchronized keywords


    public BankAccount(String accountNumber, double balance ) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public synchronized void deposit(double amount){
        balance += amount;
    }

    public synchronized void withdraw(double amount){
        balance -= amount;
    }

    // OR

//    public  void deposit(double amount){
//        synchronized (this){
//            balance += amount;
//        }
//
//    }
//
//    public  void withdraw(double amount){
//        synchronized (this){
//            balance -= amount;
//        }
//    }

}
