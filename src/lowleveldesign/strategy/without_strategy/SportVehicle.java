package lowleveldesign.strategy.without_strategy;

public class SportVehicle implements Vehicle{

    @Override
    public void drive() {
        // common function for offroad, we should reuse this
        System.out.println("Sporting Driving capability");
    }
}
