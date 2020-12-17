package com.company;

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
