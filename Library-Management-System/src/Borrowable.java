// A behavior contract, not a "thing". Any class that can be lent out
// implements this — it does NOT go on Item itself, because not every
// library item should necessarily be borrowable (e.g. a future
// "ReferenceOnlyEncyclopedia" class could deliberately skip this).
public interface Borrowable {
    void borrow() throws ItemAlreadyBorrowedException;
    void returnItem();
    boolean isAvailable();
}
