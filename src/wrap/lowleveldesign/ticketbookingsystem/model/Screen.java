package wrap.lowleveldesign.ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String name;
    private List<Show> shows;
    private final List<Seat> seats;

    public Screen(String name) {
        this.name = name;
        this.shows = new ArrayList<>();
        this.seats = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public void addShow(Show show){
        this.shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}
