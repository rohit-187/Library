import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibraryItem[] items = new LibraryItem[100]; // max 100 items
        int count = 0;

        // Predefined items
        items[count++] = new Book(1, "The Hobbit", "J.R.R. Tolkien");
        items[count++] = new Book(2, "1984", "George Orwell");
        items[count++] = new Magazine(3, "Science Weekly", 58);
        items[count++] = new Magazine(4, "Tech Today", 12);
        items[count++] = new Comic(5, "Spider-Man", "Steve Ditko");
        items[count++] = new Comic(6, "Batman", "Bob Kane");

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display All Items");
            System.out.println("2. Borrow Item");
            System.out.println("3. Return Item");
            System.out.println("4. Exit");

            int choice = getValidInt(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    System.out.println("\n--- All Items ---");
                    for (int i = 0; i < count; i++)
                        items[i].displayInfo();
                    break;

                case 2:
                    borrowItem(items, count, sc);
                    break;

                case 3:
                    returnItem(items, count, sc);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Input validation for integers
    private static int getValidInt(Scanner sc, String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine(); // discard invalid
            }
        }
        return num;
    }

    // Borrow item by ID
    private static void borrowItem(LibraryItem[] items, int count, Scanner sc) {
        int id = getValidInt(sc, "Enter ID to borrow: ");
        for (int i = 0; i < count; i++) {
            if (items[i].id == id) {
                try {
                    ((Borrowable) items[i]).borrow();
                } catch (ItemNotAvailableException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Return item by ID
    private static void returnItem(LibraryItem[] items, int count, Scanner sc) {
        int id = getValidInt(sc, "Enter ID to return: ");
        for (int i = 0; i < count; i++) {
            if (items[i].id == id) {
                ((Borrowable) items[i]).returnItem();
                return;
            }
        }
        System.out.println("Item not found.");
    }
}
