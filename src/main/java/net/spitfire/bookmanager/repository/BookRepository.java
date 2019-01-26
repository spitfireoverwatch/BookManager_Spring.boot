package net.spitfire.bookmanager.repository;

import net.spitfire.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;


public interface BookRepository extends JpaRepository<Book, Integer> {
    /*
    // Spring.boot generated method for SQL db
    @Query("SELECT DISTINCT book FROM Book WHERE book.bookTitle LIKE :%bookTitle%")
    @Transactional(readOnly = true)
    Collection<Book> findByTitle(@Param("bookTitle") String bookTitle);*/

    /*
    // Spring.boot generated method for SQL db
    @Query("SELECT DISTINCT book FROM Book WHERE book.bookAuthor LIKE :%bookAuthor%")
    @Transactional(readOnly = true)
    Collection<Book> findByAuthor(@Param("bookAuthor") String bookAuthor);*/
}
