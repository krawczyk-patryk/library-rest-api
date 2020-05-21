package pl.krawczykpatryk.libraryrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krawczykpatryk.libraryrest.converters.BookConverter;
import pl.krawczykpatryk.libraryrest.converters.BookDtoConverter;
import pl.krawczykpatryk.libraryrest.dtos.BookDto;
import pl.krawczykpatryk.libraryrest.exceptions.BookNotFoundException;
import pl.krawczykpatryk.libraryrest.models.Book;
import pl.krawczykpatryk.libraryrest.models.Comment;
import pl.krawczykpatryk.libraryrest.repositories.BookRepository;
import pl.krawczykpatryk.libraryrest.repositories.CommentRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final Integer PAGE_SIZE = 5;

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final BookDtoConverter bookDtoConverter;
    private final BookConverter bookConverter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CommentRepository commentRepository,
                           BookDtoConverter bookDtoConverter, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
        this.bookDtoConverter = bookDtoConverter;
        this.bookConverter = bookConverter;
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return bookDtoConverter.apply(book);
    }

    @Override
    public Book findBookWithCommentsById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<BookDto> findAllBooks(Integer page, Sort.Direction sortByDate) {
        List<Book> allBooks = bookRepository.findAllBooks(
                PageRequest.of(page, PAGE_SIZE, Sort.by(sortByDate, "dateOfPublication")));
        return allBooks.stream().map(bookDtoConverter).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllBooksWithComments(int page, Sort.Direction sortByDate) {
        List<Book> allBooks = bookRepository.findAllBooks(
                PageRequest.of(page, PAGE_SIZE, Sort.by(sortByDate, "dateOfPublication")));
        List<Long> booksIds = allBooks.stream().map(Book::getId).collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByBookIdIn(booksIds);
        allBooks.forEach(book -> book.setComment(getCommentsByBookId(comments, book.getId())));
        return allBooks;
    }

    @Override
    public Book createBook(BookDto bookDto) {
        Book book = bookConverter.apply(bookDto);
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book editBook(Book book) {
        Book editedBook = bookRepository.findById(book.getId()).get();
        editedBook.setTitle(book.getTitle());
        editedBook.setAuthor(book.getAuthor());
        editedBook.setPages(book.getPages());
        editedBook.setDateOfPublication(book.getDateOfPublication());
        return editedBook;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private List<Comment> getCommentsByBookId(List<Comment> comments, Long id) {
        return comments.stream()
                .filter(comment -> Objects.equals(comment.getBookId(), id))
                .collect(Collectors.toList());
    }
}