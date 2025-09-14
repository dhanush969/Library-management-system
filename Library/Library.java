package Library;

import java.util.ArrayList;
import java.util.List;

public class Library implements Issueable {

    private List<Book> bookCollection;

    public Library() {
        bookCollection = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        bookCollection.add(newBook);
        System.out.println("Successfully added: " + title);
    }

    // Issue a book if available
    @Override
    public boolean issueBook(String isbn) {
        for (Book b : bookCollection) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isAvailable()) {
                    b.issue();
                    System.out.println("Book issued: " + b.getTitle());
                    return true;
                } else {
                    System.out.println("Sorry, " + b.getTitle() + " is already issued.");
                    return false;
                }
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
        return false;
    }

    // Return a previously issued book
    @Override
    public boolean returnBook(String isbn) {
        for (Book b : bookCollection) {
            if (b.getIsbn().equals(isbn)) {
                if (!b.isAvailable()) {
                    b.returned();
                    System.out.println("Book returned: " + b.getTitle());
                    return true;
                } else {
                    System.out.println("Book " + b.getTitle() + " was not issued.");
                    return false;
                }
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
        return false;
    }

    // Display all books in the library
    public void listBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("Library has no books right now.");
            return;
        }
        System.out.println("Library Books:");
        for (Book b : bookCollection) {
            System.out.println(b.toString());
        }
    }
}
