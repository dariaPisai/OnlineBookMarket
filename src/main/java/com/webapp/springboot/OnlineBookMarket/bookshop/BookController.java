package com.webapp.springboot.OnlineBookMarket.bookshop;


import jakarta.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@SessionAttributes("name")
public class BookController {

    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }
    private BookService bookService;


    //list-books
    @RequestMapping("list-books")
    public String listAllBooks(ModelMap model) {
        String book = (String) model.get("title");
        List<Books> books =  bookService.findByTitle("The Alchemist");
        model.addAttribute("books", books);
        return "listBooks";
    }

    @RequestMapping(value = "add-book", method = RequestMethod.GET)
    public String showAddBookPage(ModelMap model) {
        Books book = new Books(); // new book has no id yet// make sure id is null
        model.addAttribute("book", book);
        return "add-book";
    }

    @RequestMapping(value = "add-book", method = RequestMethod.POST)
    public String addNewBooksPage(@ModelAttribute("book") @Valid Books book, BindingResult result) {
        // Add the book using the service
        if(result.hasErrors()) {
            return "add-book";

        }
        bookService.addBook(book.getTitle(), book.getISBN(), book.getDescription(),
                book.getPrice(), book.getLanguage(), book.getPublishingDate(), book.isInStock());
        return "redirect:list-books";
    }

    @RequestMapping("delete-book")
    public String deleteBook(@RequestParam int id) {

        bookService.deleteById(id);
        return "redirect:list-books";
    }

    @RequestMapping(value="edit-book", method=RequestMethod.GET)
    public String showEditBook(@RequestParam int id, ModelMap model) {
        Books book = bookService.findById(id);
        model.addAttribute("book", book);
        return "add-book";
    }

    @RequestMapping(value = "edit-book", method = RequestMethod.POST)
    public String editBook(@Valid Books book, BindingResult result) {
        if (result.hasErrors()) {
            return "add-book"; // Redirect back to the form if there are errors
        }

        // Use the service to update the book
        bookService.editBook(book);

        return "redirect:list-books"; // Redirect to the list of books after editing
    }





}
