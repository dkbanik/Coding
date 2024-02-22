package wrap.lowleveldesign.strategy.without_strategy;

public class OffroadVehicle implements Vehicle{

    @Override
    public void drive() {
        // common function for sport vehicle, we should reuse this
        System.out.println("Sporting driving capability");
    }
}
