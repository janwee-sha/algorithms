package hash.test;

import hash.Book;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {
    private Book book1, book2, book3;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting BookTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished BookTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up instances of Book.");

        book1 = new Book(
                "Thinking in Java", "Bruce Eckel",
                LocalDate.of(2007, 6, 1));
        book2 = new Book(
                "Java Concurrency In Practice", "Brian Goetz",
                LocalDate.of(2006, 5, 19));
        book3 = new Book("Implementing Domain-Driven Design", "Vaughn Vernon",
                LocalDate.of(2013, 2, 16));
    }

    @Test
    public void testHashCode() {
        System.out.println("Testing hashCode.");

        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());
    }

    @Test
    public void testEquals() {
        System.out.println("Testing equals.");

        assertNotEquals(book1, book2);
        assertNotEquals(book1, book3);
        assertNotEquals(book2, book3);
    }
}
