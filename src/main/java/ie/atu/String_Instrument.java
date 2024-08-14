
package ie.atu;

public class String_Instrument extends Instrument {
    private int numberOfStrings;

    public String_Instrument(int id, String name, String brand, double price, int numberOfStrings) {
        super(id, name, brand, price);
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() { return numberOfStrings; }

    @Override
    public void playSound() {
        System.out.println("Playing sound of a " + getName() + " with " + numberOfStrings + " strings.");
    }
}
