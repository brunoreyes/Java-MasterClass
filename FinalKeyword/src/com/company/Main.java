package com.company;

// It's best to mark variables as final when the value should not be changed

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        // one.instanceNumber = 4; // can't change bc value was already given to the final method
        System.out.println(Math.PI );
        // Math m = new Math(); // math has a private constructor, preventing instances of it being created.
                            // to get around this and try sub-classing is counter acted by math being final as well

        int pw = 674312;
//        Password password = new Password(pw);
        Password password = new ExtendedPassword(pw); // comprimises password

        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(-523266);
        password.letMeIn(674312); // right password

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }
}
