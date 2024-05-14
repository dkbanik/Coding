package wrap.lowleveldesign.ticketbookingsystem.model;

import java.util.List;

public class Theatre {
    private final int id;
    private final String name;
    private List<Screen> screens;
    private List<Show> shows;
    private final String city;

    public Theatre(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public void addScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public void addShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getCity() {
        return city;
    }
}
