public class DVD extends Item {
    private final int durationMinutes;

    public DVD(String id, String title, int totalCopies, int durationMinutes) {
        super(id, title, totalCopies);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void displayInfo() {
        System.out.printf("[DVD]      ID: %-6s Title: %-25s Duration: %-12s Available: %d%n",
                getId(), getTitle(), durationMinutes + " min", getAvailableCopies());
    }
}
