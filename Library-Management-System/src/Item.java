// Abstract because a bare "Item" has no real-world meaning in a library —
// only concrete kinds (Book, Magazine, DVD) do. This class holds everything
// that IS common to all of them (id, title, quantity, borrow tracking) so
// that logic isn't duplicated in every subclass.
public abstract class Item implements Borrowable {
    private final String id;
    private final String title;
    private int totalCopies;
    private int borrowedCopies;

    public Item(String id, String title, int totalCopies) {
        this.id = id;
        this.title = title;
        this.totalCopies = totalCopies;
        this.borrowedCopies = 0;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return totalCopies - borrowedCopies;
    }

    @Override
    public boolean isAvailable() {
        return getAvailableCopies() > 0;
    }

    @Override
    public void borrow() throws ItemAlreadyBorrowedException {
        if (!isAvailable()) {
            throw new ItemAlreadyBorrowedException(id);
        }
        borrowedCopies++;
    }

    @Override
    public void returnItem() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
        }
    }

    // Abstract: every subclass MUST decide how it prints its own details.
    // This is what lets Library print a mixed list of Books/Magazines/DVDs
    // by calling the exact same method name on each — polymorphism, not
    // a big if/else chain checking "what type is this item".
    public abstract void displayInfo();
}
