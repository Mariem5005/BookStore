public class BookFactory {
    private final BookStoreInventory inventory;

    public BookFactory(BookStoreInventory inventory) {
        this.inventory = inventory;
    }

    public Book createBook(String type, String isbn, String title, int year, double price, String author, int stock, String fileType) {
        Book book;

        switch (type) {
            case "Paper":
                book = new PaperBook(isbn, title, year, price, author, stock);
                break;
            case "Ebook":
                book = new Ebook(isbn, title, year, price, author, fileType);
                break;
            case "Demo":
                book = new DemoBook(isbn, title, year, author);
                break;
            default:
                throw new IllegalArgumentException("Quantum book store: Unknown book type.");
        }

        inventory.addBook(book); // Auto-add to inventory
        return book;
    }
}
