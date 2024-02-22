package wrap.lowleveldesign.ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final int id;
    private final Show show;
    private final Movie movie;
    private final List<Seat> seatsBooked;
    private Status status;

    public Booking(int id, Show show, Movie movie) {
        this.id = id;
        this.show = show;
        this.movie = movie;
        this.seatsBooked = new ArrayList<>();
        this.status = Status.CREATED;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Movie getMovie() {
        return movie;
    }

    public Status getStatus() {
        return status;
    }
}
