package net.spitfire.bookmanager.service;

import net.spitfire.bookmanager.model.Book;
import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBook(Integer id);
    Book editBook(Book book);
    void deleteBook(Book book);
    void deleteBookById(Integer id);
    List<Book> getAllBooks(int pageNumber, int pageSize);
    List<Book> getAllBooks();
}
