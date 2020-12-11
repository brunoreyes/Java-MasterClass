package com.company;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public VipCustomer(){
        this("John", 75000.00, "John@Doe.com");
    }

    // setting only default of credit limit
    public VipCustomer(String name,String email){
        this(name, 75000.00, email);
    }

    public VipCustomer(String name, double creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }
}

