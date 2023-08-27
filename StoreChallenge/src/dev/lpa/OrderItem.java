package dev.lpa;

public class OrderItem {

    private int quantity;
    private ProductForSale productForSale;

    public OrderItem(int quantity, ProductForSale productForSale) {
        this.quantity = quantity;
        this.productForSale = productForSale;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    public int getQuantity() {
        return quantity;
    }
}
