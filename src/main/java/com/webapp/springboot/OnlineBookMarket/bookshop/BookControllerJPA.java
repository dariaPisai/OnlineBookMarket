package com.webapp.springboot.OnlineBookMarket.bookshop;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
public class BookControllerJPA {

    private BookRepository bookRepository;

    public BookControllerJPA(BookService bookService, BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    // List all books
    @RequestMapping("list-books")
    public String listAllBooks(ModelMap model) {
        // Fetch all books
        List<Books> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "listBooks"; // This should be the name of your view (e.g., a JSP or Thymeleaf template)
    }

    // Show the Add Book form
    @RequestMapping(value = "add-book", method = RequestMethod.GET)
    public String showAddBookPage(ModelMap model) {
        Books book = new Books(); // New book instance, no ID yet
        model.addAttribute("book", book);
        return "add-book";
    }

    // Handle form submission for adding a book
    @RequestMapping(value = "add-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute("book") @Valid Books book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "add-book"; // Return back to form if there are validation errors
        }
        bookRepository.save(book);
        return "redirect:list-books";
    }


    // Delete a book
    @RequestMapping("delete-book")
    public String deleteBook(@RequestParam int id) {
        bookRepository.deleteById(id);
        return "redirect:list-books";
    }

    // Show the Edit Book form
    @RequestMapping(value = "edit-book", method = RequestMethod.GET)
    public String showEditBook(@RequestParam int id, ModelMap model) {
        Books book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "add-book";
    }

    // Handle form submission for editing a book
    @RequestMapping(value = "edit-book", method = RequestMethod.POST)
    public String editBook(@Valid Books book, BindingResult result) {
        if (result.hasErrors()) {
            return "add-book"; // Redirect back to the form if there are validation errors
        }

        bookRepository.save(book); // Update the book in the database
        return "redirect:list-books";
    }

    // Search books by title
    @RequestMapping(value = "search-books", method = RequestMethod.GET)
    public String searchBooks(@RequestParam String title, ModelMap model) {
        List<Books> books = bookRepository.findByTitleContainingIgnoreCase(title); // Repository method to search by title
        model.addAttribute("books", books);
        model.addAttribute("searchKeyword", title); // Pass the search term to the view
        return "listBooks"; // Reuse the same listBooks view
    }
}
