package com.company;

public class Main {

//    public: at the member level, public has the same meaning as at top level.
//       A public class member (or field) and public method can be accessed from
//      any other class anywhere, even in a different package

//    Package-private: This has the same meaning as it does at the top level. An object
//    with no access modifier is visible to every class within the same package
//    ( but not to classes in external packages )

//    private: the object is only visible within the class it is declared
//    and not visible anywhere else (including in subclasses of its class)

//    Protected: the object is visible anywhere in it's own package ( like package private)
//    but also in subclasses even if they are in another package.

    public static void main(String[] args) {
        Account brunoAccount = new Account("Bruno");
        brunoAccount.deposit(20);
        brunoAccount.deposit(60);
        brunoAccount.withdrawl(-200);
        brunoAccount.deposit(-20);
        brunoAccount.calculateBalance();
//        brunoAccount.balance = 5000; // fraud, stopped by making var private

        System.out.println("Balance on account is " + brunoAccount.getBalance());
//        brunoAccount.transactions.add(500); // fraud, stopped by making var private
        brunoAccount.calculateBalance();
    }
}
