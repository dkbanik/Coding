package wrap.lowleveldesign.strategy.with_strategy;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Vehicle vehicle = new PassengerVehicle();
        vehicle.drive();
        System.out.println(vehicle.getTopSpeed());
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }
}
