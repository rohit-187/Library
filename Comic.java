public class Comic extends LibraryItem {
    private String illustrator;

    public Comic(int id, String title, String illustrator) {
        super(id, title);
        this.illustrator = illustrator;
    }

    @Override
    public void displayInfo() {
        System.out.println("Comic ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Illustrator: " + illustrator);
        System.out.println("Borrowed: " + isBorrowed);
        if (borrowDate != null) System.out.println("Borrowed on: " + borrowDate);
        if (returnDate != null) System.out.println("Returned on: " + returnDate);
        System.out.println("---------------------------");
    }
}
