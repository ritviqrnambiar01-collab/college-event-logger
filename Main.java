import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager();
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("   COLLEGE EVENT ENTRY & LOGGER SYSTEM   ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n1. Register New Student");
            System.out.println("2. Check-In Student at Door");
            System.out.println("3. View All Registrations");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter Student USN: ");
                    String usn = scanner.nextLine().trim();
                    System.out.print("Enter Event Name (e.g., Coding Hackathon): ");
                    String event = scanner.nextLine().trim();
                    manager.registerParticipant(name, usn, event);
                    break;

                case "2":
                    System.out.print("Enter USN to Check-In: ");
                    String checkInUsn = scanner.nextLine().trim();
                    manager.checkInParticipant(checkInUsn);
                    break;

                case "3":
                    manager.displayAll();
                    break;

                case "4":
                    System.out.println("Exiting system. Have a great event!");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }
}