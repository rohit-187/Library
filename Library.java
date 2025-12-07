import java.util.Scanner;

public class Library{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibraryItem[] items = new LibraryItem[100]; // max 100 items
        int count = 0;

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Comic");
            System.out.println("4. Display All Items");
            System.out.println("5. Borrow Item");
            System.out.println("6. Return Item");
            System.out.println("7. Exit");
            int choice = getValidInt(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    int bId = getUniqueId(sc, items, count);
                    System.out.print("Enter Title: ");
                    String bTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    items[count++] = new Book(bId, bTitle, author);
                    System.out.println("Book added.");
                    break;

                case 2:
                    int mId = getUniqueId(sc, items, count);
                    System.out.print("Enter Title: ");
                    String mTitle = sc.nextLine();
                    int issue = getValidInt(sc, "Enter Issue Number: ");
                    items[count++] = new Magazine(mId, mTitle, issue);
                    System.out.println("Magazine added.");
                    break;

                case 3:
                    int cId = getUniqueId(sc, items, count);
                    System.out.print("Enter Title: ");
                    String cTitle = sc.nextLine();
                    System.out.print("Enter Illustrator: ");
                    String illustrator = sc.nextLine();
                    items[count++] = new Comic(cId, cTitle, illustrator);
                    System.out.println("Comic added.");
                    break;

                case 4:
                    System.out.println("\n--- All Items ---");
                    for (int i = 0; i < count; i++)
                        items[i].displayInfo();
                    break;

                case 5:
                    borrowItem(items, count, sc);
                    break;

                case 6:
                    returnItem(items, count, sc);
                    break;

                case 7:
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

    // Ensure unique ID
    private static int getUniqueId(Scanner sc, LibraryItem[] items, int count) {
        int id;
        while (true) {
            id = getValidInt(sc, "Enter ID: ");
            boolean exists = false;
            for (int i = 0; i < count; i++) {
                if (items[i].id == id) {
                    exists = true;
                    break;
                }
            }
            if (!exists) break;
            System.out.println("ID already exists. Please enter a unique ID.");
        }
        return id;
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
