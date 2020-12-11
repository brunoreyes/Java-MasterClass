package com.company;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNumber;

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhoneNumber(Long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        // here I converted a Long 'phoneNumber' to a String & added '() - -' for formation
        String formattedPhoneNumber = String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        return formattedPhoneNumber;
    }
    public BankAccount(){
        // when calling this constructor with no parameters inputted, this function calls it's overloaded function
        // and passed it this default dummy data
        this("John", "john@doe.com", 11.11, 1234567890, 12345);
        System.out.println("Empty constructor called");
    }
    public BankAccount(String customerName, String email, double balance, long phoneNumber, int accountNumber){
        System.out.println("Account constructor with parameters called");

        // setting field values directly like this can guarantee the field values will be initialized
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount){

        double newBalance = balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " was made. New balance is $" + newBalance);

    }
                                // ensure that when inputting from main, perimeter name is unique
    public void withdrawalFunds( double withdrawalAmount){
//        System.out.println(balance);
        if (this.balance - withdrawalAmount < 0){
            System.out.println("Only "+ this.balance + " is available. Withdrawal of "
                    + withdrawalAmount +" could not be processed");
        } else {
            double newBalance = balance -= withdrawalAmount;
            System.out.println("Withdrawal of $"+ withdrawalAmount + " was made. New Balance is $" + newBalance);
        }
    }
}
