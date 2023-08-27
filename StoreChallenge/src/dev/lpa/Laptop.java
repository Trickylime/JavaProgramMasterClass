package dev.lpa;

public class Laptop extends ProductForSale{
    public Laptop(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " - " + description +
                " - i7 12core 2.75ghz processor, 32gb RAM, 3050ti nvidia gpu " +
                        "and 2tb ssd");
    }
}

class Mouse extends ProductForSale{

    public Mouse(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " - " + description +
                " - 100 customizable buttons and built in auto aim so you never miss");
    }
}

class Keyboard extends ProductForSale{

    public Keyboard(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " - " + description +
                " - Uber too-bright light system, with loudest keys you've ever heard");
    }
}
