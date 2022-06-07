package lowleveldesign.ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final int id;
    private final String name;
    private final Movie movie;
    private final Screen screen;
    private final int duration;

    public Show(int id, String name, Movie movie, Screen screen, int duration) {
        this.id = id;
        this.name = name;
        this.movie = movie;
        this.screen = screen;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }
}
