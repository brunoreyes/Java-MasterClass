package com.company;

public class ExtendedPassword extends Password{
    private int decryptedPassword;

    // override store password method of class Password
//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }

    // saved password variable from Password class to the var of decryptedPassword using constructor
    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }
}
