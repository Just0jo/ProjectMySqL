package ie.atu;

public  class Instrument {
    private int id;
    private String type;
    private String name;
    private String brand;
    private double price;

    public Instrument(int id, String name, String type, String brand, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.price = price;

    }

    public int getId()
    {
        return id; }
    public String getName()
    {
        return name; }
    public String getBrand()
    {
        return brand; }
    public double getPrice()
    {
        return price; }
    public String getType()
    {
        return type; }

    }

