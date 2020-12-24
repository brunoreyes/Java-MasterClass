package com.company;

public class Dog {
    private final String name;

    public String getName() {
        return name;
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public final boolean equals(Object obj) { // this method can't be overrode again b/c of final
        if (this == obj){
            return true;
        }

        if (obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
