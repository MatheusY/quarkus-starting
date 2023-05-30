package org.mmatsubara.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Practicing Quarkus", "Antonio", 2020, "IT"),
                new Book(3, "Effective Java", "Josh Bloch", 2001, "IT"),
                new Book(4, "Understanding Quarkus", "Bruce Eckel", 1998, "IT")
        );
    }

    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream().filter((book -> book.id == id)).findFirst();
    }
}
