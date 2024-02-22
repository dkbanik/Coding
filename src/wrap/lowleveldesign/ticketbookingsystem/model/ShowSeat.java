package wrap.lowleveldesign.ticketbookingsystem.model;

public class ShowSeat {
    private final int id;
    private final int show_id;
    private final int seat_id;
    private Status status;
    private String showSeatType;
    private int price;

    public ShowSeat(int id, int show_id, int seat_id) {
        this.id = id;
        this.show_id = show_id;
        this.seat_id = seat_id;
        this.status = Status.AVAILABLE;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getShow_id() {
        return show_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public Status getStatus() {
        return status;
    }

    public String getShowSeatType() {
        return showSeatType;
    }

    public int getPrice() {
        return price;
    }
}
