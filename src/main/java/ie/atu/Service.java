package ie.atu;
import ie.atu.Instrument;
import java.util.ArrayList;

public class Service implements operations<Instrument> {
    private ArrayList<Instrument> instruments = new ArrayList<>();

    @Override
    public void add(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public Instrument get(int id) {
        return instruments.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public ArrayList<Instrument> getAll() {
        return instruments;
    }

    @Override
    public void update(int id, Instrument newInstrument) {
        Instrument instrument = get(id);
        if (instrument != null) {
            instruments.set(instruments.indexOf(instrument), newInstrument);
        }
    }

    @Override
    public void delete(int id) {
        instruments.removeIf(instrument -> instrument.getId() == id);
    }
}
