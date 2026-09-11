import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        seedData(library);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    library.displayAllItems();
                    break;

                case 2:
                    System.out.print("Enter member ID: ");
                    String borrowMemberId = scanner.nextLine().trim();
                    System.out.print("Enter item ID: ");
                    String borrowItemId = scanner.nextLine().trim();
                    try {
                        library.borrowItem(borrowMemberId, borrowItemId);
                        System.out.println("Borrowed successfully.\n");
                    } catch (ItemNotFoundException | InvalidMemberException e) {
                        System.out.println("Error: " + e.getMessage() + "\n");
                    } catch (ItemAlreadyBorrowedException e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.print("Join the waitlist instead? (y/n): ");
                        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                            try {
                                library.joinWaitlist(borrowMemberId, borrowItemId);
                                System.out.println("Added to waitlist.\n");
                            } catch (ItemNotFoundException | InvalidMemberException ex) {
                                System.out.println("Error: " + ex.getMessage() + "\n");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    String returnMemberId = scanner.nextLine().trim();
                    System.out.print("Enter item ID: ");
                    String returnItemId = scanner.nextLine().trim();
                    try {
                        library.returnItem(returnMemberId, returnItemId);
                        System.out.println("Returned successfully.\n");
                    } catch (ItemNotFoundException | InvalidMemberException e) {
                        System.out.println("Error: " + e.getMessage() + "\n");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.\n");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Library Menu =====");
        System.out.println("1. View all items");
        System.out.println("2. Borrow an item");
        System.out.println("3. Return an item");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Pre-loads a few items and members so the menu is testable immediately.
    private static void seedData(Library library) {
        library.addItem(new Book("B1", "Effective Java", 2, "Joshua Bloch"));
        library.addItem(new Book("B2", "Clean Code", 1, "Robert Martin"));
        library.addItem(new Magazine("M1", "National Geographic", 3, 245));
        library.addItem(new DVD("D1", "Inception", 1, 148));

        library.registerMember(new Member("MEM1", "Elakkiyasri"));
        library.registerMember(new Member("MEM2", "Guest User"));
    }
}
