public class Participant {
    private String name;
    private String usn;
    private String eventName;
    private boolean isCheckedIn;

    public Participant(String name, String usn, String eventName) {
        this.name = name;
        this.usn = usn.toUpperCase();
        this.eventName = eventName;
        this.isCheckedIn = false;
    }

    public String getName() { return name; }
    public String getUsn() { return usn; }
    public String getEventName() { return eventName; }
    public boolean isCheckedIn() { return isCheckedIn; }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    // Converts object data into a clean CSV row for file saving
    public String toCsvRow() {
        return usn + "," + name + "," + eventName + "," + (isCheckedIn ? "YES" : "NO");
    }

    @Override
    public String toString() {
        String status = isCheckedIn ? "[CHECKED-IN]" : "[PENDING]";
        return String.format("USN: %-12s | Name: %-18s | Event: %-15s | Status: %s", 
                             usn, name, eventName, status);
    }
}