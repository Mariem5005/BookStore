public class Ebook extends Book implements MailService,Purchasable {
    private String fileType;

    public Ebook(String ISBN, String title, int year, double price, String author, String fileType) {
        super(ISBN,title,author,year,price);
        this.fileType = fileType;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        if (quantity > 1) {
            throw new Exception("Quantum book store: Only one copy of an eBook can be bought at a time for ISBN " + ISBN);
        }
        System.out.println("Quantum book store: Sending ebook '" + title + "' (" + fileType + ") to email: " + email);
        return getPrice();
    }
    @Override
    public String getType() {
        return "Ebook";
    }

}
