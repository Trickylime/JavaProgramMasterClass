package dev.lpa;

public abstract class ProductForSale {

    protected String type;
    protected double price;

    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getPrice(int quantity) {
        return price * quantity;
    }

    public String printItemizedList(int quantity){
        return quantity + "x" + type + " £" + price + " total: " +
                getPrice(quantity);
    }

    public abstract void showDetails();

    @Override
    public String toString() {
        return "ProductForSale" + "-> " + type + " - " + price +
                " - " + description;
    }
}
