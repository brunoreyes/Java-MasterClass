package com.company;

public class Main {


    public static void main(String[] args) {
	    final BankAccount account1 = new BankAccount("12345-678", 1000.00);

	    // 1st way of Creating & starting a thread: implement Thread class
//        Thread transactionThread1 = new Thread(){
//            public void run(){
//                account1.deposit(300.00); // account1 need to be final to be accessible in inner class
//                account1.withdraw(50.00);
//            }
//        };
//        Thread transactionThread2 = new Thread(){
//            public void run(){
//                account1.deposit(207.56);
//                account1.withdraw(40);
//            }
//        };

        // 2nd way of Creating & starting a thread: implement new Instance of Runnable
        Thread transactionThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account1.deposit(300.00); // account1 need to be final to be accessible in inner class
                account1.withdraw(50.00);
            }
        });

        Thread transactionThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account1.deposit(207.56);
                account1.withdraw(40);
            }
        });

        // Make the BankAccount class Threadsafe using synchronized keywords
        transactionThread1.start();
        transactionThread2.start();
    }
}
