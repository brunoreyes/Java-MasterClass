package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list; // <key, quantityOrdered> nameOfList

    public Basket(String name, Map<StockItem, Integer> list) {
        this.name = name;
        this.list = new HashMap<>(); // each initialization of list will be it's own hashMap
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
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item: list.entrySet()){
            s = s + item.getKey().getPrice() + ". " + item.getValue();
            totalCost += item.getKey().getPrice() + item.getValue();
        }
        return s + " Total cost: $" + totalCost;
    }
}
