package dev.lpa;

public class Product {

    //enum {}
    long sku;
    private String name;
    private String manufacturer;
    private String Category;

    public Product(long sku, String name, String manufacturer, String category) {
        this.sku = sku;
        this.name = name;
        this.manufacturer = manufacturer;
        Category = category;
    }
}
