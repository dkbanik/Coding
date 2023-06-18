package lowleveldesign.battleship.model;

public class Submarine extends Ship implements IShip{

    final private int size = 3;

    public Submarine(String name, Board board, ShipPlacement shipPlacement, Coordinate coordinate) {
        super(name, board, shipPlacement, coordinate);
    }

    public int getSize() {
        return size;
    }

    public String getSymbol(){
        return "S";
    }
}
