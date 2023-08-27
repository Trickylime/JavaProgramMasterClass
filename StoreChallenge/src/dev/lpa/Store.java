package dev.lpa;

import java.util.ArrayList;

public class Store {

    private static ArrayList<OrderItem> orderItems;
    private static ArrayList<ProductForSale> products = new ArrayList<>();

    public static void main(String[] args) {



        products.add(new Laptop("Laptop", 1000,
                "Gaming Laptop"));
        products.add(new Keyboard("Gaming Keyboard", 150,
                "LED Mechanical Keyboard"));
        products.add(new Mouse("Gaming Mouse", 80,
                "High Speed Gaming Mouse"));

        for(int i = 0; i < products.size(); i++){
            System.out.println(products.get(i));
        }

        System.out.println("Order 1");
        var order1 = new ArrayList<OrderItem>();
        addOrderItem(order1, 0, 3);
        addOrderItem(order1, 1, 3);
        addOrderItem(order1, 2, 3);

        printOrder(order1);
    }
    public static void addOrderItem(ArrayList<OrderItem> order, int orderIndex,
                                    int quantity){

        order.add(new OrderItem(quantity, products.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){

        double priceTotal = 0;

        System.out.println("-".repeat(10));
        System.out.println("Your order receipt: ");

        for(int i = 0; i < order.size(); i++){
            System.out.print("[" + (i+1) + "] ");
            System.out.println(order.get(i).getProductForSale().
                    printItemizedList(order.get(i).getQuantity()));
            priceTotal += order.get(i).getProductForSale().
                    getPrice(order.get(i).getQuantity()) ;


        }
        System.out.println("Total: £" + priceTotal);
        System.out.println("-".repeat(10));



    }
}
