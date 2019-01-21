package net.spitfire.bookmanager.service;

import net.spitfire.bookmanager.model.Book;
import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBook(Integer id);
    Book editBook(Book book);
    void deleteBook(Book book);
    void deleteBook(Integer id);
    List<Book> getAllBooks(int pageNumber, int pageSize);
    List<Book> getAllBooks();
    // On top of the CrudRepository, there is a PagingAndSortingRepository abstraction that adds additional methods to ease paginated access to entities:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.core-concepts
}
