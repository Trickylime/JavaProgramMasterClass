package dev.lpa;

public class Product {

    enum productCategories {VEGETABLE, BEANS, LEGUMES, WHOLEGAINS, RICE, BREAD, CEREAL, NUTS}

    long sku;
    private static long skuGenerator = 1000000000;
    private String name;
    private String manufacturer;
    private String Category;

    public Product(String name, String manufacturer, String category) {
        this.sku = skuGenerator++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.Category = String.valueOf(productCategories.valueOf(category.toUpperCase()));
    }
}
