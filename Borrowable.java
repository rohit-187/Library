public interface Borrowable {
    void borrow() throws ItemNotAvailableException;
    void returnItem();
}
