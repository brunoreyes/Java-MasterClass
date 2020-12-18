package com.company;
// Interface in Java, specify methods that a particular class that implements the interface must implement.
// The interface is abstract, meaning if there's no code for any of the methods,
// then I still provide the actual method names and parameters
// and the code for the method still goes in the class I'm creating.

// The big idea is to use an interface that provides a common behavior that can be used by
// multiple classes, by having them all implement the same interface.
// Standardizing a way a particular set of classes are used.

// A class can only implement from one superClass
//  but you can implement multiple instances from implementing multiple interfaces

public class Main {
    // press option and hover over the same parts of multiple lines you want to change
    public static void main(String[] args) {

        ITelephone brunoPhone;
        // DeskPhone brunoPhone; // also valid
        //  however if using the same initialization name: brunoPhone then must use the interface name: ITelephone
        brunoPhone = new DeskPhone(123456);// Have to initialize a new interface from the class containing the functionality,
                                                        // not from the interface itself.
        brunoPhone.powerOn();
        brunoPhone.callPhone(123456);
        brunoPhone.answer();
        brunoPhone.callPhone(654321); // testing wrong number

        brunoPhone = new MobilePhone(2345);
        brunoPhone.dial(2345);
        brunoPhone.callPhone(2345);
        brunoPhone.powerOn();
        brunoPhone.dial(2345);
        brunoPhone.callPhone(2345);
        brunoPhone.answer();
    }
}
