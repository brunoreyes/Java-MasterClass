package com.company;

// LinkedList is a list that is an alternative to arrays, storing the actual linked item of the list and it's data
// i.e each element in a LinkedList holds a link to the item that follows it, and the actual value you want to store as well


        // Below is why we use linkedList, allowing for the .add(position, newValue) to replace
        // the current value at the position and move that current value down by 1 position,
        // keeping the new value and old value by moving the old one down.
        // This becomes tedious for the computer to calculate if multiple values are being added like this.

        // Example:

            // intList.add(3); // intList[0] = 3
            // intList.add(5); // intList[1] = 5

            // intList.add(0,1); // intList.add(position,value); intList[0] = 1 new value of intList[0] added
                                                            //   intList[1] = 3 old intList[0] turns into new intList[1]
                                                            //   intList[2] = 5 intList[1,2,3,etc.] are all moved down one


// Java allocates 4 bytes for each int placed in a list,
// base address is 100, LinkedList[0], up by 4 each time for int arrayList
// LinkedList[1] = address 104 ...
// LinkedList[3] = address 112 ...

import java.util.ArrayList;

// with String types it varies how many bytes each String takes
// Java uses the String address to find the String
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Bruno", 30.43); // created new instance of customer

        Customer anotherCustomer; // created second instance

        anotherCustomer = customer; // pointing anotherCustomer Class to customer Class
                                    // solely saving the memory address but not creating a new class

        anotherCustomer.setBalance(12.18); // by editing the pointed "anotherCustomer" Class, customer is edited as well

        System.out.println("Balance for customer " + customer.getName() +
                " is " + customer.getBalance()); // Output: 12.18 b/c we changed anotherCustomer and it's pointed to customer

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(3);
        intList.add(5);
        intList.add(7);

        for (int i=0; i < intList.size(); i++){
            System.out.println("intList[" +i + "]: " + intList.get(i));
            // Output Ex: intList[0]: 3
                        //intList[1]: 5
                       // intList[2]: 7
        }

        intList.add(1,2); // inserting the element 2 into index 1 (intList[1] = 2),
                                        // movies the previous value from intList[1] = 5 to intList[2] = 5
        System.out.println("intList after adding an element directly to an index");
        // Verifying the change
        for (int i=0; i < intList.size(); i++){
            System.out.println("intList[" +i + "]: " + intList.get(i));
            // Output Ex: intList[0]: 3
                        //intList[1]: 2 (Newly added value at specific index)
                        //intList[2]: 5 (Previous value of that specific index now moved down)
                        //intList[3]: 7
        }

    }
}
