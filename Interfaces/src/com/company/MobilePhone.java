package com.company;

public class MobilePhone implements ITelephone{ // For a class to utilize an interface, place: "implements IName"



    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    // need to override methods to become a valid class > generate > override methods
    // all methods need to be implemented with something, even a simple print statement works
    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone powered on");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now ringing " + phoneNumber + " on mobile phone");
        } else {
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn){ // checking to see if the correct # is calling the phone
            isRinging = true;
            System.out.println("Melody ring");
        } else {
            isRinging = false;
            System.out.println("Spam call blocked or Mobile phone not on");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
