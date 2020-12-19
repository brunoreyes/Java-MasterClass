package com.company;

public class MyLinkedList implements NodeList { // MyLinkedList to avoid confusion with the LinkedList built into Java
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
         return this.root;
    }
    // Check for empty listItem first, and add a new item at the head of the list if list is empty
    // but if the list isn't empty then we need to compare each list item with the new item
    // to find the proper position of the new item
    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            this.root = newItem;    // list is empty, this item is now head of the list
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if ( comparison < 0){
                // newItem is greater, move right if possible
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // no next item exists, so we insert item to the end of the list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if ( comparison > 0 ) {
                // newItem is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // node with a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;

                }
                return true;
            } else {
                        // equal
                    System.out.println(newItem.getValue() + " is already present, not added.");
                    return false;
                }
        }
        return false;
    }


    @Override
    public boolean removeItem(ListItem item) {
        if( item != null){
            System.out.println("Deleting item "+ item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                // found the item to delete
                if(currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else {
                // comparison > 0
                // At an item that's greater than the one being deleted
                // so this item is not in the list
                return false;
            }
        } // Reached the end of the list w/o finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
//        if (root == null){
//            System.out.println("The list is empty");
//        }
//        while(root != null){
//            System.out.println(root.getValue());
//            root = root.next();
//        }
        if (root != null){
            System.out.println(root.getValue());
            traverse(root.next());
            // performing recursion, should be used weary, don't use for linked list with substantial # of records
        }
    }
}
