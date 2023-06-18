package lowleveldesign.battleship.model;

import lowleveldesign.battleship.service.CoordinateFinder;

import java.util.*;

public class Board {

    private UUID id;
    private Player player;
    private int size;
    private List<Coordinate> coordinates;
    private List<IShip> ships;
    private Map<UUID, List<IShip>> boardToShipMap;
    private Map<String, UUID> playerToBoardMap = new HashMap<>();

    public Board(int size, Player player){
        this.id = UUID.randomUUID();
        this.size=size;
        this.player=player;
        playerToBoardMap.put(this.player.getName(), this.id);
        coordinates = new ArrayList<>();
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                Coordinate coordinate = new Coordinate(i,j,this);
                CoordinateFinder.setCoordinateByName(coordinate);
                coordinates.add(coordinate);
            }
        }
        setUpShips();
    }

    private void setUpShips() {
        this.ships = new ArrayList<>();
        Coordinate ic1 = getCoordinateByName("00");
        Coordinate sub1coordinate = getCoordinateByName("01");
        IShip ironClad1 = new Ironclad("ironclad1", this, ShipPlacement.HORIZONTAL, ic1);
        IShip sub1 = new Submarine("sub1", this, ShipPlacement.HORIZONTAL, sub1coordinate);
        this.ships.add(ironClad1);this.ships.add(sub1);
    }

    public Player getPlayer() {
        return player;
    }

    public int getSize() {
        return size;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public List<IShip> getShips() {
        return ships;
    }

    public Coordinate getCoordinateByName(String name){
        return CoordinateFinder.getCoordinateByName(name);
    }

    public void printBoard(){
        for(Coordinate coordinate : coordinates){
            if (coordinate.getShip() != null){
                System.out.println(coordinate.getName()+"->"+coordinate.getShip().getSymbol());
            }
        }
    }
}
