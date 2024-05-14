package wrap.lowleveldesign.ticketbookingsystem.model;

public class Movie {
    private String name;
    private int duration;
    public Movie(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }
}
