package com.company;

public class Main {

    //reference is like the address of a house you build (instance)
    // you can copy a reference many times but it's still the same house(instance/object)
    // references can be passed as parameters to constructors and methods
    // House anotherHouse = blueHouse; // creates another reference of blueHouse

    //In Java you always have references to an object in memory, with no way
    // to access an object directly. Everything is done using a reference.


    //instances are each house you build ( or instantiate using the new keyword operator) which
    // are objects. for ex: House blueHouse = new House("blue");

    //class is like a blueprint(plans) for a house. We can build as many houses
    //as possible with a class(plans)

//    "this" v "super"
    // super. is used to access or call the parent class members (usually through extends className like Animal (variables & methods))
    // this. is used to call the current class members (variables and methods)
    // 'this' is required when we have a parameter with the same name as a field (instance variable)
    // 'this' is commonly used in constructors and setters

    // 'super' is commonly used in method overriding aka calling the method with the same name within the parent class.

    //this() is used in constructors
    // super() calls the parent constructor and must be the first statement in a constructor

    // an abstract class is a super class so it's constructors run when someone makes an instance of a concrete subclass.



//    class Shape { // parent class
//        private int x;
//        private int y;

//        public Shape(int x, int y){ // this constructor called by line 67
//            this.x = x;
//            this.y = y;
//        }
//    }
    // constructor good example: constructor chaining,
    // not repeating code for constructor: Rectangle
//    class Rectangle {
//        private int x;
//        private int y;
//        private int width;
//        private int height;
//
//        // 1st constructor
//        public Rectangle(){
//            this(0,0); //calls 2nd constructor
//        }
//        // 2nd constructor (calls 3rd constructor)
//        public Rectangle(){
//            this(0,0, width, height); //calls 3rd constructor
//        }
//        // 3rd constructor initializes all of the instance variables
//        // so the last constructor carries all of the responsibility for initialization
//        public Rectangle(int x, int y, int width, int height){
//            //initializing variables
//            this.x = x;
//            this.y = y;
//            this.height = height;
//            this.width = width;

            //super(x, y);  // calling constructor from parent (Shape)
//        }
//    }

    // but this and super can be used anywhere but static areas which will cause compile-time errors.



//    Method Overloading v Method Overriding

    // Method Overloading - provides two or more separate methods in a class with the same name but different parameters
    // Method return type may or may not be different allowing to reuse the same method & reduce duplicate code.
    // Overloading has nothing to do with Polymorphism but Java refers to it as Compile Time Polymorphism
    // i.e. the compiler decides which method is going to be called based on method name, return type and argument list.
    // overloading can happen in static and instance methods, single class, and sub classes.

    // OverLoading Rules: methods can be overloaded if they have the same name but different # of parameters
    // and overloaded methods may or may not have the same return types, access modifiers, or checked/unchecked exceptions

    //  Method Overriding - is defining a method in a child class that already exists in the parent class.
    //  By extending the parent class (public class Dog extends Animal{}) the child class gets all the methods defined in the parent class.
    // Best Practice: When overriding a method, place an @Override immediately above the method definition.

    // Overriding Rules:
    // - Only inherited methods can be overridden i.e. only able to override in child class
    // - Constructors and private methods cannot be overridden.
    // - Methods that are final cannot be overridden
    // = A subclass can use super.methodName() to call the super class version of an overridden method.


    // Method overriding aka runtime polymorphism & dynamic method dispatch.

    // Method overriding can only be performed in instance methods not static methods.


    // Static methods: declared using a static modifier and can't access instance methods and instance variables directly.
    // Usually used for operations that don't require any data from an instance of class
    // main is a static method and most methods should be declared static if not declared instance

    // Instance methods belong to an instance of a class like: Dog rex = new Dog();
    // To use an instance method we usually have to instantiate the class first usually by using the new keyword
    // Instance methods can access instance methods/variables and static methods/variables

    // Static variables: aka static member variables, every instance of the class shares the same static variables
    // if changes are made to a static variable, all other instances of that variable will see the effect.
    // Good to use for Scanner declared as a static variable, so all static methods can access that scanner directly

    // here since these all instances are created from the 'public static String name; '
    // all instances of dog are called "fluffy" b/c changing one instance of a static variable changes all instances.
    // so this is not a good idea
    //public static String name;
    // Dog rex = new Dog("rex") // output: fluffy
    // Dog fluffy = new Dog(fluffy") // output: fluffy
    //

    // Instance variables: belong to a specific instance of a class. Not shared like static variables
    // Every instance can have a different value (state)
    // Instance variables represent the state of an instance.
    //private String name; // regular instance variable
    // Dog rex = new Dog("rex") // output: rex
    // Dog fluffy = new Dog(fluffy") // output: fluffy

    public static void main(String[] args) {
	// inheritance is when one object inherits similar characteristics but contains differed as well.
        Animal animal = new Animal("Animal",1,1,5,5);
        Dog dog = new Dog("Yorke",2,20,2,4,1,20,"long silky");
        dog.eat(); // calls dog.eat() then dog.chew() then animal.eat()
        dog.walk();

        Lambo lambo = new Lambo(4,2,'L',250000,true,2,0,"Yellow",2,2,1,10);
        lambo.accelerate(45);
        lambo.accelerate(30);
        lambo.accelerate(20);
        lambo.accelerate(-42);

    // finding the radius, area, height, and volume of a Cylinder &
        // inheriting some functionality from parent Class Circle
        Circle circle = new Circle(3.75);
        System.out.println("Circle radius = "+ circle.getRadius());
        System.out.println("Circle area = "+ circle.getArea());

        Cylinder cylinder = new Cylinder(5.55, 7.25);
        // inherited instance methods from parent class Circle
        System.out.println("Cylinder radius = "+ cylinder.getRadius());
        System.out.println("Cylinder area = "+ cylinder.getArea());

        System.out.println("Cylinder height = "+ cylinder.getHeight());
        System.out.println("Cylinder volume = "+ cylinder.getVolume());

        // testing for below zero entries for both radius & height
        Circle circle2 = new Circle(-2);
        System.out.println("Circle radius = "+ circle2.getRadius());
        System.out.println("Circle area = "+ circle2.getArea());

        Cylinder cylinder2 = new Cylinder(-5.55, -2);
        System.out.println("Cylinder radius = "+ cylinder2.getRadius());
        System.out.println("Cylinder area of circle sides= "+ cylinder2.getArea());
        System.out.println("Cylinder height = "+ cylinder2.getHeight());
        System.out.println("Cylinder volume = "+ cylinder2.getVolume());


        // finding the height, width, and length, area, and volume of a cuboid
        // by inheriting from parent class Rectangle via extending and super

         // fault with program, need to make sure W !== L, b/c it's a rectangle
        Rectangle rectangle = new Rectangle(5,10);
        Cuboid cuboid = new Cuboid(5,10,5);
        System.out.println("rectangle width = "+ rectangle.getWidth() +
                ", rectangle length = "+ rectangle.getLength()+
                ", rectangle area = "+ rectangle.getArea() );
        System.out.println("cuboid width = "+ cuboid.getWidth() +
                ", cuboid length = "+ cuboid.getLength()+
                ", cuboid height = "+ cuboid.getHeight()+
                ", cuboid area of rectangle sides = "+ cuboid.getArea()+
                ", cuboid volume = "+ cuboid.getVolume() );

        // testing below zero values
        Rectangle rectangle2 = new Rectangle(-10,-10);
        Cuboid cuboid2 = new Cuboid(-5,-10,-5);
        System.out.println("rectangle2 width = "+ rectangle2.getWidth() +
                ", rectangle2 length = "+ rectangle2.getLength()+
                ", rectangle area = "+ rectangle2.getArea() );
        System.out.println("cuboid width = "+ cuboid2.getWidth() +
                ", cuboid2 length = "+ cuboid2.getLength()+
                ", cuboid2 height = "+ cuboid2.getHeight()+
                ", cuboid2 area of rectangle sides = "+ cuboid2.getArea()+
                ", cuboid2 volume = "+ cuboid2.getVolume() );


    }
}
