package lowleveldesign.strategy.with_strategy;

public class SportDrivingStrategy implements DrivingStrategy{
    @Override
    public void drive() {
        System.out.println("Sporting Driving capability");
    }

    @Override
    public int getTopSpeed() {
        return 200;
    }
}
