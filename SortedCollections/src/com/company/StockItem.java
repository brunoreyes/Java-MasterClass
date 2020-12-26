package com.company;

public class StockItem implements Comparable<StockItem> {
//    storing names of item, quantity and stock
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name; // name and price should be initialized in constructor
        this.price = price;
        this.quantityInStock = 0; // or here (but you wouldn't normally do both).
    }

    public StockItem(String name, double price, int quantityStock) { // overloaded constructor for items without stock
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0){
            this.price = price;
        }
    }
    public void adjustStock(int quantity){ // allows for stock increases/decreases
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0){ // only allowing positive quantity
            this.quantityInStock = newQuantity;
        }
    }
    public int reserveStock(int quantity){
        if (quantity <= availableQuantity()){ // .size() is assumed here
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(int quantity){
        if (quantity <= reserved){
            reserved -= quantity; // Use the method, not the field
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity){
        if (quantity <= reserved){
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if (obj == this){
            return true;
        }
        if (obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo()");
        if (this == o){
            return 0;
        }

        if (o != null){
            return this.name.compareTo(o.getName()); // will get error if using .getName() on a null
        }

        throw new NullPointerException();// if you want to use the compare to function, assume not comparing a null
    }

    @Override
    public String toString() {
        return this.name +"'s price: " + this.price +". Reserved: " + this.reserved;
    }
}
