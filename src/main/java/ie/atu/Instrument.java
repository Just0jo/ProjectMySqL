package ie.atu;

public  class Instrument {
    private int id;
    private String name;
    private String brand;
    private double price;

    public Instrument(int id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }

    public void playSound() {

    }
}
