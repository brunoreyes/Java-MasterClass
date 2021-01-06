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
        // Since status variable is a local variable, it's thread safe
        // Local vars are stored on the thread stack, so each thread has it's own copy.
        // Threads don't interfere with each other when setting and getting status value
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){

        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount){
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e){

        }
        System.out.println("Transaction status = " + status);
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
