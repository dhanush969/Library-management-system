// File: LibraryTest.java
package Library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void testIssueBook() {
        Library lib = new Library();
        lib.addBook("Title", "Author", "123");
        assertTrue(lib.issueBook("123"));   
        assertFalse(lib.issueBook("123"));  
    }

    @Test
    void testReturnBook() {
        Library lib = new Library();
        lib.addBook("Title", "Author", "123");
        lib.issueBook("123");
        assertTrue(lib.returnBook("123"));   
        assertFalse(lib.returnBook("123"));  
    }

    @Test
    void testIsAvailable() {
        Book b = new Book("Title", "Author", "123");
        assertTrue(b.isAvailable());
        b.issue();
        assertFalse(b.isAvailable());
    }
}
