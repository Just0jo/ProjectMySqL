package ie.atu;

import java.util.ArrayList;

public interface operations<instruments> {
    void add(instruments item);
    instruments get(int id);
    ArrayList<instruments> getAll();
    void update(int id, instruments item);
    void delete(int id);
    //FOR NOW X IS JUST A HOLDER FOR ONE OF THE CALLS I WANT TO PERFORM AN OPERATION ON
}

