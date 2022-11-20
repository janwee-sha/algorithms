package Hash;

import java.time.LocalDate;

/**
 * A customized class overridden hashCode and equals methods.
 */
public class Book {
    private final String name;
    private final String author;
    private final LocalDate publicationDate;

    private int hash;//use a variable to store computed hashCode.

    public Book(String name, String author, LocalDate publicationDate) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public int hashCode() {
        int h = hash;
        if (h == 0) {
            h = 17;
            h = 31 * h + name.hashCode();
            h = 31 * h + author.hashCode();
            h = 31 * h + publicationDate.hashCode();
            hash = h;
        }
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) &&
                author.equals(book.author) &&
                publicationDate.equals(book.publicationDate);
    }
}
