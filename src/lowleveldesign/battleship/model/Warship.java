package lowleveldesign.battleship.model;

public class Warship extends Ship implements IShip{

    final private int size = 4;

    public Warship(String name, Board board, ShipPlacement shipPlacement, Coordinate coordinate) {
        super(name, board, shipPlacement, coordinate);
    }

    public int getSize() {
        return size;
    }

    public String getSymbol(){
        return "W";
    }
}
