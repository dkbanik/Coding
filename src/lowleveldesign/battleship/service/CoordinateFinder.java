package lowleveldesign.battleship.service;

import lowleveldesign.battleship.model.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class CoordinateFinder {
    private static Map<String, Coordinate> coordinateByName = new HashMap<>();

    public static void setCoordinateByName(Coordinate coordinate){
        coordinateByName.put(coordinate.getName(), coordinate);
    }

    public static Coordinate getCoordinateByName(String name){
        return coordinateByName.get(name);
    }
}
