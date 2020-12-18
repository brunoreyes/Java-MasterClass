package com.company;

public class DeskPhone implements ITelephone{ // For a class to utilize an interface, place: "implements IName"



    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    // need to override methods to become a valid class > generate > override methods
    // all methods need to be implemented with something, even a simple print statement works
    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone doesn't have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on desk phone");

    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answer the desk phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber){ // checking to see if the correct # is calling the phone
            isRinging = true;
            System.out.println("Ring ring");
        } else {
            isRinging = false;
            System.out.println("Spam call blocked");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
