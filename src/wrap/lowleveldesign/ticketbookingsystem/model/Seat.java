package wrap.lowleveldesign.ticketbookingsystem.model;

public class Seat {
    private final int id;
    private final String seatNo;
    private final int row;

    public Seat(int id, String seatNo, int row) {
        this.id = id;
        this.seatNo = seatNo;
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return seatNo;
    }

    public int getRow() {
        return row;
    }
}
