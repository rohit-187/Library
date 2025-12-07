import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public abstract class LibraryItem implements Borrowable {
    protected int id;
    protected String title;
    protected boolean isBorrowed;
    protected LocalDate borrowDate; // date borrowed
    protected LocalDate returnDate; // date returned

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
        this.borrowDate = null;
        this.returnDate = null;
    }

    @Override
    public void borrow() throws ItemNotAvailableException {
        if (isBorrowed) {
            throw new ItemNotAvailableException(title + " is already borrowed!");
        }

        borrowDate = getDateFromUser("borrow");
        isBorrowed = true;
        System.out.println(title + " borrowed on " + borrowDate);
        System.out.println("It must be returned within 7 days to avoid late fees.");
    }

    @Override
    public void returnItem() {
        if (!isBorrowed) {
            System.out.println(title + " was not borrowed, cannot return.");
            return;
        }

        while (true) {
            returnDate = getDateFromUser("return");
            if (returnDate.isBefore(borrowDate)) {
                System.out.println("Return date cannot be before borrow date!");
            } else {
                break;
            }
        }

        isBorrowed = false;

        long daysBetween = ChronoUnit.DAYS.between(borrowDate, returnDate);
        if (daysBetween > 7) {
            long weeksLate = (daysBetween - 1) / 7; // full weeks late
            long fee = weeksLate * 10;
            System.out.println(title + " returned on " + returnDate + ". Late fee: $" + fee);
        } else {
            System.out.println(title + " returned on " + returnDate + ". No late fee.");
        }
    }

    private LocalDate getDateFromUser(String action) {
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        while (true) {
            try {
                System.out.print("Enter " + action + " year: ");
                year = sc.nextInt();
                System.out.print("Enter " + action + " month (1-12): ");
                month = sc.nextInt();
                System.out.print("Enter " + action + " day (1-31): ");
                day = sc.nextInt();
                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Invalid date. Please enter valid year, month, and day.");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    public abstract void displayInfo();
}
