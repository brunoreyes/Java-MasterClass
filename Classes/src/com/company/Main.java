package com.company;

public class Main {

    // automatically set up class getter and setters:
    //    code > generate > getters and setter
    // public, private, and protected are access modifiers
    // public: means unrestricted access to class
    // private: no other class can access your class
    // protected: only classes within your package can access this class
    public static void main(String[] args) {

        // real world objects have two characteristics, the state and behavior: size, width, weight
        // behavior: booting up, loading objects on the DOM

        // a class is sort of a user-defined datatype

        // classes allow variables to be accessed by the classes, aka fields or member variables

        //private fields adhere to encapsulation, hiding fields and method variables to not be accessed publicly
        // by other classes

        // for ex:  private int doors

        Car porsche = new Car(); // defining an imported object from class: Car, Car and naming it: 'porsche'
        Car holden = new Car(); // initializing object Car by adding = new Car();
        // creating an object called porsche, based on the template: 'car'

        System.out.println("Model is " + porsche.getModel()); // Model is null, null is the internal default state for a class and string
        porsche.setModel("Carrera"); // so we access the public method in class Car to update the value of model
        porsche.setModel("911"); // validation returns an Model is Unknown since it's not one of the valid classes
        System.out.println("Model is " + porsche.getModel());

        SimpleCalculator calculator = new SimpleCalculator();

        calculator.setFirstNumber(9);
        System.out.println("firstNumber = " + calculator.getFirstNumber());

        calculator.setSecondNumber(10);
        System.out.println("secondNumber = " + calculator.getSecondNumber());

        System.out.println(calculator.getFirstNumber() + " * " + calculator.getSecondNumber() + " = " + calculator.getMultiplicationResult());
        System.out.println(calculator.getFirstNumber() + " / " + calculator.getSecondNumber() + " = " + calculator.getDivisionResult());
        System.out.println(calculator.getFirstNumber() + " + " + calculator.getSecondNumber() + " = " + calculator.getAdditionResult());
        System.out.println(calculator.getFirstNumber() + " - " + calculator.getSecondNumber() + " = " + calculator.getSubtractionResult());

        Person person1 = new Person();
        person1.setFirstName("Jack");
        person1.setLastName("Jill");
        person1.setAge(19);

        Person person2 = new Person();
        person2.setFirstName("");
        person2.setLastName("Runner");
        person2.setAge(40);

        Person person3 = new Person();
        person3.setFirstName("Blade");
        person3.setLastName("");
        person3.setAge(10);

        Person person4 = new Person();
        person4.setFirstName("Jerry");
        person4.setLastName("Carey");
        person4.setAge(-10);

        System.out.println(person1.getFirstName() + ' ' + person1.getLastName()
                + " is " + person1.getAge() + " years old");
        System.out.println("It's " + person1.isTeen() + " that " + person1.getFullName()
                + " is a teenager");

        System.out.println(person2.getFirstName() + ' ' + person2.getLastName()
                + " is " + person2.getAge() + " years old");
        System.out.println("It's " + person2.isTeen() + " that " + person2.getFullName()
                + " is a teenager");

        System.out.println(person3.getFirstName() + ' ' + person3.getLastName()
                + " is " + person3.getAge() + " years old");
        System.out.println("It's " + person3.isTeen() + " that " + person3.getFullName()
                + " is a teenager");

        System.out.println(person4.getFirstName() + ' ' + person4.getLastName()
                + " is " + person4.getAge() + " years old");
        System.out.println("It's " + person4.isTeen() + " that " + person4.getFullName()
                + " is a teenager");

        BankAccount account1 = new BankAccount();
        account1.setAccountNumber(203045);
        account1.setBalance(030404.20);
        account1.setCustomerName("Jimmy Wang");
        account1.setEmail("theonly@gmail.com");
        account1.setPhoneNumber(6294905006L);
        BankAccount account2 = new BankAccount("John","john@doe.com",40.33,6503304950L,506060);
        BankAccount account3 = new BankAccount(); // given default values in Bank Account constructor w/o parameters


        System.out.println("Account Created for " + account1.getCustomerName() +
                ", Phone: " + account1.getPhoneNumber() +
                ", Email: " + account1.getEmail() +
                ", Balance: $" + account1.getBalance());

        account1.withdrawalFunds(23.22);
        account1.depositFunds(1023.22);

        System.out.println("Account Created for " + account2.getCustomerName() +
                ", Phone: " + account2.getPhoneNumber() +
                ", Email: " + account2.getEmail() +
                ", Balance: $" + account2.getBalance());

        System.out.println("Account Created for " + account3.getCustomerName() +
                ", Phone: " + account3.getPhoneNumber() +
                ", Email: " + account3.getEmail() +
                ", Balance: $" + account3.getBalance());

        VipCustomer defaultCustomer = new VipCustomer();

        System.out.println("Account Created for " + defaultCustomer.getName() +
                ", Credit Limit: " + defaultCustomer.getCreditLimit() +
                ", Email: " + defaultCustomer.getEmail());

        VipCustomer customer1 = new VipCustomer("Sal", "Sal@pal.com");
        // here we are calling the overloaded VipCustomer method that accepts
        // two parameters and gives out a default value for credit limit from class VipCustomer

        System.out.println("Account Created for " + customer1.getName() +
                ", Credit Limit: " + customer1.getCreditLimit() +
                ", Email: " + customer1.getEmail());

        VipCustomer customer2 = new VipCustomer("Sal", 85000, "Sal@pal.com");
        // here we are calling the overloaded VipCustomer method that accepts
        // two parameters and gives out a default value for credit limit from class VipCustomer

        System.out.println("Account Created for " + customer2.getName() +
                ", Credit Limit: " + customer2.getCreditLimit() +
                ", Email: " + customer2.getEmail());

        Wall defaultWall = new Wall();
        System.out.println("Default Wall Dimensions - Width:" + defaultWall.getWidth() +
                ", Height:" + defaultWall.getHeight() +
                ", Area:" + defaultWall.getArea());

        Wall wall1 = new Wall(-100,200);

        System.out.println("Wall 1 Dimensions - Width: " + wall1.getWidth() +
                ", Height: " + wall1.getHeight() +
                " & Area: " + wall1.getArea());

        Wall wall2 = new Wall(200,-200);

        System.out.println("Wall 2 Dimensions - Width: " + wall2.getWidth() +
                ", Height: " + wall2.getHeight() +
                " & Area: " + wall2.getArea());

        Wall wall3 = new Wall(100,100);

        System.out.println("Wall 3 Dimensions - Width: " + wall3.getWidth() +
                ", Height: " + wall3.getHeight() +
                " & Area: " + wall3.getArea());


//        Find the distance between two points
        Point first = new Point(6,5);
        Point second = new Point(3,1);

        System.out.println("distance(0,0) = "+ first.distance());
        System.out.println("distance(second) = "+ first.distance(second));
        System.out.println("distance(2,2) = "+ first.distance(2,2));
        Point point = new Point();
        System.out.println("distance()= "+ point.distance());


        // find the total cost of a carpet
        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4);
        Calculator floorCarpetCalculator = new Calculator(floor,carpet);
        System.out.println("total= "+ floorCarpetCalculator.getTotalCost());
        carpet = new Carpet(1.5);
        floor = new Floor(5.4, 4.5);
        floorCarpetCalculator = new Calculator(floor, carpet);
        System.out.println("total= "+ floorCarpetCalculator.getTotalCost());

        // complex, real and imaginary numbers
        ComplexNumber one = new ComplexNumber(1,1);
        ComplexNumber two = new ComplexNumber(2.5, -1.5);
        one.add(1,1);// one: (1 + 1i) + (1 + 1i) = one: 2 + 2i
        System.out.println("one.real ="+ one.getRealNumber()+" & one.imaginary ="+ one.getImaginaryNumber()+"i");
        one.subtract(two); // one:(2 + 2i) - two:(2.5 -1.5i) = one: -.5 + 3.5i
        System.out.println("one.real ="+ one.getRealNumber()+" & one.imaginary ="+ one.getImaginaryNumber()+"i");
        two.subtract(one); // two: (2.5 -1.5i) - one-new: (-.5 + 3.5i) = two: 3 - 5i
        System.out.println("two.real="+ two.getRealNumber() + " & two.imaginary ="+ two.getImaginaryNumber()+"i");
    }
}
