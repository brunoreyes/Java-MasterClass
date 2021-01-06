package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    // Using unlock with timeout to make BankAccount class threadsafe
    public void deposit(double amount){
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){

        }
    }

    public void withdraw(double amount){
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){

        }
    }

    // Using Reentrant lock class instead of Synchronized keyword to threadsafe.
//    public void deposit(double amount){
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }

//    public void withdraw(double amount){
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

    public BankAccount(String accountNumber, double balance ) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }
    // Making the BankAccount class Threadsafe using synchronized keywords

//    public synchronized void deposit(double amount){
//        balance += amount;
//    }

    //
//    public synchronized void withdraw(double amount){
//        balance -= amount;
//    }
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



    // no need to synchronize getAccountNumber & printAccountNumber
    public String getAccountNumber() {
        return accountNumber;
    }
    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }
}
