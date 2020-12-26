package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread",0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 0.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("cup", 10.05, 79);
        stockList.addStock(temp);

        temp = new StockItem("bowl", 1.15, 756);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("ball", 1.0, 700);
        stockList.addStock(temp);

        temp = new StockItem("table", 109.99, 70);
        stockList.addStock(temp);

        temp = new StockItem("door", 1.15, 6);
        stockList.addStock(temp);

        temp = new StockItem("phone", 45.50, 500);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s: stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket brunoBasket = new Basket("Bruno");
        sellItem(brunoBasket, "car", 1);
        System.out.println(brunoBasket);

        sellItem(brunoBasket, "car", 1);
        System.out.println(brunoBasket);
        if (sellItem(brunoBasket, "car", 1) != 1){
            System.out.println("Sorry we cannot sell a car because we are out of stock. ");
        }; // don't have 3 cars test

        System.out.println(brunoBasket);
        sellItem(brunoBasket, "spanner", 1); // don't have item spanner test
        System.out.println(brunoBasket);

        sellItem(brunoBasket, "juice", 4);
        sellItem(brunoBasket, "cup", 12);

        System.out.println(stockList);

//        temp = new StockItem("pen",12);
//        stockList.Items().put(temp.getName(), temp); // since we can't modify a read-only
//        version of a map ( aka an unmodifiable map) this line produced an error

        // item's can't be added/removed to a unmodifiable map but they can be updated
        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000); // can directly access the list variable

        System.out.println(stockList);

        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + ": costs " + price.getValue());
        }
    }
    public static int sellItem(Basket basket, String item, int quantity){
        // retrieve the item from the stock list first:
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item); // if no item, then we don't sell it
        }
        if (stockList.reserveStock(item,quantity) != 0){ // means we have a valid quantity ( >=1 )
            return basket.addToBasket(stockItem,quantity);
        }
        return 0; // Could not sell due to insufficient stock aka out of stock
    }

    public static int removeItem(Basket basket, String item, int quantity){
        // retrieve the item from the stock list first:
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item); // if no item, then we don't sell it
        }
        if (basket.removeFromBasket(stockItem,quantity) == quantity){
            return stockList.unReserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue()); // item, quantity
        }
        basket.clearBasket(); // clearing basket after items from basket have been checked out
    }
}
