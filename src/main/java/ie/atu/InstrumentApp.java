package ie.atu;
import ie.atu.String_Instrument;
import ie.atu.Percussion_Instrument;
import ie.atu.Wind_Instrument;
import ie.atu.Service;
import ie.atu.Rent;

import java.util.Scanner;


public class InstrumentApp {
public static void main(String[] args) {
    Service instrumentService = new Service();
    Rent rentalService = new Rent();

    // Sample instruments
    String_Instrument guitar = new String_Instrument(1, "Guitar", "Fender", 499.99, 6);
    Percussion_Instrument drum = new Percussion_Instrument(2, "Drum", "Yamaha", 299.99, "Acoustic");
    Wind_Instrument  flute = new Wind_Instrument (3, "Flute", "Yamaha", 199.99, "Concert");
    // Add instruments
    instrumentService.add(guitar);
    instrumentService.add(drum);
    instrumentService.add(flute);

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("1. View Instruments");
        System.out.println("2. Rent Instrument");
        System.out.println("3. Return Instrument");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (Instrument instrument : instrumentService.getAll()) {
                    System.out.println(instrument.getId() + ": " + instrument.getName() + " - " + instrument.getBrand());
                }
                break;
            case 2:
                System.out.print("Enter the instrument ID to rent: ");
                int rentId = scanner.nextInt();
                Instrument instrumentToRent = instrumentService.get(rentId);
                if (instrumentToRent != null) {
                    rentalService.rentInstrument(instrumentToRent);
                    System.out.println(instrumentToRent.getName() + " has been rented.");
                } else {
                    System.out.println("Instrument not found.");
                }
                break;
            case 3:
                System.out.print("Enter the instrument ID to return: ");
                int returnId = scanner.nextInt();
                Instrument instrumentToReturn = instrumentService.get(returnId);
                if (instrumentToReturn != null) {
                    rentalService.returnInstrument(instrumentToReturn);
                    System.out.println(instrumentToReturn.getName() + " has been returned.");
                } else {
                    System.out.println("Instrument not found.");
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
}
