public class Book extends LibraryItem {
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Borrowed: " + isBorrowed);
        if (borrowDate != null) System.out.println("Borrowed on: " + borrowDate);
        if (returnDate != null) System.out.println("Returned on: " + returnDate);
        System.out.println("---------------------------");
    }
}
