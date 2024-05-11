package dev.lpa;

import java.util.HashSet;
import java.util.List;

public class Store {

    String storeName;
    private List<Product> inventory;
    private HashSet<Cart> carts;
    private HashSet<InventoryItem> aisleInventory;

    public Store(String storeName, List<Product> inventory, HashSet<Cart> carts, HashSet<InventoryItem> aisleInventory) {
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
