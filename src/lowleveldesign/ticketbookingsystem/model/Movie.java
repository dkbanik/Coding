package lowleveldesign.ticketbookingsystem.model;

public class Movie {
    int id;
    String name;

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
