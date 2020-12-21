package com.company;

// you can only have public methods within an Interface, to provide methods that have to be implemented

interface Accessible { // visible to all other packages b/c it's an interface, if it was a class, it'd be private
    int SOME_CONSTANT= 100; // visible to public since in public Accessible class
    public void methodA(); // visible to all packages
    void  methodB(); // this public
    boolean methodC(); // still public

}
