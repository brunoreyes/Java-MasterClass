package com.company;

// Create a simple banking application.
// Create a Bank class
// That contains an arraylist of Branches
// Each Branch should have an arraylist of Customers
// Each Customer class should have an arraylist of Doubles (transactions)

// Customer:
// Name, and the ArrayList of doubles.

// Branch:
// Need to be able to add a new customer and initial transaction amount. (CREATE)
// Also needs to add additional transactions for that customer/branch (CREATE MORE)

// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions

// Demonstration autoboxing and unboxing in your code

// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

public class Main {

    public static void main(String[] args) {
	    Bank bank = new Bank("National Bank of United States");
	    if(bank.addBranch("North")){
	        System.out.println("North branch created");
        };

        bank.addCustomer("North","Bruno",50.05);
        bank.addCustomer("North","Jill",500.15);
        bank.addCustomer("North","Jack",250.25);

        bank.addBranch("South");
        bank.addCustomer("South","John",2050.25);
        bank.addCustomerTransaction("South","John",200350.25);
        bank.addCustomerTransaction("North", "Jill", 1000000.01);

//        bank.listCustomers("North",false);
//        bank.listCustomers("North",true);
//        bank.listCustomers("South",true);

        // Invalid Data Test
        if(!bank.addCustomer("Melbourne", "Brian",5.43)){
            System.out.println("Error: Branch requested doesn't exist");
        }

        if(!bank.addCustomer("South", "Brian",5.43)){
            System.out.println("Error: branch requested doesn't exist");
        }

        if(!bank.addCustomerTransaction("North", "Jane", 1000000.01)){
            System.out.println("Customer Jane doesn't exist at North branch");
        };

        if(!bank.addCustomer("North", "Bruno",5.43)){
            System.out.println("Error: Customer Bruno already exist");
        }





    }
}
