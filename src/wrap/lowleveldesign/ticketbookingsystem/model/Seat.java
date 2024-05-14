package wrap.lowleveldesign.ticketbookingsystem.model;

public class Seat {
    private final String seatNo;
    private final int row;

    public Seat(String seatNo, int row) {
        this.seatNo = seatNo;
        this.row = row;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public int getRow() {
        return row;
    }
}
