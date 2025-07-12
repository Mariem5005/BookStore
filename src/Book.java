public abstract class Book {
    protected String ISBN;
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;

    public Book(String ISBN, String title, String author, int yearPublished, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public abstract boolean isForSale();

    public String getInfo() {
        return title + " by " + author + " (" + yearPublished + ")";
    }
    public abstract String getType();
}
