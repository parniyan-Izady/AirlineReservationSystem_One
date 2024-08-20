import java.util.Scanner;

public class Passenger{
    Scanner scanner = new Scanner(System.in);
    private String passengerUsername;
    private String passengerPassword;
    private double charge;
    Flights flights;

    public Passenger(Flights flights) {
        this.flights = flights;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getPassengersPassword() {
        return passengerPassword;
    }

    public void setPassengersPassword(String passengersPassword) {
        this.passengerPassword = passengersPassword;
    }

    public String getPassengersUsername() {
        return passengerUsername;
    }

    public void setPassengersUsername(String passengersUsername) {
        this.passengerUsername = passengersUsername;
    }


    //change passenger password
    public void changePassengerPassword() {
        System.out.println("Please enter the new password");
        System.out.print(">>");
        passengerPassword = scanner.next().toLowerCase().trim();
    }


    //booking ticket
    public void bookingTicket () {
        System.out.println("Please enter desired flight id ");
        System.out.print(">>");
        String flightId = scanner.next().toLowerCase().trim();
        for (int i = 0; i < 100; i++) {
            if (!(flights.flight[i] == null) && flightId.equals(flights.flight[i].getFlightId())) {
                addBookedFlight(i);
                break;
            } else if (i == 99)
                System.out.println("Sorry! We couldn't Find Any flights !");
        }
    }


    //adding booked flight
    public void addBookedFlight(int i) {
        if (charge >= flights.flight[i].getPrice())
        {
            for (int z = 0; z < 100; z++) {
                if (flights.flight[i].tickets.ticket[z] == null) {
                    charge = charge - flights.flight[i].getPrice();
                    flights.flight[i].tickets.ticket[z] = new Ticket();
                    flights.flight[i].tickets.ticket[z].setFlightId(flights.flight[i].getFlightId());
                    flights.flight[i].tickets.ticket[z].setOrigin(flights.flight[i].getOrigin());
                    flights.flight[i].tickets.ticket[z].setDestination(flights.flight[i].getDestination());
                    flights.flight[i].tickets.ticket[z].setDate(flights.flight[i].getDate());
                    flights.flight[i].tickets.ticket[z].setTime(flights.flight[i].getTime());
                    flights.flight[i].tickets.ticket[z].setPrice(flights.flight[i].getPrice());
                    flights.flight[i].tickets.ticket[z].setUsername(passengerUsername);
                    flights.flight[i].tickets.ticket[z].setSeatNumber(z);
                    flights.flight[i].tickets.ticket[z].setTicketId();
                    flights.flight[i].decreaseRemainedSeats();
                    System.out.println("Your Ticket Has Been Reserved! ");
                    break;
                }
            }
        }
        else {
            System.out.println("Your Charge Is Not Enough");
        }
    }


    //cancelling ticket
    public void ticketCancellation () {
        System.out.println("Please Enter your Flight ID");
        System.out.print(">>");
        String flightId = scanner.next().toLowerCase().trim();
        int i;
        for (i = 0; i < 100; i++) {
            if (!(flights.flight[i] == null) && flightId.equals(flights.flight[i].getFlightId())) {
                removeBookedFlight(i, flights.flight[i].getPrice());
                break;
            }
        }
        if(i == 100)
            System.out.println("Sorry ! This Flight Id doesn't exist");
    }


    //removing booked flight
    public void removeBookedFlight ( int i, double flightPrice){
        System.out.println("Please Enter your Ticket ID");
        System.out.print(">>");
        String ticketId = scanner.next().toLowerCase().trim();
        int z;
        for (z = 0; z < 100; z++) {
            if (!(flights.flight[i].tickets.ticket[z] == null) && (flights.flight[i].tickets.ticket[z].getTicketId().equals(ticketId))) {
                flights.flight[i].tickets.ticket[z] = null;
                flights.flight[i].increaseRemainedSeats();
                charge = charge + flightPrice;
                System.out.println("Your ticket Has been canceled! " );
                System.out.println("Your charge is " + charge + "!");
                break;
            }
        }
        if(z == 100 )
            System.out.println("Sorry ! This Flight Id doesn't exist");
    }


    //adding charge
    public void addCharge () {
        System.out.println("Please enter the desired amount ");
        System.out.print(">>");
        double addedCharge = scanner.nextDouble();
        charge = charge + addedCharge;
        System.out.println("Your charge is " + charge + "!");
    }


    //show booked tickets
    public void showBookedTickets () {
        for (int i = 0; i < 100; i++) {
            for (int z = 0; z < 100; z++) {
                if (!(flights.flight[i] == null) && !(flights.flight[i].tickets.ticket[z] == null) && flights.flight[i].tickets.ticket[z].getUsername().equals(passengerUsername)) {
                    System.out.println("Flight Id   |Ticket Id   |Username      |Origin      |Destination |Date        |Seat Number|Time    |Price  ");
                    System.out.print(flights.flight[i].getFlightId());
                    for (int p = 0; p < 12 - flights.flight[i].getFlightId().length(); p++)
                        System.out.print(" ");
                    System.out.print("|");
                    System.out.print(flights.flight[i].tickets.ticket[z].getTicketId());
                    for (int p = 0; p < 12 - flights.flight[i].tickets.ticket[z].getTicketId().length(); p++)
                        System.out.print(" ");
                    System.out.print("|");
                    System.out.print(passengerUsername);
                    for (int p = 0; p < 14 - passengerUsername.length(); p++)
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
                    System.out.print(flights.flight[i].tickets.ticket[z].getSeatNumber() + "        ");
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
}