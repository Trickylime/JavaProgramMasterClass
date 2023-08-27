public class Main {

    public static void main(String[] args) {

//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();
//
//        Item avocado = new Item("Topping", "avocado", 1.50);
//        avocado.printItem();

//        Burger burger = new Burger("regular", 4.00);
//        burger.addTopping("BACON", "CHEESE", "MAYO");
//        burger.printItem();

//        MealOrder regularMeal = new MealOrder();
//        regularMeal.addBurgerToppings("BACON", "CHEESE", "MAYO");
//        regularMeal.setDrinkSize("large");
//        regularMeal.printItemizedList();

//        MealOrder secondMeal = new MealOrder("turkey", "7up",
//                "chili");
//        secondMeal.addBurgerToppings("lettuce", "cheese", "mayo");
//        secondMeal.setDrinkSize("small");
//        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "7up",
                "chili");
        deluxeMeal.addBurgerToppings("AVOCADO", "BACON", "LETTUCE",
                "CHEESE", "MAYO");
        deluxeMeal.setDrinkSize("small");
        deluxeMeal.printItemizedList();


    }
}
