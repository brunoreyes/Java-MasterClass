package com.company;

public interface ITelephone { // proper naming convention it's an interface named Telephone
     void powerOn(); // creating a signature, code will be defined later within the class
     void dial(int phoneNumber); // aka defining the methods that form this class
     void answer();
     boolean callPhone(int phoneNumber);
     boolean isRinging();
}
