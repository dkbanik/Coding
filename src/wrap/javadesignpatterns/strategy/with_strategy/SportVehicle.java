package wrap.javadesignpatterns.strategy.with_strategy;

public class SportVehicle extends Vehicle{
    SportVehicle() {
        super(new SportDrivingStrategy());
    }
}
