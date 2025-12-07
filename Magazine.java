public class Magazine extends LibraryItem implements Borrowable {
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
