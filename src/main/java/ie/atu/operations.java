package ie.atu;

import java.util.ArrayList;

public interface operations<instruments> {
    void add(instruments item);
    instruments get(int id);
    ArrayList<instruments> getAll();
    void update(int id, instruments item);
    void delete(int id);
}

