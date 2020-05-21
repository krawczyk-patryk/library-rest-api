package pl.krawczykpatryk.libraryrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.krawczykpatryk.libraryrest.dtos.BookDto;
import pl.krawczykpatryk.libraryrest.models.Book;
import pl.krawczykpatryk.libraryrest.services.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books/{id}")
    public BookDto getBookById(@PathVariable(name = "id") final Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/api/books/comment/{id}")
    public Book getBookWithCommentsById(@PathVariable(name = "id") final Long id) {
        return bookService.findBookWithCommentsById(id);
    }

    @GetMapping("/api/books")
    public List<BookDto> getBooks(@RequestParam(required = false) Integer page,
                                  Sort.Direction sortByDate) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sortByDate != null ? sortByDate : Sort.Direction.DESC;
        return bookService.findAllBooks(pageNumber, sortDirection);
    }

    @GetMapping("/api/books/comments")
    public List<Book> getBooksWithComments(@RequestParam(required = false) Integer page,
                                           Sort.Direction sortByDate) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sortByDate != null ? sortByDate : Sort.Direction.DESC;
        return bookService.findAllBooksWithComments(pageNumber, sortDirection);
    }

    @PostMapping("/api/books")
    public Book createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/api/books")
    public Book editBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}