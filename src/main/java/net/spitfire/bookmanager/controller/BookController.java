package net.spitfire.bookmanager.controller;

import net.spitfire.bookmanager.model.Book;
import net.spitfire.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("book", new Book());
        return "greeting";
        //greeting.html Thymeleaf.html
    }
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addPagePerson(@ModelAttribute Book book, Model model) {
        bookService.createBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "result";
    }
}
