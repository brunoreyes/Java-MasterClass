package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
       public static void main(String[] args) {
           Runnable runnable = new Runnable() {
               @Override
               public void run() {
                   String myString = "Let's split this up into an array";
                   String[] parts = myString.split(" ");
                   for (String part : parts
                   ) {
                       System.out.println(part);
                   }
               }
           };


        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(lambdaFunction.apply("1234567890"));

        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

           Supplier<String> iLoveJava = () -> "I love Java";
           String supplierResult = iLoveJava.get();
           System.out.println(supplierResult);

           List<String> topNames2015 = Arrays.asList(
                "Ameila",
                "Olivia",
                "emily",
                "Isla",
                "oliver",
                "harry",
                "jacob",
                "Charlie",
                "Ava"
           );

           List<String> firstUpperCaseList = new ArrayList<>();
           topNames2015.forEach(name ->
                   firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//           firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//           firstUpperCaseList.forEach(s -> System.out.println(s));
           // changing code to use method references instead off full method
           firstUpperCaseList.sort(String::compareTo);
           // print out each item of firstUpperCaseList on a new line
           firstUpperCaseList.forEach(System.out::println);
    }


    public static String everySecondCharacter(Function<String, String> func, String source){
           return func.apply(source);
    }
    // The criteria that has to be met in order to map a lambda expression to it:
    // The interface has to be a functional interface with only a single method that can be implemented to it.
    // Most of the time, the documentation for an interface stat's whether it's a functional interface or not.

    // So can a lambda expression represent an instance of java.util.concurrent.Callable interface?
    //java.util.concurrent.Callable can be represented by a lambda expression
    //java.util.concurrent.Comparator can be represented by a lambda expression

}


