// Thrown when a lookup uses an item ID that doesn't exist in the catalog.
// Extending Exception (not RuntimeException) makes this a CHECKED exception —
// callers are forced to either catch it or declare it, so a missing item
// can never be silently ignored.
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String itemId) {
        super("No item found with ID: " + itemId);
    }
}
