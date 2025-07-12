# Quantum Book Store

a simple extensible Java-based online bookstore system that supports multiple book types, inventory management following **SOLID principles** and clean **Object-Oriented Design**.

---

## Features

- Manage inventory of:
  - **Paper Books** (physical stock, shipping required)
  - **EBooks** (delivered via email)
  - **Demo Books** (non-purchasable, for showcase only)
- Automatically add books to inventory via a **Factory**
- Buy books with:
  - Stock tracking for paper books
  - Proper exception handling for invalid or unavailable books
- Remove outdated books based on publish year
- Full test class demonstrating functionality

---

## Design Principles

This project is designed using open/closed principle and common **design patterns** for clean, extensible architecture:

### SOLID:

| **S**ingle Responsibility | Each class has one well-defined role |
| **O**pen/Closed | New book types can be added without modifying existing logic |
| **L**iskov Substitution | All books can be treated as `Book` safely |
| **I**nterface Segregation | Only `Purchasable` books define `buy()` logic |
| **D**ependency Inversion | `BookFactory` depends on `BookStoreInventory` via abstraction |

### Design Patterns Used

- **Factory Pattern**: Centralized creation of book objects



## Test Class

Run `BookStoreFullTest` to test:

- Book creation
- Buying a paper book and ebook
- Attempting to buy a non-purchasable demo book (handled with exception)
- Attempting to over-buy paper books beyond stock
- Removing books older than 20 years


## Project Structure
classes: book - paperBook - Ebook - bookFactory - BookStoreInventory - BookStoreFullTest(Test class)
interfaces: Purchasable - ShippingService - MailService

## Test class
 - Creating a bookstore inventory

 - Adding books via a factory

 - Buying books

 - Handling purchase errors

 - Removing outdated books

  - Testing stock limits

Initializes a new bookstore inventory to manage books.
 
```BookStoreInventory inventory = new BookStoreInventory(); ```

Creates a factory to build books and automatically register them to the inventory.
```BookFactory factory = new BookFactory(inventory);```

Adds three types of books:
A PaperBook with stock = 10
An EBook with file type PDF
A DemoBook that is not for sale
```Book paperBook = factory.createBook("Paper", "001", "Clean Code", 2008, 50.0, "Robert C. Martin", 10, null);```
```Book eBook = factory.createBook("Ebook", "002", "You Don't Know JS", 2015, 30.0, "Kyle Simpson", 0, "PDF");```
```Book demoBook = factory.createBook("Demo", "003", "Old Wisdom", 1990, 0.0, "Unknown", 0, null);```

Displays the current inventory with full details of each book.
```inventory.showInventory();```

Purchases 2 copies of the paper book and prints the total amount paid.
```double paid1 = inventory.buyBook("001", 2, "user@example.com", "123 Main Street");```

Purchases the EBook and prints the payment confirmation(No shipping address required for e-books).
```double paid2 = inventory.buyBook("002", 1, "user@example.com", null);```

Attempts to buy the demo book, which is not for sale(Catches and prints the exception message gracefully).
```
try {
    inventory.buyBook("003", 1, "user@example.com", null);
} catch (RuntimeException e) {
    System.out.println(e.getMessage());
}
```

Removes books published more than 20 years ago from the inventory.
```inventory.removeOutDatedBook(20);```

Tries to buy more paper books than available in stock(Triggers an error and confirms the system correctly prevents overselling).
```
try {
    inventory.buyBook("001", 100, "user@example.com", "123 Main Street");
} catch (RuntimeException e) {
    System.out.println(e.getMessage());
}
```

