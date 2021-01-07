package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee bon = new Employee("Bon John", 10);
        Employee jillian = new Employee("Jillian Smith", 31);
        Employee red = new Employee("Red Riding Hood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(bon);
        employees.add(jillian);
        employees.add(red);
        employees.add(charming);

        // creating predicate arguments that match the lambda interface
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 & under", employee -> employee.getAge() <= 30);

//        System.out.println("Employees over 30:");
//        System.out.println("==================");
//
//        // lambda for each loop
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });

//        System.out.println("\nEmployees 30 & younger:");
//        System.out.println("==================");
//        employees.forEach(employee -> {
//            if (employee.getAge() <= 30){
//                System.out.println(employee.getName());
//            }
//        });

        // regular for each loop
//        for ( Employee employee: employees) {
//            if (employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }


    }
    // The test method is the functional method in this case & it accepts a predicate
    // that returns a boolean value. We can replace the if conditions used in the two
    // for each calls with a predicate.

    private static void printEmployeesByAge(
            List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("==================");

        for (Employee employee: employees) {
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}

