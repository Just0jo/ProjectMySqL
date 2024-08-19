package ie.atu;

import java.sql.*;
import java.util.Scanner;

public class InstrumentUser {
    private  String INSERT_SQL = "INSERT INTO instruments (name, brand, price) VALUES (?, ?, ?)";
    private  String SELECT_SQL = "SELECT * FROM instruments WHERE id = ?";
    private  String SELECT_ALL_SQL = "SELECT * FROM instruments";
    private  String UPDATE_SQL = "UPDATE instruments SET name = ?, brand = ?, price = ? WHERE id = ?";
    private  String DELETE_SQL = "DELETE FROM instruments WHERE id = ?";

    private static final String SELECT_RENT_BY_INSTRUMENT_SQL = "SELECT * FROM rents WHERE Instruments_id = ?";
    private static final String SELECT_ALL_RENTS_SQL = "SELECT * FROM rents";

    private Connection connection;

    public InstrumentUser() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addInstrument(Instrument instrument) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, instrument.getName());
            statement.setString(2, instrument.getBrand());
            statement.setDouble(3, instrument.getPrice());
            statement.executeUpdate();
            System.out.println("Instrument added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Instrument getInstrument(int id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Instrument(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getAllInstruments() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", Name: " + resultSet.getString("name")
                        + ", Brand: " + resultSet.getString("brand")
                        + ", Price: " + resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInstrument(Instrument instrument) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, instrument.getName());
            statement.setString(2, instrument.getBrand());
            statement.setDouble(3, instrument.getPrice());
            statement.setInt(4, instrument.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Instrument updated successfully.");
            } else {
                System.out.println("Instrument not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInstrument(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Instrument deleted successfully.");
            } else {
                System.out.println("Instrument not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getRentalsByInstrument(int Instruments_id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_RENT_BY_INSTRUMENT_SQL)) {
            statement.setInt(1, Instruments_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("Rental ID: " + resultSet.getInt("id")
                            + ", Rental Date: " + resultSet.getString("RENT_date")
                            + ", Return Date: " + resultSet.getString("RETURN_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllRentals() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_RENTS_SQL)) {

            while (resultSet.next()) {
                System.out.println("Rental ID: " + resultSet.getInt("id")
                        + ", Instrument ID: " + resultSet.getInt("Instruments_id")
                        + ", Rental Date: " + resultSet.getString("RENT_date")
                        + ", Return Date: " + resultSet.getString("RETURN_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void user() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation: ");
            System.out.println("1. Add Instrument");
            System.out.println("2. Get Instrument");
            System.out.println("3. Get All Instruments");
            System.out.println("4. Update Instrument");
            System.out.println("5. Delete Instrument");
            System.out.println("6. Rent Date");
            System.out.println("7. Return Date");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    addInstrument(new Instrument(0, name, brand, price));
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Instrument instrument = getInstrument(id);
                    if (instrument != null) {
                        System.out.println("ID: " + instrument.getId()
                                + ", Name: " + instrument.getName()
                                + ", Brand: " + instrument.getBrand()
                                + ", Price: " + instrument.getPrice());
                    } else {
                        System.out.println("Instrument not found.");
                    }
                    break;
                case 3:
                    getAllInstruments();
                    break;
                case 4:
                    System.out.println("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new brand: ");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    updateInstrument(new Instrument(updateId, newName, newBrand, newPrice));
                    break;
                case 5:
                    System.out.println("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    deleteInstrument(deleteId);
                    break;
                case 6:
                    System.out.println("Enter Instrument ID: ");
                    int Instrument_id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    getRentalsByInstrument(Instrument_id);
                    break;
                case 7:
                    getAllRentals();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        InstrumentUser manager = new InstrumentUser();
        manager.user();
    }
}
