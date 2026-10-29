package librarymgmtsystem;

import java.util.Objects;

public class Book implements IBook {

    private int id;
    private String title;
    private String author;
    private String category;
    private int price;

    public Book(int id, String title, String author,
                String category, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Book))
            return false;

        Book book = (Book) obj;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
}