package com.company;

import java.util.List;

public abstract class ListItem {

    // Two variables holding references to objects of type ListItem: rightLink & leftLink
    //   thus each ListItem object can hold a link to the previous and the next items in the ultimate saved list.
    // Each of these variables/fields are listed as protected rather than private to be able to access them
    //   via concrete subclasses. listing them as "protected" ensure subclasses within other packages can access them.
    // If I were to leave off "protected", only subclasses within this package can access the variables.
    protected ListItem rightLink = null; // referencing self ( creating instances of ListItem within ListItem class )
    protected ListItem leftLink = null;

    protected Object value;

    // Any concrete class that inherits from list item will need a constructor that sets the value.
    //  It makes sense to place the constructor within the ListItem abstract class so all can inherit from it
    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next(); // returns the next item in the list
    abstract ListItem setNext(ListItem item); // setting the next list item
    abstract ListItem previous(); // goes back to previous item
    abstract ListItem setPrevious(ListItem item); // sets the previous item

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
