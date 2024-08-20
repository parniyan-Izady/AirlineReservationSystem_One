import java.util.Scanner;

public class Menus {
    private Scanner scanner = new Scanner(System.in);
    private Flights flights = new Flights();
    private Passengers passengers = new Passengers(flights);
    private Admin admin = new Admin(flights, passengers);

    // Main menu for the application
    public void menu() {
        while (true) {
            int mainChoice = 20;
            int subChoice = 20;

            System.out.println();
            showFirstMenu();
            System.out.print(">> ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    handlePassengerMenu();
                    break;
                case 2:
                    handleAdminMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle passenger menu interactions
    private void handlePassengerMenu() {
        int subChoice = 20;

        while (subChoice != 0) {
            System.out.println();
            showEntryPassengerMenu();
            System.out.print(">> ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    handlePassengerSignIn();
                    break;
                case 2:
                    passengers.passengerSignUp();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle passenger sign-in and subsequent actions
    private void handlePassengerSignIn() {
        int passengerIndex = passengers.passengerSignIn();

        if (passengerIndex == 500) {
            System.out.println("This account doesn't exist.");
            return;
        }

        int actionChoice = 20;

        while (actionChoice != 0) {
            showPassengerMenuOptions();
            System.out.print(">> ");
            actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    passengers.passenger[passengerIndex].changePassengerPassword();
                    break;
                case 2:
                    Search search = new Search(flights);
                    search.searchFlightTicket();
                    break;
                case 3:
                    passengers.passenger[passengerIndex].bookingTicket();
                    break;
                case 4:
                    passengers.passenger[passengerIndex].ticketCancellation();
                    break;
                case 5:
                    passengers.passenger[passengerIndex].showBookedTickets();
                    break;
                case 6:
                    passengers.passenger[passengerIndex].addCharge();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle admin menu interactions
    private void handleAdminMenu() {
        int adminChoice = admin.adminSignIn();

        if (adminChoice == 0) {
            System.out.println("Invalid admin credentials.");
            return;
        }

        int actionChoice = 10;

        while (actionChoice != 0) {
            showAdminMenu();
            System.out.print(">> ");
            actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    admin.addFlight();
                    break;
                case 2:
                    admin.updateFlight();
                    break;
                case 3:
                    admin.removeFlight();
                    break;
                case 4:
                    admin.showFlightSchedules();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the main menu
    public void showFirstMenu() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║   WELCOME TO THE AIRLINE RESERVATION   ║
                ║               SYSTEM                   ║
                ╠════════════════════════════════════════╣
                ║   1. Passenger Portal                  ║
                ║   2. Admin Dashboard                   ║
                ╚════════════════════════════════════════╝
                """);
    }

    // Display the passenger entry menu
    public void showEntryPassengerMenu() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║              Passenger Menu            ║
                ╠════════════════════════════════════════╣
                ║   1. Sign in to your account           ║
                ║   2. Create a new account (Sign up)    ║
                ║   0. Return to the main menu           ║
                ╚════════════════════════════════════════╝
                """);
    }

    // Display the admin menu
    public void showAdminMenu() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║              Admin Dashboard           ║
                ╠════════════════════════════════════════╣
                ║   1. Add a new flight                  ║
                ║   2. Update existing flight details    ║
                ║   3. Remove a flight                   ║
                ║   4. View all flight schedules         ║
                ║   0. Log out                           ║
                ╚════════════════════════════════════════╝
                """);
    }

    // Display the passenger menu options
    public void showPassengerMenuOptions() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║               Passenger Menu           ║
                ╠════════════════════════════════════════╣
                ║   1. Change your password              ║
                ║   2. Search for available flights      ║
                ║   3. Book a flight ticket              ║
                ║   4. Cancel a booked ticket            ║
                ║   5. View your booked tickets          ║
                ║   6. Add funds to your account         ║
                ║   0. Log out                           ║
                ╚════════════════════════════════════════╝
                """);
    }
}
