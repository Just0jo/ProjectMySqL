package ie.atu;
import ie.atu.Instrument;

import java.util.ArrayList;

public class Rent {
    private ArrayList<Instrument> rentedInstruments = new ArrayList<>();

    public void rentInstrument(Instrument instrument) {
        rentedInstruments.add(instrument);
    }

    public void returnInstrument(Instrument instrument) {
        rentedInstruments.remove(instrument);
    }

    public ArrayList<Instrument> getRentedInstruments() {
        return rentedInstruments;
    }
}

