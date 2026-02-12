package net.engineeringdigest.journalApp.Service;

import lombok.RequiredArgsConstructor;
import net.engineeringdigest.journalApp.Dto.BookRequest;
import net.engineeringdigest.journalApp.Dto.BookResponse;
import net.engineeringdigest.journalApp.Entity.Book;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.BookRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookResponse addBook(Long userId, BookRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setStatus(request.getStatus());
        book.setUser(user);

        bookRepository.save(book);

        return mapToResponse(book);
    }

    public List<BookResponse> getBooks(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BookResponse mapToResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getStatus()
        );
    }
}
