import java.io.*;
import java.util.*;

public class EventManager {
    private List<Participant> participants = new ArrayList<>();
    private final String FILE_NAME = "event_registrations.csv";

    // Add a new registration
    public void registerParticipant(String name, String usn, String eventName) {
        for (Participant p : participants) {
            if (p.getUsn().equalsIgnoreCase(usn)) {
                System.out.println("❌ Error: USN " + usn + " is already registered!");
                return;
            }
        }
        Participant p = new Participant(name, usn, eventName);
        participants.add(p);
        saveToFile();
        System.out.println("✅ Registration successful for " + name + "!");
    }

    // Check-in participant at the event door
    public void checkInParticipant(String usn) {
        for (Participant p : participants) {
            if (p.getUsn().equalsIgnoreCase(usn)) {
                if (p.isCheckedIn()) {
                    System.out.println("⚠️ Notice: " + p.getName() + " is ALREADY checked in.");
                } else {
                    p.setCheckedIn(true);
                    saveToFile();
                    System.out.println("🎉 Check-in successful! Welcome, " + p.getName() + "!");
                }
                return;
            }
        }
        System.out.println("❌ No registration found for USN: " + usn);
    }

    // Display all participants
    public void displayAll() {
        if (participants.isEmpty()) {
            System.out.println("ℹ️ No participants registered yet.");
            return;
        }
        System.out.println("\n--- Event Participant List ---");
        for (Participant p : participants) {
            System.out.println(p);
        }
    }

    // Save records to a CSV file so data isn't lost on exit
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Participant p : participants) {
                writer.println(p.toCsvRow());
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error saving data to file: " + e.getMessage());
        }
    }
}