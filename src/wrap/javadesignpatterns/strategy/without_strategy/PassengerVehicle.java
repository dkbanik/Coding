package wrap.javadesignpatterns.strategy.without_strategy;

public class PassengerVehicle implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Normal Vehicle driving capability");
    }
}
