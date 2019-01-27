package net.spitfire.bookmanager.controller;

import net.spitfire.bookmanager.model.Book;
import net.spitfire.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private static final String createOrUpdateBookForm = "books/createOrUpdateBookForm";
    private final BookService bookService; //bookController autowired with bookService which autowired with bookRepository

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({ "/", "/index", "", "/books" })
    public String indexPage(Model model) {
        return "index";
    }

    @GetMapping("/books/new")
    public String showCreationForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return createOrUpdateBookForm;
    }

    @PostMapping("/books/new")
    public String processCreationForm(Book book) {
        bookService.createBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/books/list")
    public String getBooksList (Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "/books/booksList";
    }

    @GetMapping("/books/search")
    public String showSearchForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/books/searchForBook";
    }

    @PostMapping("/processSearchForm")
    public String processSearchForm(Book bookToFind, Model model) {
        model.addAttribute("books", bookService.getBookByFields(bookToFind));
        return "/books/booksList";
    }


    @GetMapping("/books/edit/{bookId}")
    public String showUpdateBookForm(@PathVariable("bookId") Integer bookId, Model model) {
        Book book = bookService.getBook(bookId);
        model.addAttribute("book", book);
        return createOrUpdateBookForm;
    }

    @PostMapping("/books/edit/{bookId}")
    public String processUpdateBookForm(Book book, @PathVariable("bookId") Integer bookId)
    {
        book.setId(bookId);
        bookService.editBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/books/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId)
    {
        bookService.deleteBookById(bookId);
        return "redirect:/books/list";
    }
}
