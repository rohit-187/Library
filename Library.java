class Library {
    private LibraryItem[] items;

    public Library(LibraryItem[] items) {
        this.items = items;   
    }

    public void displayAllItems() {
        for (LibraryItem item : items) {
            item.displayInfo();
        }
    }

    public LibraryItem getItemById(int id) {
        for (LibraryItem item : items) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }
}
