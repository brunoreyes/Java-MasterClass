package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee bon = new Employee("Bon John", 10);
        Employee jillian = new Employee("Jillian Smith", 31);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(bon);
        employees.add(jillian);
        employees.add(red);
        employees.add(charming);

        // Using generics with function
        // First type is the argument type: Employee
        // Second type is the return type: String

        // By using function, we can pass code that accepts and returns a value to a method
        // in the form of a lambda expression and then run that code without having to create
        // an interface and a class that implements the interface. Reducing interface and class use.
        Function<Employee, String> getLastName = (Employee employee) -> {
            // getting a substring after the space in between the first and last name (.indexOf(' ') + 1))
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) ->{
            // getting a substring before the space in between the first and last name (.indexOf(' ')))
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random random1 = new Random();

        for (Employee employee: employees) {
            if (random1.nextBoolean()){
                System.out.println(getAName(getFirstName,employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }
                        // name of function: upperCase
        Function<Employee,String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));

        // using .andThen() method takes the result of the function first name and passes
        // it as a parameter to the upperCase function

        Function chainedFunction = upperCase.andThen(firstName);

        // Recall, Functions only take one argument

        // getting the first name of the first index of the employees arrayList using the
        // comprised function, chainFunction.
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) ->{
            return name.concat(" " + employee.getAge());
        };
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incrementBy5 = i -> i + 5;

        // incrementing the passed operand 10 + 5
        System.out.println(incrementBy5.applyAsInt(10));

        // Recall when I want to use a lambda expression to test a value and return true/false
        // I can use a predicate.


        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");

        // if I need more than 2 arguments within a lambda, it can be done but won't be able to do it
        // with any of the interfaces used in the java.util.function package. This may happen with APIs


    }
    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

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

//        // creating predicate arguments that match the lambda interface
//        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees, "\nEmployees 30 & under", employee -> employee.getAge() <= 30);
//        // creating predicate arguments that match the anonymous interface
//        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//        System.out.println(greaterThan15.test(10)); // output: false
//
//        int a = 14;
//
//        // chaining a predicate
//        System.out.println(greaterThan15.test(a + 5)); // output: true
//
//        System.out.println(greaterThan15.and(lessThan100).test(50)); // output: true: 15 < 50 < 100
//        System.out.println(greaterThan15.and(lessThan100).test(15)); // output: false
//
////        Visualization of each variable being in the scope of each single lambda
////        {
////            int i;
////            return i > 15;
////        }
////
////        {
////            int i;
////            return i < 100;
////        }
//
//        Random random = new Random();
//
//        // Using a supplier to provide a random integer.
//        // Suppliers can supply boolean, double, int,  and longs as well.
//        // Supplier is a functional interface whose functional method is get()
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.get());
//            //System.out.println(random.nextInt(1000));// bounding random numbers to be only as high as 1000
//        }
//
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is: " + lastName);
//        });


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



// The test method is the functional method in this case & it accepts a predicate
// that returns a boolean value. We can replace the if conditions used in the two
// for each calls with a predicate.

