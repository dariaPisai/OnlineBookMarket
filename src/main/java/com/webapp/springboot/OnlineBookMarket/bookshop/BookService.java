package com.webapp.springboot.OnlineBookMarket.bookshop;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {
    private static List<Books> books = new ArrayList<>();

    private static int bookCount = 0;
    static {
        books.add(new Books(++bookCount,"The Alchemist", "978-0062315007", "The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller.", 8.99f, "English", LocalDate.now(), true));
        books.add(new Books(++bookCount, "The Da Vinci Code", "978-0307474278", "The Da Vinci Code is a 2003 mystery thriller novel by Dan Brown. It follows symbologist Robert Langdon and cryptologist Sophie Neveu", 9.99f, "English", LocalDate.now(), true));
    }

    public List<Books> findByTitle(String title) {
        return books;
    }

    public void addBook(String title, String ISBN, String description, float price, String language, LocalDate publishingDate, boolean isInStock) {
//        books.add(new Books(books.size() + 1, title, ISBN, description, price, language, publishingDate, isInStock));
        Books book = new Books(++bookCount, title, ISBN, description, price, language, publishingDate, isInStock);
        books.add(book);
    }

    public void deleteById(int id) {
        Predicate<? super Books> predicate = book -> book.getId() == id;
        books.removeIf(predicate);
    }

    public Books findById(long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
    }


    public void editBook(@Valid Books book) {
        if (book.getId() <= 0) {  // Check for invalid ID (e.g., 0 or negative)
            throw new IllegalArgumentException("Invalid book ID");
        }
        // Find the existing book by ID
        Books existingBook = books.stream()
                .filter(b -> b.getId() == book.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        // Update the fields of the existing book
        existingBook.setTitle(book.getTitle());
        existingBook.setISBN(book.getISBN());
        existingBook.setDescription(book.getDescription());
        existingBook.setPrice(book.getPrice());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setPublishingDate(book.getPublishingDate());
        existingBook.setInStock(book.isInStock());
    }

}
