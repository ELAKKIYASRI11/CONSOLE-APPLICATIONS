// Thrown when an operation references a member ID that isn't registered.
// Separating this from ItemNotFoundException matters: a failed borrow could
// be due to a bad item ID OR a bad member ID, and catching them separately
// lets the console UI print a precise, correct error message either way.
public class InvalidMemberException extends Exception {
    public InvalidMemberException(String memberId) {
        super("No member found with ID: " + memberId);
    }
}
