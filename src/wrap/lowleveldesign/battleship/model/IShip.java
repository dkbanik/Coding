package wrap.lowleveldesign.battleship.model;

import java.util.List;
import java.util.Map;

public interface IShip {
    int getSize();
    Board getBoard();
    ShipStatus getStatus();
    Map<String, List<Coordinate>> getShipCoordinatesMap();
    ShipPlacement getShipPlacement();
    String getSymbol();
}
