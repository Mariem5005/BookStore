public class BookStoreFullTest {
    public static void main(String[] args) throws Exception {
        BookStoreInventory inventory = new BookStoreInventory();
        BookFactory factory = new BookFactory(inventory);

        Book paperBook = factory.createBook("Paper", "001", "Clean Code", 2008, 50.0, "Robert C. Martin", 10, null);
        Book eBook = factory.createBook("Ebook", "002", "You Don't Know JS", 2015, 30.0, "Kyle Simpson", 0, "PDF");
        Book demoBook = factory.createBook("Demo", "003", "Old Wisdom", 1990, 0.0, "Unknown", 0, null);
        inventory.showInventory();
        // Successful purchases
        double paid1 = inventory.buyBook("001", 2, "user@example.com", "123 Main Street");
        System.out.println("Quantum book store: Paid amount = $" + paid1);

        double paid2 = inventory.buyBook("002", 1, "user@example.com", null);
        System.out.println("Quantum book store: Paid amount = $" + paid2);

        // Attempt to buy a showcase book (should throw)
        try {
            inventory.buyBook("003", 1, "user@example.com", null);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Remove books older than 20 years
        inventory.removeOutDatedBook(20);
        // Attempt to buy more paper books than in stock
        try {
            inventory.buyBook("001", 100, "user@example.com", "123 Main Street");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

