package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    // Streams = a sequence of computations ( computational steps that are chained together)

        List<String> someBingoNumbers = Arrays.asList(
                "N40","B43","N32","I89","E39","R12","F24","G59","H74","U12","I36","O71"
                ,"G53","G20","g49");

        List<String> numbersStartingWithG = new ArrayList<>();

//        someBingoNumbers.forEach(number -> { // for each number within Array someBingoNumbers
//            // .startsWith method sees if the passed parameter "G" is the first char of number
//            if (number.toUpperCase().startsWith("G")){
//                numbersStartingWithG.add(number);
//                System.out.println(number);
//            }
//        });
//
//        numbersStartingWithG.sort((String s1, String s2) -> s1.compareTo(s2));
//        numbersStartingWithG.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                .stream() // returns a sequential stream of computations
                // each operation below should be seen an an independent step operating on a string argument
                // "::" is a method reference that can be utilized when a lambda calls an existing method
                .map(String::toUpperCase) // 1st: map through someBingoNumbers & return them all uppercase
                .filter(s->s.startsWith("G")) // 2nd: filtering the new mapped list for items start w/ "G"
                .sorted() // 3rd: sorting the filtered items that started with g in numerical order
                .forEach(System.out::println); // 4th: printing each item out in sorted order

        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71"); // streams can only contain 1 type
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);// concat adds the streams
//        System.out.println(concatStream.count()); //10
        // .distinct will get rid of duplicated and only show unique items
//        System.out.println(concatStream.distinct().count());  //6
        // .peak() reveals the items within the stream
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jack);
        hr.addEmployee(jane);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                // .flatMap() is used to flatten a nested list
                // for ex: so I am going into each department and getting each departments employees
                // and printing them out. flatMap is great to use to get a list from a targeted object
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                // supplier: ArrayList:: new
                // accumulator: ArrayList:: add, used to add a single item into the list/result
                // combiner: ArrayList:: addAll, improves the efficiency of the operation

        //Performs a mutable reduction operation on the elements of this stream.
                // A mutable reduction is one in which the reduced value is a mutable
                // result container, such as an ArrayList, and elements are incorporated
                // by updating the state of the result rather than by replacing the result.
                // This produces a result equivalent to:
                .collect(ArrayList:: new, ArrayList:: add, ArrayList:: addAll);

        for (String s: sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                // groupingBy() helps creating a map of list that are grouped by age
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        // Finding the youngest employee in the stream
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                // .reduce() takes in two values and outputs 1
                .ifPresent(System.out::println); //ifPresent() prints if true

        Stream.of("ABC", "AC","BAA","CCCC","XY", "ST")
                .filter(s ->{
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}

//        int sum = widgets.stream()
//                .filter(w -> w.getColor() == RED)
//                .mapToInt(w -> w.getWeight())
//                .sum();

// Lambda Best Practices
// 1. Specify the types of parameters vs. letting the compiler infer the,
// 2. Used a return statement with curly braces for one statement lambda expression vs.
// not using return because it's implied (and hence not requiring curly braces)
// 3. Try to use lambda expressions that have one statement rather than multiple statements
// 4. Use parenthesis when a lambda expression has more than only one argument
