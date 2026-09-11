public class Book extends Item {
    private final String author;

    public Book(String id, String title, int totalCopies, String author) {
        super(id, title, totalCopies);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.printf("[Book]     ID: %-6s Title: %-25s Author: %-15s Available: %d%n",
                getId(), getTitle(), author, getAvailableCopies());
    }
}
