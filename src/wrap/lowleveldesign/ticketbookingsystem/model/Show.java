package wrap.lowleveldesign.ticketbookingsystem.model;

public class Show {
    private final String name;
    private final Movie movie;
    private Long startTimestamp;
    private Long endTimestamp;

    public Show(String name, Movie movie, Long startTimestamp, Long endTimestamp) {
        this.name = name;
        this.movie = movie;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public String getName() {
        return name;
    }

    public Movie getMovie() {
        return movie;
    }
}
