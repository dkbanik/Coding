package lowleveldesign.strategy.with_strategy;

public class Vehicle {
    DrivingStrategy drivingStrategy;

    Vehicle(DrivingStrategy drivingStrategy){
        this.drivingStrategy = drivingStrategy;
    }
    public void drive() {
        drivingStrategy.drive();
    }
    public int getTopSpeed(){
        return drivingStrategy.getTopSpeed();
    }
}
