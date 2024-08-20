
import java.util.Scanner;

public class Menus {
    Scanner scanner = new Scanner(System.in);
    Flights flights = new Flights();

    Passengers passengers = new Passengers(flights);

    Admin admin = new Admin(flights, passengers);


    //entry menu
    public void menu() {
        while (true) {
            int a = 20;
            int b = 20;
            System.out.println();
            showFirstMenu();
            System.out.print(">>");
            a = scanner.nextInt();


            //passenger part
            if (a == 1) {
                while (b != 0) {
                    System.out.println();
                    showEntryPassengerMenu();
                    System.out.print(">>");
                    b = scanner.nextInt();


                    //passenger sign in
                    if (b == 1) {
                        int y;
                        y = passengers.passengerSignIn();
                        while (y == 500 && b != 0) {
                            System.out.println("This Account Doesn't Exist");
                            b = 0;
                        }
                        int s = 20;
                        while (s != 0 && b != 0) {
                            showPassengerMenuOptions();
                            System.out.print(">>");
                            s = scanner.nextInt();


                            //changing password
                            if (s == 1) {
                                passengers.passenger[y].changePassengerPassword();
                            }


                            //searching flight based on desired information
                            else if (s == 2) {
                                Search search = new Search(flights);
                                search.searchFlightTicket();
                            }


                            //booking tickets
                            else if (s == 3) {
                                passengers.passenger[y].bookingTicket();
                            }


                            //cancelling tickets
                            else if (s == 4) {
                                passengers.passenger[y].ticketCancellation();
                            }


                            //showing booked tickets
                            else if (s == 5) {
                                passengers.passenger[y].showBookedTickets();
                            }


                            //adding charge
                            else if (s == 6) {
                                passengers.passenger[y].addCharge();
                            }
                        }
                    }


                    //passenger sign up
                    else if (b == 2) {
                        passengers.passengerSignUp();
                    }
                }
            } else if (a == 2) {

                //admin sign in
                int z = admin.adminSignIn();
                int x = 10;
                while (x != 0 && z != 0) {
                    showAdminMenu();
                    System.out.print(">>");
                    x = scanner.nextInt();


                    //adding flight
                    if (x == 1) {
                        admin.addFlight();
                    }


                    //updating flight
                    else if (x == 2) {
                        admin.updateFlight();
                    }


                    //removing flight
                    else if (x == 3) {
                        admin.removeFlight();
                    }


                    //showing flight
                    else if (x == 4) {
                        admin.showFlightSchedules();
                    }
                }
            }
        }
    }


    //showing entry menu
    public void showFirstMenu() {
        System.out.println("""
                -------------------------------------
                WELCOME TO AIRLINE RESERVATION SYSTEM
                -------------------------------------
                1> Passenger
                2> Admin
                -------------------------------------""");
    }


    //showing passenger entry menu
    public void showEntryPassengerMenu() {
        System.out.println("""
                -------------------------------------
                          Passenger Menu
                -------------------------------------
                1> Sign in
                2> Sign up     
                0> Return to previous menu
                -------------------------------------""");
    }


    //showing admin menu
    public void showAdminMenu() {
        System.out.println("""
                -------------------------------------
                            Admin Menu
                -------------------------------------
                1> Add
                2> Update
                3> Remove
                4> Flight Schedules
                0> Sign out
                -------------------------------------""");
    }


    //show passenger menu
    public void showPassengerMenuOptions() {
        System.out.println("""
                -------------------------------------
                         Passenger Menu
                -------------------------------------
                1> Change Password
                2> Search Flight Ticket
                3> Booking Ticket
                4> Ticket Cancellation
                5> Booked Tickets
                6> Add charge
                0> Sign out
                -------------------------------------""");
    }
}
