public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, int year, String author) {
        super(ISBN,title,author,year,0.0);
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public String getType() {
        return "Demo";
    }

}
