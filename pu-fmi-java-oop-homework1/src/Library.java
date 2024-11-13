import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private int workers;
    private List<Book> avaibleBooks;

    public Library(String name, String address, int workers) {
        this.name = name;
        this.address = address;
        this.workers = workers;
        avaibleBooks = new ArrayList<Book>();
    }

    public String GetName() {
        return name;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public String GetAddress() {
        return address;
    }
    public void SetAddress(String address) {
        this.address = address;
    }
    public int GetWorkers() {
        return workers;
    }
    public void SetWorkers(int workers) {
        this.workers = workers;
    }
    public List<Book> GetAvaibleBooks() {
        return avaibleBooks;
    }
    public void AddBook(Book book) {
        avaibleBooks.add(book);
    }
    public void RemoveBook(Book book) {
        avaibleBooks.remove(book);
    }
    public Book findBookByTitleOrISBN(String searchQuery) {
        return avaibleBooks.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(searchQuery) || book.getISBN().equals(searchQuery))
                .findFirst()
                .orElse(null);
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : avaibleBooks) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getISBN().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public void displayBooks() {
        if (avaibleBooks.isEmpty()) {
            System.out.println("Няма налични книги в библиотеката.");
        } else {
            avaibleBooks.forEach(System.out::println);
        }
    }
}
