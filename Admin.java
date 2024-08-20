import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    private static final int MAX_FLIGHTS = 100;
    private static final int MAX_PASSENGERS = 500;

    private Scanner scanner = new Scanner(System.in);
    private final String adminUsername = "admin";
    private final String adminPassword = "admin";

    private Flights flights;
    private Passengers passengers;

    public Admin(Flights flights, Passengers passengers) {
        this.flights = flights;
        this.passengers = passengers;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    // Admin sign in
    public boolean adminSignIn() {
        System.out.println("Please enter your username:");
        System.out.print(">> ");
        String testUsername = scanner.next().trim();

        System.out.println("Please enter your password:");
        System.out.print(">> ");
        String testPassword = scanner.next().trim();

        if (testUsername.equals(adminUsername) && testPassword.equals(adminPassword)) {
            return true;
        } else {
            System.out.println("Entered username or password doesn't match!");
            return false;
        }
    }

    // Adding flight
    public void addFlight() {
        for (int i = 0; i < MAX_FLIGHTS; i++) {
            if (flights.getFlight(i) == null) {
                Flight flight = new Flight();

                System.out.println("Enter Flight details:");

                System.out.print("Flight Id: ");
                flight.setFlightId(scanner.next().trim());

                System.out.print("Origin: ");
                flight.setOrigin(scanner.next().trim());

                System.out.print("Destination: ");
                flight.setDestination(scanner.next().trim());

                System.out.print("Date: ");
                flight.setDate(scanner.next().trim());

                System.out.print("Time: ");
                flight.setTime(scanner.next().trim());

                System.out.print("Price: ");
                flight.setPrice(scanner.nextDouble());

                flights.setFlight(i, flight);
                System.out.println("Flight added successfully!");
                break;
            }
        }
    }

    // Updating flight
    public void updateFlight() {
        System.out.print("Enter the Flight Id to update: ");
        String flightId = scanner.next().trim();

        for (int i = 0; i < MAX_FLIGHTS; i++) {
            Flight flight = flights.getFlight(i);
            if (flight != null && flightId.equals(flight.getFlightId())) {
                System.out.println("Updating Flight details:");

                System.out.print("New Flight Id: ");
                flight.setFlightId(scanner.next().trim());

                System.out.print("New Origin: ");
                flight.setOrigin(scanner.next().trim());

                System.out.print("New Destination: ");
                flight.setDestination(scanner.next().trim());

                System.out.print("New Date: ");
                flight.setDate(scanner.next().trim());

                System.out.print("New Time: ");
                flight.setTime(scanner.next().trim());

                System.out.print("New Price: ");
                flight.setPrice(scanner.nextDouble());

                System.out.println("Flight updated successfully!");
                return;
            }
        }
        System.out.println("Flight Id not found!");
    }

    // Removing flight
    public void removeFlight() {
        System.out.print("Enter the Flight Id to remove: ");
        String flightId = scanner.next().trim();

        for (int i = 0; i < MAX_FLIGHTS; i++) {
            Flight flight = flights.getFlight(i);
            if (flight != null && flightId.equals(flight.getFlightId())) {
                // Remove all tickets associated with the flight
                for (int j = 0; j < MAX_PASSENGERS; j++) {
                    if (passengers.getPassenger(j) != null) {
                        Passenger passenger = passengers.getPassenger(j);
                        passenger.removeTicketsForFlight(flightId);
                    }
                }

                flights.setFlight(i, null);
                System.out.println("Flight removed successfully!");
                return;
            }
        }
        System.out.println("Flight Id not found!");
    }

    // Showing flight schedules
    public void showFlightSchedules() {
        System.out.println("| Flight Id | Origin      | Destination | Date       | Seats | Time    | Price    |");
        System.out.println("|-----------|-------------|-------------|------------|-------|---------|----------|");

        for (int i = 0; i < MAX_FLIGHTS; i++) {
            Flight flight = flights.getFlight(i);
            if (flight != null) {
                System.out.printf("| %-9s | %-11s | %-11s | %-10s | %-5d | %-7s | %-8.2f |%n",
                        flight.getFlightId(),
                        flight.getOrigin(),
                        flight.getDestination(),
                        flight.getDate(),
                        flight.getRemainedSeats(),
                        flight.getTime(),
                        flight.getPrice());
            }
        }
    }
}
