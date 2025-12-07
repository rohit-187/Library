public class Book extends LibraryItem implements Borrowable {
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
        System.out.println("---------------------------");
    }

    @Override
    public void borrow() throws ItemNotAvailableException {
        borrowItem();
    }

    @Override
    public void returnItem() {
        super.returnItem();
    }
}
