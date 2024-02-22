package wrap.lowleveldesign.battleship.model;

import java.util.UUID;

public class Coordinate {

    private Board board;
    private String name;
    private UUID id;
    private int x;
    private int y;
    private IShip ship;
    private CoordinateStatus status;

    public Coordinate(int x, int y, Board board) {
        this.id = UUID.randomUUID();
        this.x = x;
        this.y = y;
        this.board = board;
        this.status = CoordinateStatus.AVAILABLE;
        this.name = x+""+y;
    }

    public void setShip(IShip ship) {
        this.ship = ship;
    }

    public void setStatus(CoordinateStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public IShip getShip() {
        return ship;
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public CoordinateStatus getStatus() {
        return status;
    }
}
