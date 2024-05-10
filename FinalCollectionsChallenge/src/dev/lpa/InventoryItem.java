package dev.lpa;

public class InventoryItem {

    private Product product;
    private int qtyTotal;
    private int ptyReserved = 0;
    private int qtyReorder = 0;
    private int qtyLow = 3;
    private int salesPrice;

    public InventoryItem(Product product, int qtyTotal, int ptyReserved, int qtyReorder,
                         int salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.ptyReserved = ptyReserved;
        this.qtyReorder = qtyReorder;
        this.salesPrice = salesPrice;
    }

    public void reserveItem() {

    }
    public void releaseItem() {

    }
    public void sellItem() {

    }
    public void placeInventoryOrder() {

    }
}
