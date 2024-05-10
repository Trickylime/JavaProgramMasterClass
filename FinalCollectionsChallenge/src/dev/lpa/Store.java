package dev.lpa;

import java.util.HashSet;

public class Store {

    String storeName;
    private HashSet<InventoryItem> inventory;
    private HashSet<Cart> carts;
    private HashSet<Product> aisleInventory;

    public Store(String storeName, HashSet<InventoryItem> inventory, HashSet<Cart> carts, HashSet<Product> aisleInventory) {
        this.storeName = storeName;
        this.inventory = inventory;
        this.carts = carts;
        this.aisleInventory = aisleInventory;
    }

    public void manageStoreCart() {

    }
    public void checkOutCart() {

    }
    public void abandonCarts() {

    }
    public void listProductsByCategory() {

    }


}
