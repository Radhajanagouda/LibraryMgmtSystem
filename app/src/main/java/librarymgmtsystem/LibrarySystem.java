package librarymgmtsystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem implements ILibrarySystem {

    private Map<IBook, Integer> _books = new HashMap<>();

    @Override
    public void addBook(IBook book, int quantity) {

        if (_books.containsKey(book)) {
            _books.put(book, _books.get(book) + quantity);
        } else {
            _books.put(book, quantity);
        }
    }

    @Override
    public void removeBook(IBook book, int quantity) {

        if (!_books.containsKey(book))
            return;

        int remaining = _books.get(book) - quantity;

        if (remaining <= 0) {
            _books.remove(book);
        } else {
            _books.put(book, remaining);
        }
    }

    @Override
    public int calculateTotal() {

        int total = 0;

        for (Map.Entry<IBook, Integer> entry : _books.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }

    @Override
    public Map<String, Integer> categoryTotalPrice() {

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<IBook, Integer> entry : _books.entrySet()) {

            IBook book = entry.getKey();
            int quantity = entry.getValue();

            result.put(
                    book.getCategory(),
                    result.getOrDefault(book.getCategory(), 0)
                            + (book.getPrice() * quantity)
            );
        }

        return result;
    }

    @Override
    public List<BooksInfo> booksInfo() {

        List<BooksInfo> result = new ArrayList<>();

        for (Map.Entry<IBook, Integer> entry : _books.entrySet()) {

            result.add(
                    new BooksInfo(
                            entry.getKey().getTitle(),
                            entry.getValue(),
                            entry.getKey().getPrice()
                    )
            );
        }

        result.sort(
                Comparator.comparing(BooksInfo::getTitle)
                        .thenComparing(BooksInfo::getQuantity)
        );

        return result;
    }

    @Override
    public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {

        Map<String, Integer> temp = new HashMap<>();

        for (Map.Entry<IBook, Integer> entry : _books.entrySet()) {

            IBook book = entry.getKey();

            String key =
                    book.getCategory() + "|" + book.getAuthor();

            temp.put(
                    key,
                    temp.getOrDefault(key, 0)
                            + entry.getValue()
            );
        }

        List<CategoryAuthorWithCount> result =
                new ArrayList<>();

        for (Map.Entry<String, Integer> entry :
                temp.entrySet()) {

            String[] parts = entry.getKey().split("\\|");

            result.add(
                    new CategoryAuthorWithCount(
                            parts[0],
                            parts[1],
                            entry.getValue()
                    )
            );
        }

        result.sort(
                Comparator.comparing(
                                CategoryAuthorWithCount::getCategory)
                        .thenComparing(
                                CategoryAuthorWithCount::getAuthor)
        );

        return result;
    }
}