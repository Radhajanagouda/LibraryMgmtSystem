package librarymgmtsystem;
public class BooksInfo {

    private String title;
    private int quantity;
    private int price;

    public BooksInfo(String title, int quantity, int price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}