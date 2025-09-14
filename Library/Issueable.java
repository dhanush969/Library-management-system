package Library;

public interface Issueable {
    boolean issueBook(String isbn);
    boolean returnBook(String isbn);
}
