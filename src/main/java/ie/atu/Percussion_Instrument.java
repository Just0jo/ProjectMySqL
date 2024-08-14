package ie.atu;
public class  Percussion_Instrument  extends Instrument {
    private String drumType;

    public  Percussion_Instrument (int id, String name, String brand, double price, String drumType) {
        super(id, name, brand, price);
        this.drumType = drumType;
    }

    public String getDrumType() { return drumType; }

    @Override
    public void playSound() {
        System.out.println("Playing sound of a " + drumType + " " + getName() + ".");
    }
}


