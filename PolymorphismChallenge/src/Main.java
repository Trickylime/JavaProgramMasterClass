public class Main {

    public static void main(String[] args) {
        Car car = new Car("Car");
        car.startEngine();

        Car gas = new GasPoweredCar("Gas Car", 10.5,
                4);
        gas.startEngine();
        gas.drive();

        ElectricCar electric = new ElectricCar("Electric Car", 500,
                500);
        electric.startEngine();
        electric.drive();

        HybridCar hybrid = new HybridCar("Hybrid Car", 15,
                250, 4);
        hybrid.startEngine();
        hybrid.drive();
    }
}
