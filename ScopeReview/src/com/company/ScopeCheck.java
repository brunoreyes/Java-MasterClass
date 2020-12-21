package com.company;

public class ScopeCheck { // superClass
    public int publicVar = 0; // 0 is the default val
    private int varOne = 1; // previously named privateVar

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar: " + publicVar + ", varOne: " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() { // next enclosing block {}
        int varTwo = 2; // when commenting this line out, prev named privateVar
        // Java determines no local var so picks member var privateVar on line 5
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * varTwo); // current block takes var from next enclosing block
//          System.out.println(i + " times two is " + i * this.privateVar); // "this." to use member var on line 5, not local
        } //        System.out.println("Value of i is now "+ i); // does not work b/c var i is out of scope
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3; // commented out privateVar will be accessed from scopeCheck's member var line 5
                                // prev named privateVar, this var can't be accessed w/o going through scopeCheck
        public InnerClass() {
            System.out.println("InnerClass created, varOne is" + varOne + " varThree is " + varThree);
        }

        public void timesTwo() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + i * varThree);

// won't work if line 25 is commented out i.e it can't find var in local class, "this." looks for vars in local class
//                System.out.println(i + " times two is " + i * this.privateVar);

// will work if line 25 is commented out b/c "ScopeCheck.this." is accessing var from scopeCheck's local class
//                System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
            }
        }
    }


}
