package com.company;

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

        temp = new StockItem("ball", 1.0, 700);
        stockList.addStock(temp);

        temp = new StockItem("table", 109.99, 70);
        stockList.addStock(temp);

        temp = new StockItem("door", 1.15, 6);
        stockList.addStock(temp);

        temp = new StockItem("phone", 45.50, 500);
        stockList.addStock(temp);

        System.out.println(stockList);
    }
}
