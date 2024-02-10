package lowleveldesign.strategy.with_strategy;

public class OffroadVehicle extends Vehicle{
    OffroadVehicle() {
        super(new SportDrivingStrategy());
    }
}
