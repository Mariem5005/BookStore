public class PaperBook extends Book implements ShippingService, Purchasable{
    private int stock;

    public PaperBook(String ISBN, String title, int year, double price, String author, int stock) {
        super(ISBN,title,author,year,price);
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        if (quantity > stock) {
            throw new Exception("Quantum book store: Not enough stock for '" + getTitle() + "'");
        }
        stock -= quantity;
        System.out.println("Quantum book store: Shipped " + quantity + " copy/copies of '" + getTitle() + "' to " + address);
        return quantity * getPrice();
    }
    @Override
    public String getType() {
        return "Paper";
    }
}
