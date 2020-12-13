package com.company;


public class Main {

    public static void main(String[] args) {

        Car car = new Car(8,"Base Car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Porsche porsche = new Porsche(6, "Black Knight");
        System.out.println(porsche.startEngine());
        System.out.println(porsche.accelerate());
        System.out.println(porsche.brake());

        RollsRoyce rollsRoyce = new RollsRoyce(6, "Phantom");
        System.out.println(rollsRoyce.startEngine());
        System.out.println(rollsRoyce.accelerate());
        System.out.println(rollsRoyce.brake());

        ToyotaCorolla toyotaCorolla = new ToyotaCorolla(6, "Phantom");
        System.out.println(toyotaCorolla.startEngine());
        System.out.println(toyotaCorolla.accelerate());
        System.out.println(toyotaCorolla.brake());

        Car ford = new Car(6, "Ford Falcon"){
            // This is another way to create a class called creating an "inline class",
            //  right at the point we are initializing it
            // Inline classes are Commonly used within Android applications for functions like click listeners
            @Override
            public int getCylinders() {
                return super.getCylinders();
            }

            @Override
            public String startEngine() {
                return getClass().getSimpleName() +" -> startEngine()";
                        //getClass().getSimpleName() gets the name of the class it's in. In this case: ford
            }

            @Override
            public String accelerate() {
                return "Ford -> accelerate()";
            }

            @Override
            public String brake() {
                return "Ford -> brake()";
            }
        };
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

    }

    static class Porsche extends Car{
        public Porsche( int cylinders, String name) { // each method has a constructor
            super(cylinders, name); // and override versions of startEngine, accelerate, and brake
        }

        @Override
        public String startEngine() {
            return "Porsche -> startEngine()";
        }

        @Override
        public String accelerate() {
            return "Porsche -> accelerate()";
        }

        @Override
        public String brake() {
            return "Porsche -> brake()";
        }
    }

    static class Car{
        private boolean engine;
        private int cylinders;
        private int wheels;
        private String name;

        public Car(int cylinders, String name) {
            this.engine = true;
            this.cylinders = cylinders;
            this.wheels = 4;
            this.name = name;
        }


        // no need to add getters for engine or wheels since they'll always be the same (true & 4)
        public int getCylinders() {
            return cylinders;
        }

        public String getName() {
            return name;
        }
        public String startEngine(){
            return "Car -> startEngine()";
        }
        public String accelerate(){
            return "Car -> accelerate()";
        }
        public String brake(){
            return "Car -> brake()";
        }
    }

    static class RollsRoyce extends Car {
        public RollsRoyce(int cylinders, String name) {
            super(cylinders, name);
        }
        @Override
        public String startEngine() {
            return "RollsRoyce -> startEngine()";
        }

        @Override
        public String accelerate() {
            return "RollsRoyce -> accelerate()";
        }

        @Override
        public String brake() {
            return "RollsRoyce -> brake()";
        }
    }

    static class ToyotaCorolla extends Car {
        public ToyotaCorolla(int cylinders, String name) {
            super(cylinders, name);
        }
        @Override
        public String startEngine() {
            return "ToyotaCorolla -> startEngine()";
        }

        @Override
        public String accelerate() {
            return "ToyotaCorolla -> accelerate()";
        }

        @Override
        public String brake() {
            return "ToyotaCorolla -> brake()";
        }
    }
}

