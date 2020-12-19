package com.company;

// 4 types of nested classes:
// static, inner (non-static), local (inner class defined in a scope block), anonymous (nested w/o a className)

// A static nested class is used to associate a class with it's outer class. It's identical to a top level class
// but the difference is it's packaged in it's outer class rather than in it's package

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print"); // adding a btn named print

    public static void main(String[] args) {



        GearBox mcLaren = new GearBox(6);

// Previous way of running test when GearBox dealt with all the functionality instead of it's inner class: Gear
        //   GearBox.Gear first = mcLaren.new Gear(1,12.3); // Create an instance name like mnLaren
        //   This doesn't work:      GearBox.Gear second = new GearBox.Gear(2,15.4); // not an enclosing class
        //   Neither does this:      GearBox.Gear third = new mcLaren.Gear(2,15.4); // can't resolve a single gear
        //   System.out.println(first.driveSpeed(1000)); // revs * ratio

//        mcLaren.addGear(1,5.3);
//        mcLaren.addGear(2, 10.6);
//        mcLaren.addGear(3, 15.9);

        // for multiple buttons, it's better to use an anonymous class rather than a local class
//        class ClickListener implements Button.OnClickListener { // this local class is only applicable for the code block below only
//            public ClickListener(){
//                System.out.println("I've been attached");
//            }
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.SetOnClickListener(new ClickListener());

        // here's an anonymous class, it's distinguished by using new OnClickListeners with no name used within the {}
        btnPrint.SetOnClickListener(new Button.OnClickListener() { // shortcut:type " new On" + press "enter"
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });

        listen();

        mcLaren.operateClutch(true); // switching to clutch (manual), from automatic
        mcLaren.changeGear(1); // changing gear to 1
        mcLaren.operateClutch(false); // switching back to automatic
        System.out.println(mcLaren.wheelSpeed(1000)); // Gear 1 selected // 5300.00
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000)); // Grind! // 0.0
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3); // gear 3 selected
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000)); // 95400

    }
    private static void listen(){
        boolean quit = false;
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
