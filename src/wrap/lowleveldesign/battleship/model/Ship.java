package wrap.lowleveldesign.battleship.model;

import wrap.lowleveldesign.battleship.service.CoordinateFinder;

import java.util.List;
import java.util.Map;

public abstract class Ship implements IShip{
    private String name;
    private Board board;
    private ShipPlacement shipPlacement;
    private ShipStatus status;
    private Map<String, List<Coordinate>> shipCoordinatesMap;

    Ship(String name, Board board, ShipPlacement shipPlacement, Coordinate coordinate){
        this.board = board;
        this.name = name;
        this.status=ShipStatus.NEW;
        this.shipPlacement = shipPlacement;
        blockCoordinate(coordinate);
    }

    private void blockCoordinate(Coordinate coordinate) {
        coordinate.setShip(this);
        coordinate.setStatus(CoordinateStatus.TAKEN);
        for(int i=1;i<getSize();i++){
            String nextCoordinateName = null;
            if(shipPlacement == ShipPlacement.HORIZONTAL){
                nextCoordinateName = (coordinate.getX()+i)+""+coordinate.getY();

            }else {
                nextCoordinateName = coordinate.getX()+""+(coordinate.getY()+i);
            }
            Coordinate nextCoordinate = CoordinateFinder.getCoordinateByName(nextCoordinateName);
            nextCoordinate.setShip(this);
            nextCoordinate.setStatus(CoordinateStatus.TAKEN);
        }

    }

    public Board getBoard() {
        return board;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public Map<String, List<Coordinate>> getShipCoordinatesMap() {
        return shipCoordinatesMap;
    }

    public ShipPlacement getShipPlacement() {
        return shipPlacement;
    }


}
