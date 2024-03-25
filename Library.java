import java.util.*;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void borrowBook(Book book) {
        this.books.remove(book);
    }

    public void returnBook(Book book) {
        this.books.add(book);
    }

    public void displayAvailableBooks() {
        for (Book book : books) {
            Console.writeLine(book.getTitle());
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
