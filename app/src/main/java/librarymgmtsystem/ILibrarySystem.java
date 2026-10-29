package librarymgmtsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ILibrarySystem {
    void addBook(IBook book, int quantity);
    void removeBook(IBook book, int quantity);
    int calculateTotal();
    Map<String, Integer> categoryTotalPrice();
    List<BooksInfo> booksInfo();
    List<CategoryAuthorWithCount> categoryAndAuthorWithCount();
}

