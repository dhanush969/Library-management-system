package Library;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public abstract boolean isAvailable();

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
}
