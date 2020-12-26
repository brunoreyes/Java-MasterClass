package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list; // <key, quantityOrdered> nameOfList

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>(); // each initialization of list will be it's own treeMap
        // and the treeMap is sorting the items & displaying them in alphabetical order

        // TreeMaps processing takes than Hash or LinkedMap due to processing & sorting items.
    }

    public int addToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() +
                (list.size() == 1 ? " item":" items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item: list.entrySet()){
            s = s + item.getKey().getPrice() + ". " + item.getValue();
            totalCost += item.getKey().getPrice() + item.getValue();
        }
        return s + " Total cost: $" + totalCost;
    }
}
