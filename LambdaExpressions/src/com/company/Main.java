package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

        // Lambda Expression has 3 parts: argument list >> arrow token >> body
        // Thread((EmptyArgumentList)-ArrayToken> body
        // Eliminating the need for runnable
//        new Thread(()-> System.out.println("Printing from the Runnable")).start();
        //Or
//        new Thread(()-> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n",3);
//        }).start();

//        Employee john = new Employee("John Doe", 30);
//        Employee bon = new Employee("Bon John", 10);
//        Employee jillian = new Employee("Jillian Smith", 31);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(john);
//        employees.add(bon);
//        employees.add(jillian);


        // sorting by A-Z
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
        // Here the Lambda expression is being passed as a second parameter instead
        // of being an anonymous comparator.
        // ((Employee employee1, Employee employee2): argument list or parameters
        // -> : arrow token
        // body: employee1.getName().compareTo(employee2.getName())
//        Collections.sort(employees, ( employee1,  employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee: employees) {
//            System.out.println(employee.getName());
//        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String UpperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//        employees.get(0).getName(),employees.get(1).getName());
//        System.out.println(sillyString);

//        UpperConcat uc = (String s1, String s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return  result;
//        };
//
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.UpperAndConcat(s1, s2); // calling do something method within another class
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

interface  UpperConcat {
    public String UpperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething(){
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        final int i = 0;
         int i = 0;
         UpperConcat uc = (s1, s2) -> {
             System.out.println("The lambda expression's class is " + getClass().getSimpleName());
             String result = s1.toUpperCase() + s2.toUpperCase();
             return result;
         };
//        {// code within a nest block can reference variables within the enclosing block ( doSomething() )
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String UpperAndConcat(String s1, String s2) {
                    // the var is replaced by whatever the value of i is when it's constructed
//                    System.out.println("i (within anonymous class) = "+ i);
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };

//            System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//            i++;
//            System.out.println("i = " + i);

        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");
        }

//        System.out.println("The AnotherClass's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String UpperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase(Locale.ROOT) + s2.toUpperCase(Locale.ROOT);
//            }
//        },"String1", "String2");
    }

//class CodeToRun implements Runnable{
//    @Override
//    public void run(){
//        System.out.println("Printing from the Runnable");
//    }
//}

