package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    // Using a map to holds all the stockList items and uses StockItem as a key
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>(); // LinkedHashMap to order list alphabetically
    }

    public int addStock(StockItem item){
        if (item != null){

            // check if we already have quantities for this item;
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // .getOrDefault(getValueOfItemThatExist, orUseItemPassedInParamsAsDefault)
            // inStock will have item, either an item retrieved from the list
            // or an item that has been passed to the method

            // If there are already stocks on this item, adjust the quantity
            if (inStock != item){
                item.adjustStock(inStock.getQuantityInStock()); // if the values aren't the same
                // then pass the values that are already in the map to the item
            }

            list.put(item.getName(), item); // .put(primaryKey, itemItself);
            // getting primary key and the item itself

            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){ // decreasing sold Stock
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (inStock.getQuantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            return quantity; // indicating how many items were sold
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key); // will return null if nothing exist
    }

    public Map<String, Double> PriceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item: list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    } // recall when calling params in Maps or List we call their class
    // by capitalizing the type. For ex: double >> Double

    public Map<String, StockItem> Items (){
        return Collections.unmodifiableMap(list);
        // allowing users to have read-only access to map,
    }

    @Override
    public String toString() { // not good in practice b/c toString() is mainly used for debugging
        // returning list of all items for this StockList class
        String s = "\nStock List \n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();

            s = s + stockItem.getName() + ". There are " + stockItem.getQuantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f" , itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + " Total stock value: $" + totalCost;
    }


}
