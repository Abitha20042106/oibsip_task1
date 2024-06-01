import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private Map<String, User> users;
    private Map<String, Train> trains;
    private Map<String, Reservation> reservations;
    private Scanner scanner;

    public ReservationSystem() {
        users = new HashMap<>();
        trains = new HashMap<>();
        reservations = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void initializeData() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));

        trains.put("12345", new Train("12345", "Express Train"));
        trains.put("54321", new Train("54321", "Super Fast Train"));
    }

    public boolean login(String userId, String password) {
        User user = users.get(userId);
        return user != null && user.getPassword().equals(password);
    }

    public void makeReservation() {
        System.out.print("Enter Train Number: ");
        String trainNumber = scanner.nextLine();

        Train train = trains.get(trainNumber);
        if (train == null) {
            System.out.println("Invalid Train Number.");
            return;
        }

        System.out.print("Enter Class Type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        String pnr = generatePNR();
        Reservation reservation = new Reservation(pnr, "user1", trainNumber, classType, dateOfJourney, destination);
        reservations.put(pnr, reservation);

        System.out.println("Reservation successful! Your PNR is " + pnr);
    }

    public void cancelReservation() {
        System.out.print("Enter PNR Number: ");
        String pnr = scanner.nextLine();

        Reservation reservation = reservations.get(pnr);
        if (reservation == null) {
            System.out.println("Invalid PNR Number.");
            return;
        }

        System.out.println("Reservation Details: " + reservation);
        System.out.print("Confirm cancellation? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            reservations.remove(pnr);
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }

    private String generatePNR() {
        return "PNR" + (reservations.size() + 1);
    }
}
