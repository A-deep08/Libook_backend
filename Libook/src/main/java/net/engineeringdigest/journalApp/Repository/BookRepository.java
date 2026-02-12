package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.Entity.Book;
import net.engineeringdigest.journalApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}

