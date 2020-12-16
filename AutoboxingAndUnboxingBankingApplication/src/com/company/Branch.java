package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){ // if customer name wasn't on file, we can add it
            this.customers.add(new Customer(customerName, initialAmount)); // calling constructor of Customer class to create a new customer
            return true;
        }
        return false; // the customer already exist (the top return wasn't activated), so return false
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount); // executing addTransaction method from Customer class
            return true;
        } return false;
    }

    private Customer findCustomer(String customerName){
        for (int i = 0; i <  this.customers.size(); i++){ // Cleaner way of saying
            Customer checkedCustomer = this.customers.get(i); // this.customers.get(i).getName().equals(customerName)
            if (checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;
            }
        } return null;
    }
}

