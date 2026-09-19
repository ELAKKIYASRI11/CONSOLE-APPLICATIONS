public class Magazine extends Item {
    private final int issueNumber;

    public Magazine(String id, String title, int totalCopies, int issueNumber) {
        super(id, title, totalCopies);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.printf("[Magazine] ID: %-6s Title: %-25s Issue #: %-15d Available: %d%n",
                getId(), getTitle(), issueNumber, getAvailableCopies());
    }
}
