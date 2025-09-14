package Library;

public class Book extends LibraryItem {

    private boolean isIssued;

    // Constructor
    public Book(String title, String author, String isbn) {
        super(title, author, isbn);
        this.isIssued = false; // by default, book is available
    }

    // Mark the book as issued
    public void issue() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book '" + title + "' is issued.");
        } else {
            System.out.println("Book '" + title + "' has been already issued!");
        }
    }

    // Mark the book as returned
    public void returned() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book '" + title + "' is returned.");
        } else {
            System.out.println("Book '" + title + "' was not issued.");
        }
    }

    @Override
    public boolean isAvailable() {
        return !isIssued;
    }

    @Override
    public String toString() {
        String status = isIssued ? "Currently Borrowed" : "Available";
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Status: " + status;
    }

    // Extra helper method students often add
    public void printBookInfo() {
        System.out.println(toString());
    }
}
