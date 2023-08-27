package dev.lpa.burger;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);

        Meal customBurger = new Meal();
        String[] toppings = {"Cheese", "bacon", "lettuce", "onion",
                "mayo", "ketchup"};
        customBurger.addToppings(toppings);
        System.out.println(customBurger);

    }
}
