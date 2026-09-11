// Thrown when someone tries to borrow an item that has zero copies available.
// Kept separate from ItemNotFoundException because the FIX is completely
// different: here the item exists, it's just unavailable right now (so the
// caller's logical next step is "add to waitlist", not "check the ID").
public class ItemAlreadyBorrowedException extends Exception {
    public ItemAlreadyBorrowedException(String itemId) {
        super("Item with ID " + itemId + " has no copies available right now.");
    }
}
