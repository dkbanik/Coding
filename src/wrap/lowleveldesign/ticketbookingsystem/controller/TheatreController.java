package wrap.lowleveldesign.ticketbookingsystem.controller;

import wrap.lowleveldesign.ticketbookingsystem.model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    private Map<String, List<Theatre>> theatreByCity;
    private List<Theatre> allTheatres;
    public TheatreController() {
        this.theatreByCity = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }



}
