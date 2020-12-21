package com.company;

public class Main {
    // if method is static it can be shadowed but not overwritten
    public static void main(String[] args) {
        // Walmart's discounts only effect Walmart, thus the scope is confined to just Walmart's
        // The scope of the discount increases if other stores follow Walmart's approach  & adopt the same discount

        // Java objects follow the same approach..

        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance varOne is "+ scopeInstance.getVarOne());
        System.out.println(varFour); // if print privateVar, the scope is set to only variables in Main atm
        System.out.println(); // type the shortcut "sout" + press Enter =  System.out.println()

        scopeInstance.timesTwo(); // calling the local var privateVar of ScopeCheck
                                    // the most narrow scope is used

        System.out.println("****************");

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass(); // creating new instance of inner class
        innerClass.timesTwo();

        scopeInstance.useInner();

// Can't access var like this b/c varThree has private access and no visibility outside it's class or containing class
//        System.out.println("varThree is not accessible here: " + innerClass.varThree);
    }
}
