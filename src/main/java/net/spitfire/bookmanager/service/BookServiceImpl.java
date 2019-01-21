package net.spitfire.bookmanager.service;

import net.spitfire.bookmanager.model.Book;
import net.spitfire.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        Optional<Book> book = this.bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
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
    public void deleteBook(Integer id) {
        try {
            deleteBook(getBook(id));
        } catch (NullPointerException e) {
            System.out.println("There is no Entity with such ID");
        }
    }

    @Override
    public List<Book> getAllBooks(int pageNumber, int pageSize) {
        //return bookRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
        return bookRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
