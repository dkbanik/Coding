package wrap.javadesignpatterns.strategy.with_strategy;

public class NormalDrivingStrategy implements DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("Normal Vehicle driving capability");
    }

    @Override
    public int getTopSpeed() {
        return 100;
    }
}
