import java.util.Scanner;

public class Passengers {
    Scanner scanner = new Scanner(System.in);
    Passenger[] passenger = new Passenger[500];
    Flights flights;

    public Passengers(Flights flights) {
        this.flights = flights;
    }


    //passenger sign up
    public void passengerSignUp() {
        for (int i = 0; i < 500; i++) {
            if (passenger[i] == null) {
                passenger[i] = new Passenger(flights);
                System.out.println("Create Your Username");
                System.out.print(">>");
                passenger[i].setPassengersUsername(scanner.next());
                System.out.println("Create Your Password");
                System.out.print(">>");
                passenger[i].setPassengersPassword(scanner.next());
                break;
            }
        }
    }


    //passenger sign in
    public int passengerSignIn() {
        System.out.println("Please Enter Your Username");
        System.out.print(">>");
        String testUsername = scanner.next();
        System.out.println("Please Enter Your Password");
        System.out.print(">>");
        String testPassword = scanner.next();
        int y;
        for (y = 0; y < 500; y++) {
            if (!(passenger[y] == null) && passenger[y].getPassengersUsername().equals(testUsername) && passenger[y].getPassengersPassword().equals(testPassword))
                break;
        }
        return y;
    }
}
