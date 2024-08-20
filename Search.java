import java.util.Scanner;

public class Search {
    Scanner scanner = new Scanner(System.in);
    Flights newFlights = new Flights();
    Flights flights;

    public Search(Flights flights) {
        this.flights = flights;
        cloning();
    }


    //copying information
    public void cloning(){
        for (int i = 0; i < 100 ; i++) {
            if( flights.flight[i] != null )
            {
                newFlights.flight[i] = new Flight();
                newFlights.flight[i].setFlightId(flights.flight[i].getFlightId());
                newFlights.flight[i].setOrigin(flights.flight[i].getOrigin());
                newFlights.flight[i].setDestination(flights.flight[i].getDestination());
                newFlights.flight[i].setDate(flights.flight[i].getDate());
                newFlights.flight[i].setTime(flights.flight[i].getTime());
                newFlights.flight[i].setPrice(flights.flight[i].getPrice());
            }
        }
    }


    //search flight based on desired information
    public void searchFlightTicket() {
        System.out.println("Enter 0 if you don not need this option!");
        System.out.println();


        System.out.println("Desired origin?");
        System.out.print(">>");
        String testOrigin = scanner.next();
        if (!(testOrigin.equals("0"))) {
            for (int i = 0; i < 100; i++) {
                if (!(newFlights.flight[i] == null) && !(newFlights.flight[i].getOrigin().equals(testOrigin))) {
                    newFlights.flight[i] = null ;
                }
            }
        }
        System.out.println("Desired destination?");
        System.out.print(">>");
        String testDestination = scanner.next();
        if (!(testDestination.equals("0"))) {
            for (int i = 0; i < 100; i++) {
                if (!(newFlights.flight[i] == null) && !(newFlights.flight[i].getDestination().equals(testDestination))) {
                    newFlights.flight[i] = null ;
                }
            }
        }
        System.out.println("Desired Date?");
        System.out.print(">>");
        String testDate = scanner.next();
        if (!(testDate.equals("0"))) {
            for (int i = 0; i < 100; i++) {
                if (!(newFlights.flight[i] == null) && !(newFlights.flight[i].getDate().equals(testDate))) {
                    newFlights.flight[i] = null ;
                }
            }
        }
        System.out.println("Desired Time?");
        System.out.print(">>");
        String testTime = scanner.next();
        if (!(testTime.equals("0"))) {
            for (int i = 0; i < 100; i++) {
                if (!(newFlights.flight[i] == null) && !(newFlights.flight[i].getTime().equals(testTime))) {
                    newFlights.flight[i] = null ;
                }
            }
        }
        System.out.println("Desired Price?");
        System.out.print(">>");
        double testPrice = scanner.nextDouble();
        if (!(testPrice == 0 )) {
            for (int i = 0; i < 100; i++) {
                if (!(newFlights.flight[i] == null) && !(newFlights.flight[i].getPrice() <= testPrice)) {
                    newFlights.flight[i] = null ;
                }
            }
        }
        int p = 0 ;
        for (int i = 0; i < 100; i++) {
            if (!(newFlights.flight[i] == null)) {
                System.out.println("Flight Id   |Origin      |Destination |Date        |Time    |seat |Price  ");
                showSearchedTicket(i);
                p = 4;
            }
        }
        if( p == 0)
        {System.out.println("Sorry! We couldn't Find Any flights !");}
    }


    //showing searched ticket
    public void showSearchedTicket(int i){
        System.out.print(newFlights.flight[i].getFlightId());
        for (int p = 0; p < 12 - newFlights.flight[i].getFlightId().length(); p++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(newFlights.flight[i].getOrigin());
        for (int p = 0; p < 12 - newFlights.flight[i].getOrigin().length(); p++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(newFlights.flight[i].getDestination());
        for (int p = 0; p < 12 - newFlights.flight[i].getDestination().length(); p++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(newFlights.flight[i].getDate());
        for (int p = 0; p < 12 - newFlights.flight[i].getDate().length(); p++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(newFlights.flight[i].getTime());
        for (int p = 0; p < 8 - newFlights.flight[i].getTime().length(); p++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(newFlights.flight[i].getRemainedSeats() + "  ");
        if(newFlights.flight[i].getRemainedSeats() < 100)
            System.out.print(" ");
        System.out.print("|");
        System.out.println(newFlights.flight[i].getPrice());
    }
}
