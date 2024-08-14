package ie.atu;

import java.util.ArrayList;

public interface operations<X> {
    void add(X item);
    X get(int id);
    ArrayList<X> getAll();
    void update(int id, X item);
    void delete(int id);
    //FOR NOW X IS JUST A HOLDER FOR ONE OF THE CALLS I WANT TO PERFORM AN OPERATION ON
}

