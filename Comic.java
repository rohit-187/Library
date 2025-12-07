public class Comic extends LibraryItem implements Borrowable {
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
