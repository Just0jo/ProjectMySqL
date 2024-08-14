package ie.atu;

public class Wind_Instrument extends Instrument {
    private String type; // e.g., "Flute", "Clarinet", "Saxophone"

    public Wind_Instrument(int id, String name, String brand, double price, String type) {
        super(id, name, brand, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void playSound() {
        System.out.println("Playing sound of a " + getType() + " " + getName() + ".");
    }
}


