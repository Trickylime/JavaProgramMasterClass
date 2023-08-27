package dev.lpa.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("Fires", "side", 2.0);
    }

    public double getTotal(){

        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    public void addToppings(String... topping){
        burger.addTopping(topping);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total Due: ", getTotal());
    }

    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    private class Burger extends Item{

        private List<Item> toppings = new ArrayList<>();

        Burger(String name) {
            super(name, "burger", 5.0);
        }

        private void addTopping(String... name){

            for (String s : name) {
                s = s.toUpperCase();
                switch (s) {
                    case "BACON" -> toppings.add
                            (new Item(s, "topping", 1.5));
                    case "CHEESE" -> toppings.add
                            (new Item(s, "topping", 1.0));
                    case "HAMBURGER" -> toppings.add
                            (new Item(s, "topping", 2.0));
                    default -> toppings.add
                            (new Item(s, "topping", 0.0));
                }
            }

        }
        public double getPrice() {


            double total = super.price;
            for(Item topping : toppings){
                total += topping.price;
            }
            return total;
        }



        @Override
        public String toString() {

            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings){
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }
}
