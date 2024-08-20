
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    private final String adminUsername = "admin";
    private final String adminPassword = "admin";

    Flights flights;
    Passengers passengers;

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


    //admin sign in
    public int adminSignIn() {
        int z = 1;
        System.out.println("Please enter your username ");
        System.out.print(">>");
        String testUsername = scanner.next().toLowerCase().trim();
        System.out.println("Please enter your password ");
        System.out.print(">>");
        String testPassword = scanner.next().toLowerCase().trim();
        if (!(testUsername.equals(getAdminUsername()) && testPassword.equals(getAdminPassword()))) {
            System.out.println("Entered username or password doesn't match!");
            z = 0;
        }
        return z;
    }


    //adding flight
    public void addFlight() {
        for (int i = 0; i < 100; i++) {
            if (flights.flight[i] == null) {
                flights.flight[i] = new Flight();
                System.out.println("Flight Id?");
                System.out.print(">>");
                flights.flight[i].setFlightId(scanner.next().toLowerCase().trim());

                System.out.println("Origin?");
                System.out.print(">>");
                flights.flight[i].setOrigin(scanner.next().toLowerCase().trim());

                System.out.println("Destination?");
                System.out.print(">>");
                flights.flight[i].setDestination(scanner.next().toLowerCase().trim());

                System.out.println("Date?");
                System.out.print(">>");
                flights.flight[i].setDate(scanner.next().toLowerCase().trim());

                System.out.println("Time?");
                System.out.print(">>");
                flights.flight[i].setTime(scanner.next().toLowerCase().trim());

                System.out.println("Price?");
                System.out.print(">>");
                flights.flight[i].setPrice(scanner.nextDouble());
                break;
            }
        }
    }


    //updating flight
    public void updateFlight() {
        System.out.println("Please Enter the Flight Id?");
        System.out.print(">>");
        String flightId = scanner.next().toLowerCase().trim();
        for (int i = 0; i < 100; i++) {
            if (!(flights.flight[i] == null) && flightId.equals(flights.flight[i].getFlightId())) {
                System.out.println("Flight Id?");
                System.out.print(">>");
                flights.flight[i].setFlightId(scanner.next().toLowerCase().trim());

                System.out.println("Origin?");
                System.out.print(">>");
                flights.flight[i].setOrigin(scanner.next().toLowerCase().trim());

                System.out.println("Destination?");
                System.out.print(">>");
                flights.flight[i].setDestination(scanner.next().toLowerCase().trim());

                System.out.println("Date?");
                System.out.print(">>");
                flights.flight[i].setDate(scanner.next().toLowerCase().trim());

                System.out.println("Time?");
                System.out.print(">>");
                flights.flight[i].setTime(scanner.next().toLowerCase().trim());

                System.out.println("Price?");
                System.out.print(">>");
                flights.flight[i].setPrice(scanner.nextDouble());
                break;
            }
        }
    }


    //removing flight
    public void removeFlight() {
        System.out.println("Please Enter the Flight Id?");
        System.out.print(">>");
        String flightId;
        flightId = scanner.next();
        int i;
        for (i = 0; i < 100; i++) {
            if (!(flights.flight[i] == null) && flightId.equals(flights.flight[i].getFlightId())) {
                for (int j = 0; j < 100; j++) {
                    if (!(flights.flight[i].tickets.ticket[j] == null) && (flights.flight[i].tickets.ticket[j].getFlightId().equals(flightId))) {
                        flights.flight[i].tickets.ticket[j] = null;
                        for (int k = 0; k < 500; k++) {
                            if (flights.flight[i].tickets.ticket[j] != null && flights.flight[i].tickets.ticket[j].getUsername().equals(passengers.passenger[k].getPassengersUsername()))
                                passengers.passenger[k].setCharge(flights.flight[i].getPrice() + passengers.passenger[k].getCharge());
                        }
                    }
                }
                flights.flight[i] = null;
                System.out.println("Flight Has Been Removed!");
                break;
            }
        }
        if (i == 100)
            System.out.println("This flight id doesn't exist!");
    }


    //show flight schedules
    public void showFlightSchedules() {

        for (int i = 0; i < 100; i++) {
            if (!(flights.flight[i] == null)) {
                System.out.println("|Flight Id   |Origin      |Destination |Date        |Seats  |Time    |Price     ");
                System.out.print("|");
                System.out.print(flights.flight[i].getFlightId());
                for (int p = 0; p < 12 - flights.flight[i].getFlightId().length(); p++)
                    System.out.print(" ");
                System.out.print("|");
                System.out.print(flights.flight[i].getOrigin());
                for (int p = 0; p < 12 - flights.flight[i].getOrigin().length(); p++)
                    System.out.print(" ");
                System.out.print("|");
                System.out.print(flights.flight[i].getDestination());
                for (int p = 0; p < 12 - flights.flight[i].getDestination().length(); p++)
                    System.out.print(" ");
                System.out.print("|");
                System.out.print(flights.flight[i].getDate());
                for (int p = 0; p < 12 - flights.flight[i].getDate().length(); p++)
                    System.out.print(" ");
                System.out.print("|");
                System.out.print(flights.flight[i].getRemainedSeats() + "    ");
                System.out.print("|");
                System.out.print(flights.flight[i].getTime());
                for (int p = 0; p < 8 - flights.flight[i].getTime().length(); p++)
                    System.out.print(" ");
                System.out.print("|");
                System.out.print(flights.flight[i].getPrice());
                System.out.println();
            }
        }
    }
}





