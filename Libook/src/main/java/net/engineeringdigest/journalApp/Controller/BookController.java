package net.engineeringdigest.journalApp.Controller;

import lombok.RequiredArgsConstructor;
import net.engineeringdigest.journalApp.Dto.BookRequest;
import net.engineeringdigest.journalApp.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> addBook(
            @RequestParam Long userId,
            @RequestBody @Valid BookRequest request) {

        return ResponseEntity.ok(bookService.addBook(userId, request));
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam Long userId) {
        return ResponseEntity.ok(bookService.getBooks(userId));
    }
}
