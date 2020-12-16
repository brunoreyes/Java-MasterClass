package com.company;

import java.util.ArrayList;

public class Bank {
    private String name; // name of bank
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>(); // constructor initializes a new branch everytime it's called
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) ==  null){ // adding the branch name if it already doesn't exist
            this.branches.add(new Branch(branchName));
            return true;
        } return false;
    }

    // calling branch Class' addCustomer method
    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){ // calling branch Class to check if the branch name exist
            return branch.newCustomer(customerName, initialAmount);// we can return the status instead of true like so
        } return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName, amount);
        } return false;
    }

    private Branch findBranch(String branchName){
        for (int i = 0; i <  this.branches.size(); i++){ // Cleaner way of saying
            Branch checkedBranch = this.branches.get(i); // this.customers.get(i).getName().equals(customerName)
            if (checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        } return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customer details for branch "+ branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++){ // loop for all customers
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "["+(i+1)+"]");
                if(showTransactions){
                    System.out.println("Transactions"); // loop inside a loop to get all transactions of all customers
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for( int j=0; j<transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            } return true;
        } else return false;
    }


}
