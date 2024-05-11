package dev.lpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Todo:
         Set up enum class in Product class to manage the different product types
         Add inventory to the storeInventory HashSet

        */

        List<Product> storeInventory = new ArrayList<>();
        storeInventory.add(new Product("Broccoli", "Happy Farm", "Vegetable"));
        storeInventory.add(new Product("Kidney Beans", "Happy Farm", "Beans"));
        storeInventory.add(new Product("Red Split Lentils", "Happy Farm", "Legumes"));
        storeInventory.add(new Product("Whole Wheat Pasta", "Italian boyos", "Wholegains"));
        storeInventory.add(new Product("White Rice", "Asia Imports", "Rice"));
        storeInventory.add(new Product("Whole Grain Brown Bread", "BreadGang", "Bread"));
        storeInventory.add(new Product("Scottish Oats", "Nay Bother", "Cereal"));
        storeInventory.add(new Product("Walnuts", "Olam", "Nuts"));

        HashSet<Cart> storeCarts = new HashSet<>();

        HashSet<InventoryItem> aisleInventory = new HashSet<>();
        aisleInventory.add(new InventoryItem(storeInventory.get(0), 20, 2.50));
        aisleInventory.add(new InventoryItem(storeInventory.get(1), 100, 1.00));
        aisleInventory.add(new InventoryItem(storeInventory.get(2), 100, 2.00));
        aisleInventory.add(new InventoryItem(storeInventory.get(3), 100, 2.00));
        aisleInventory.add(new InventoryItem(storeInventory.get(4), 200, 1.00));
        aisleInventory.add(new InventoryItem(storeInventory.get(5), 50, 1.50));
        aisleInventory.add(new InventoryItem(storeInventory.get(6), 50, 0.80));
        aisleInventory.add(new InventoryItem(storeInventory.get(7), 20, 3.50));


        Store store = new Store("Jack's Store", storeInventory, storeCarts,
                aisleInventory);
    }
}
