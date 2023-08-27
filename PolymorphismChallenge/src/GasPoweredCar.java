public class GasPoweredCar extends Car{

    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("You start the engine to your Gas Powered Car");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Your Gas Powered Car runs on avg " + avgKmPerLitre +
                "km per litre and has " + cylinders + " cylinders");
    }
}

class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        //super.startEngine();
        System.out.println("You start the engine to your Electric Car");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Your Electric Car runs on avg " + avgKmPerCharge +
                "km per charge and has a battery size of " + batterySize + "Ah");
    }
}

class HybridCar extends Car {

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println("You start the engine to your Hybrid Car");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Your Hybrid Car runs on avg " + avgKmPerLitre +
                "km per litre, has " + cylinders + " cylinders and a battery size of " +
                batterySize + "Ah");
    }
}
