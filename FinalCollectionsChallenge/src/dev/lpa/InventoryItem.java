package dev.lpa;

public class InventoryItem {

    private Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, int qtyTotal, double salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.salesPrice = salesPrice;

        this.qtyReorder = (qtyTotal / 3) * 2;
        this.qtyLow = qtyTotal / 3;
    }

    public boolean reserveItem(int qty) {
        if ((qtyTotal - qtyReserved) >= qty) {
            qtyReserved += qty;
            return true;
        }

        return false;
    }
    public void releaseItem(int qty) {
        qtyReserved -= qty;
    }
    public boolean sellItem(int qty) {

        if (qtyTotal >= qty) {

            qtyTotal -= qty;
            qtyReserved -= qty;

            if (qtyTotal <= qtyLow) placeInventoryOrder();

            return true;
        }

        return false;
    }
    private void placeInventoryOrder() {

        System.out.println("%s : Product stock running low, ordering qty - %d".formatted(product, qtyReorder));
        qtyTotal += qtyReorder;
    }

    @Override
    public String toString() {
        return "%s, £%.2f : Total: %d, Reserve: %d".formatted(product, salesPrice, qtyTotal, qtyReserved);
    }
}
