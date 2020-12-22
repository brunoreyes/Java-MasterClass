package com.company;

public class Password {
    public static final int key = 49506770;
    private final int encryptedPassword;

    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }
    private int encryptDecrypt(int password){
        return password ^ key; // here we are x'ing out all of the password
    }

    public final void storePassword(){ // placing final allows method to not be overwritten
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if (encryptDecrypt(password) == this.encryptedPassword){
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope, you cannot come in");
            return false;
        }
    }
}
