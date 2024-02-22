package wrap.java_generics;

import java.util.ArrayList;
import java.util.List;

class Building {

    @Override
    public String toString() {
        return ("Building");
    }
}

class Office extends Building {

    @Override
    public String toString() {
        return "Office";
    }
}

public class Generics {
    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();

        //build(building);
        //build(office);

        // Works fine
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        buildings.add(office);

        //printBuildings(buildings);

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());

        // List of Office is not a subtype of List of Buildings, so it wont work
        // printBuildings(offices);

        // This will work as we have used generics which says its a list of type something
        // that extends Building
        printBuildingsUsingGenerics(offices);

//        List<Building> offices1 = new ArrayList<>();
//        offices1.add(new Office());
//        offices1.add(new Office());

        // will work as its a list of buildings
        // printBuildings(offices1);

    }

    public static void build(Building building){
        System.out.println("Constructing a new "+building);
    }

    public static void printBuildings(List<Building> buildings){
        for(Building building: buildings){
            System.out.println(building.toString());
        }
    }

    public static void printBuildingsUsingGenerics(List<? extends Building> buildings){
        for (Building building : buildings){
            System.out.println(building.toString());
        }
    }
}
