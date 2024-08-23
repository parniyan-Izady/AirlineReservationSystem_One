import java.util.Scanner;

public class Passengers {
    Scanner scanner;
    Passenger[] passenger = new Passenger[500];
    Flights flights;
    int numOfPassengers = 0;

    public Passengers(Scanner scanner, Flights flights) {
        this.scanner = scanner;
        this.flights = flights;
    }


    //passenger sign up
    public void passengerSignUp() {
        boolean finishFlag = false;
        passenger[numOfPassengers] = new Passenger(scanner, flights);
        String testUsername = "";
        String testPassword = "";
        while(!finishFlag){
            System.out.println("Create Your Username");
            System.out.print(">>");
            testUsername = scanner.next();
            System.out.println("Create Your Password");
            System.out.print(">>");
            testPassword = scanner.next();
            if (!doesUserExist(testUsername)){
                finishFlag = true;
            }
            else{
                System.out.println("Sorry, this username already exists. Please choose a different username.");
            }
        }
        passenger[numOfPassengers].setPassengersUsername(testUsername);
        passenger[numOfPassengers].setPassengersPassword(testPassword);
        numOfPassengers++;
        passengerSignIn(testUsername, testPassword);
    }

    //passenger sign in
    public int passengerSignIn(String username, String password) {
        return findPassenger(username, password);
    }

    public boolean doesUserExist(String username) {
        if (numOfPassengers == 0) return false;
        for (int pass = 0; pass < numOfPassengers; pass++) {
            if ((passenger[pass] != null) && passenger[pass].getPassengersUsername().equals(username))
                return true;
        }
        return false;
    }
    private int findPassenger(String username, String password){
        if (numOfPassengers == 0) return -1;
        int pass;
        for (pass = 0; pass < numOfPassengers; pass++) {
            if (passenger[pass].getPassengersUsername().equals(username) && passenger[pass].getPassengersPassword().equals(password))
                break;
        }
        if (pass == numOfPassengers + 1)
            return -1;
        return pass;
    }
}
