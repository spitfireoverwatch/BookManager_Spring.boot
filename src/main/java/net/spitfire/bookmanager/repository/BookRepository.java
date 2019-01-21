package net.spitfire.bookmanager.repository;

import net.spitfire.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
