import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        system.initializeData(); // Initialize with some dummy data

        while (true) {
            System.out.println("Online Reservation System");
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (system.login(userId, password)) {
                System.out.println("Login successful!");
                boolean exit = false;

                while (!exit) {
                    System.out.println("\nMenu:");
                    System.out.println("1. Make a Reservation");
                    System.out.println("2. Cancel a Reservation");
                    System.out.println("3. Logout");
                    System.out.print("Choose an option: ");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            system.makeReservation();
                            break;
                        case 2:
                            system.cancelReservation();
                            break;
                        case 3:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid User ID or Password. Please try again.");
            }
        }
    }
}
