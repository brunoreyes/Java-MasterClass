package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

        // Lambda Expression has 3 parts: argument list >> arrow token >> body
        // Thread((EmptyArgumentList)-ArrayToken> body
        // Eliminating the need for runnable
//        new Thread(()-> System.out.println("Printing from the Runnable")).start();
        //Or
        new Thread(()-> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n",3);
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee bon = new Employee("Bon John", 10);
        Employee jillian = new Employee("Jillian Smith", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(bon);
        employees.add(jillian);

        // sorting by A-Z
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }

    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//class CodeToRun implements Runnable{
//    @Override
//    public void run(){
//        System.out.println("Printing from the Runnable");
//    }
//}

