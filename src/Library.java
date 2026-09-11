import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Library {
    // Key = item ID -> O(1) lookup instead of scanning a list every time
    private final Map<String, Item> catalog;
    private final List<Member> members;
    // One waitlist queue PER item, keyed by item ID. FIFO order is the
    // whole point of a waitlist, so Queue (backed by LinkedList) is used
    // instead of a plain List where ordering would just be a convention.
    private final Map<String, Queue<String>> waitlists;

    public Library() {
        catalog = new HashMap<>();
        members = new ArrayList<>();
        waitlists = new HashMap<>();
    }

    public void addItem(Item item) {
        catalog.put(item.getId(), item);
        waitlists.put(item.getId(), new LinkedList<>());
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Item findItem(String itemId) throws ItemNotFoundException {
        Item item = catalog.get(itemId);
        if (item == null) {
            throw new ItemNotFoundException(itemId);
        }
        return item;
    }

    public Member findMember(String memberId) throws InvalidMemberException {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return m;
            }
        }
        throw new InvalidMemberException(memberId);
    }

    // Three distinct failure modes, three distinct exceptions — the caller
    // (the console menu) can react differently to each one instead of
    // getting one generic "operation failed" signal.
    public void borrowItem(String memberId, String itemId)
            throws ItemNotFoundException, InvalidMemberException, ItemAlreadyBorrowedException {
        Item item = findItem(itemId);
        Member member = findMember(memberId);

        item.borrow(); // throws ItemAlreadyBorrowedException if none available
        member.addBorrowedItem(itemId);
    }

    public void returnItem(String memberId, String itemId)
            throws ItemNotFoundException, InvalidMemberException {
        Item item = findItem(itemId);
        Member member = findMember(memberId);

        member.removeBorrowedItem(itemId);
        item.returnItem();

        // If someone is waiting for this item, this is where you'd notify
        // them — the queue already gives you the correct next person.
        Queue<String> waitlist = waitlists.get(itemId);
        if (waitlist != null && !waitlist.isEmpty()) {
            String nextMemberId = waitlist.poll();
            System.out.println("Notify member " + nextMemberId + ": '" + item.getTitle() + "' is now available.");
        }
    }

    public void joinWaitlist(String memberId, String itemId) throws ItemNotFoundException, InvalidMemberException {
        findItem(itemId);   // validates item exists
        findMember(memberId); // validates member exists
        waitlists.get(itemId).add(memberId);
    }

    public void displayAllItems() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }
        for (Item item : catalog.values()) {
            item.displayInfo();
        }
    }
}
