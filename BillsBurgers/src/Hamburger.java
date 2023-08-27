public class Hamburger {

    private String name, meat, breadRollType;
    private double price;

    private String addition1Name, addition2Name, addition3Name, addition4Name;
    private double addition1Price, addition2Price, addition3Price, addition4Price;

    public Hamburger(String name, String meat, double price,
                     String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;

    }
    public void addHamburgerAddition2(String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }
    public void addHamburgerAddition3(String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }
    public void addHamburgerAddition4(String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger(){
        System.out.println("One order of " + name + " on " + breadRollType +
                " with " + meat + " price is " + price);
        System.out.println("Added " + addition1Name + " for an extra " + addition1Price);
        System.out.println("Added " + addition2Name + " for an extra " + addition2Price);
        System.out.println("Added " + addition3Name + " for an extra " + addition3Price);
        System.out.println("Added " + addition4Name + " for an extra " + addition4Price);
        return price + addition1Price + addition2Price + addition3Price +
                addition4Price;
    }
}

class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("DeluxeBurger", "Deluxe Meat",
                 19.10, "Deluxe Bread Roll");
        super.addHamburgerAddition1("Chips", 0);
        super.addHamburgerAddition2("Drink", 0);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("No additional items can be added to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("No additional items can be added to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("No additional items can be added to a Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("No additional items can be added to a Deluxe Burger");
    }
}

class HealthyBurger extends Hamburger {

    private String healthyExtra1Name, healthyExtra2Name;
    private double healthyExtra1Price, healthyExtra2Price;

    public HealthyBurger(String meat,  double price) {
        super("Healthy Burger", meat, price,
                "Healthy Bread Roll");
    }

    public void addHealthyAddition1 (String name, double price){
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;

    }
    public void addHealthyAddition2 (String name, double price){
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger() + healthyExtra1Price + healthyExtra2Price;
    }
}
