package dev.lpa;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        /*
        Todo:
         Set up enum class in Product class to manage the different product types
         Add inventory to the storeInventory HashSet

        */

        HashSet<InventoryItem> storeInventory = new HashSet<>();
        //storeInventory.addAll()
        HashSet<Cart> storeCarts = new HashSet<>();
        HashSet<Product> aisleInventory = new HashSet<>();


        Store store = new Store("Jack's Store", storeInventory, storeCarts,
                aisleInventory);
    }
}
