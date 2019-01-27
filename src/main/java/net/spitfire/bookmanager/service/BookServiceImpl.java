package net.spitfire.bookmanager.service;

import net.spitfire.bookmanager.model.Book;
import net.spitfire.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Integer id) {
        //return bookRepository.findOne(id);
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get(); // If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
        } else {
            return null; // should i return null or empty entity with the special field?
        }
    }

    @Override
    public List<Book> getBookByFields(Book bookToFind) {
        //Collection<Books> foundBooks = this.books.findByTitles(book.getBookTitle()); // Spring.boot generates methods for SQL
        List<Book> foundBooks = new ArrayList<>();
        // strict search by ID
        if (bookToFind.getId() != null && getBook(bookToFind.getId()) != null) {
            foundBooks.add(getBook(bookToFind.getId()));
        }
        // custom H2 search for book by title & author instead of JPARepository SQL-methods
        else if (bookToFind.getId() == null) {
            for (Book currentBook : getAllBooks())
            {
                if (!bookToFind.getBookTitle().equals("") && currentBook.getBookTitle().toLowerCase().contains(bookToFind.getBookTitle().toLowerCase()))
                {
                    foundBooks.add(currentBook);
                }
                else if (!bookToFind.getBookAuthor().equals("") && currentBook.getBookAuthor().toLowerCase().contains(bookToFind.getBookAuthor().toLowerCase()))
                {
                    foundBooks.add(currentBook);
                }
            }
        }
        return foundBooks;
    }

    @Override
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks(int pageNumber, int pageSize) {
        return bookRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
