import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookStoreInventory {
    private Map<String,Book> inventory=new HashMap<>();
    public void addBook(Book book) {
        inventory.put(book.getISBN(),book);
        System.out.println("Quantum book store: Added book '" + book.getTitle() + "' by " + book.getAuthor());
    }

    public void removeOutDatedBook(int years) {
        int currentYear= LocalDate.now().getYear();
        Iterator<Map.Entry<String, Book>> it = inventory.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book book = entry.getValue();
            if(currentYear - book.getYearPublished()> years) {
                it.remove();
                System.out.println("Quantum book store: Removed outdated book '" + book.getTitle() + "' published in " + book.getYearPublished());
            }
        }

    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new Exception("Quantum book store: Book with ISBN " + isbn + " not found.");
        }

        if (!(book instanceof Purchasable)) {
            throw new Exception("Quantum book store: Book with ISBN " + isbn + " is not purchasable.");
        }

        Purchasable purchasable = (Purchasable) book;
        double total = purchasable.buy(quantity, email, address);
        System.out.println("Quantum book store: " + quantity + " copy/copies of '" + book.getTitle() + "' purchased, total paid: " + total);
        return total;
    }

    public void showInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        for (Book book : inventory.values()) {
            String info = " - " + book.getTitle() + " (" + book.getISBN() + "), Author: " + book.getAuthor() + ", Year: " + book.getYearPublished() + ", Price: " + book.getPrice();

            if (book instanceof PaperBook) {
                info += ", Stock: " + ((PaperBook) book).getStock();
            } else if (book instanceof Ebook) {
                info += ", Type: E-Book";
            } else if (book instanceof DemoBook) {
                info += ", Type: Showcase (Not for sale)";
            }
            System.out.println(info);
        }
    }
}
