package com.company;

import java.util.Locale;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAge(int age){
        if (0 > age || age > 120){
            this.age = 0;
        } else this.age = age;
    }


    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }

    public boolean isTeen(){
        if (12 < age && age < 20){
            return true;
        } else return false;
    }

    public String getFullName(){
        if (firstName.isEmpty() && lastName.isEmpty()){
            return "";
        } else if (firstName.isEmpty()){
            return lastName;
        } else if (lastName.isEmpty()){
            return firstName;
        } else {
        String fullName = firstName +' '+ lastName;
        return fullName;
        }
    }

}
