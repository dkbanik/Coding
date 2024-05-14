package wrap.javadesignpatterns.strategy.with_strategy;

public class PassengerVehicle extends Vehicle{
    PassengerVehicle() {
        super(new NormalDrivingStrategy());
    }
}
