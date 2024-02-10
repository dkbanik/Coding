package lowleveldesign.strategy.without_strategy;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new PassengerVehicle();
        vehicle.drive();

    }
}