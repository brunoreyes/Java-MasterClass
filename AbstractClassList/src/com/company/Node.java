package com.company;

// Node is a concrete class that extends ListItem

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }
    // having to override methods
    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return item;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return item;
    }

    @Override
    int compareTo(ListItem item) {
        if ( item != null ){ // using Strings because they come with a compare to method
          return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1; // any value would be greater than null
        }
    }
}
