abstract class LibraryItem {
    protected int id;
    protected String title;
    protected boolean isBorrowed;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
    }
      public abstract void displayInfo();

    public void returnItem() {
        isBorrowed = false;
        System.out.println(title + " returned successfully.");
    }
}
