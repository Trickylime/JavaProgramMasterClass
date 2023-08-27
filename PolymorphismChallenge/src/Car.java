public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }


    public void startEngine(){
        System.out.println("You start the engine to your " + description);
    }

    public void drive() {
        System.out.println("You are driving your Car");
    }

    protected void runEngine(){
        System.out.println("Your Car Engine is running");

    }
}
