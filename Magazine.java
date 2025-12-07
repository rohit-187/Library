public class Magazine extends LibraryItem {
    private int issue;

    public Magazine(int id, String title, int issue) {
        super(id, title);
        this.issue = issue;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Issue: " + issue);
        System.out.println("Borrowed: " + isBorrowed);
        if (borrowDate != null) System.out.println("Borrowed on: " + borrowDate);
        if (returnDate != null) System.out.println("Returned on: " + returnDate);
        System.out.println("---------------------------");
    }
}
