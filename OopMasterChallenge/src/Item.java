public class Item {
    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, String name, double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    public String getName() {

        if(type.equals("SIDE") || type.equals("DRINK")){
            return size + " " + name;
        }

        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice(){
        return switch (size.toUpperCase()) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default ->  getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }
    public void printItem(){
        printItem(getName(), getAdjustedPrice());
    }
}
class Burger extends Item{

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super("Burger", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                ((extra1 == null ? 0 : extra1.getAdjustedPrice())) +
                ((extra2 == null ? 0 : extra2.getAdjustedPrice())) +
                ((extra3 == null ? 0 : extra3.getAdjustedPrice()));
    }

    public double getExtraPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addTopping(String extra1, String extra2, String extra3){

        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));

    }

    public void printItemizedList(){

        printItem("BASE BURGER", getBasePrice());
        if(extra1 != null){
            extra1.printItem();
        }
        if(extra2 != null){
            extra2.printItem();
        }
        if(extra3 != null){
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}

class DeluxeBurger extends Burger {

    Item deluxe1;
    Item deluxe2;

    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    public void addTopping(String extra1, String extra2, String extra3,
    String extra4, String extra5) {
        super.addTopping(extra1, extra2, extra3);
        deluxe1 = new Item("TOPPING", extra4, 0);
        deluxe2 = new Item("TOPPING", extra5, 0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if(deluxe1 != null){
            deluxe1.printItem();
        }
        if (deluxe2 != null){
            deluxe2.printItem();
        }
    }

    @Override
    public double getExtraPrice(String toppingName) {
        return 0;
    }
}
