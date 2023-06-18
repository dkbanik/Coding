package lowleveldesign.battleship.model;


public class Ironclad extends Ship implements IShip{

    final private int size = 2;

    public Ironclad(String name, Board board, ShipPlacement shipPlacement, Coordinate coordinate) {
        super(name, board, shipPlacement, coordinate);
    }

    public int getSize() {
        return size;
    }

    public String getSymbol(){
        return "I";
    }
}
