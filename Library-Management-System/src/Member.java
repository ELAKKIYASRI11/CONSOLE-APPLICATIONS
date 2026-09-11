import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    // Tracks which item IDs this member currently has borrowed —
    // needed so returnItem() can validate they actually hold it.
    private final List<String> borrowedItemIds;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItemIds = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<String> getBorrowedItemIds() {
        return borrowedItemIds;
    }

    public void addBorrowedItem(String itemId) {
        borrowedItemIds.add(itemId);
    }

    public void removeBorrowedItem(String itemId) {
        borrowedItemIds.remove(itemId);
    }
}
