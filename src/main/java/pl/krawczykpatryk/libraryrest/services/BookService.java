package pl.krawczykpatryk.libraryrest.services;

import org.springframework.data.domain.Sort;
import pl.krawczykpatryk.libraryrest.dtos.BookDto;
import pl.krawczykpatryk.libraryrest.models.Book;

import java.util.List;

public interface BookService {

    BookDto findBookById(Long id);
    Book findBookWithCommentsById(Long id);
    List<BookDto> findAllBooks(Integer page, Sort.Direction sortByDate);
    List<Book> findAllBooksWithComments(int page, Sort.Direction sortByDate);
    Book createBook(BookDto bookDto);
    Book editBook(Book book);
    void deleteBook(Long id);
}