package pl.krawczykpatryk.libraryrest.converters;

import org.springframework.stereotype.Component;
import pl.krawczykpatryk.libraryrest.dtos.BookDto;
import pl.krawczykpatryk.libraryrest.models.Book;

import java.util.function.Function;

@Component
public class BookDtoConverter implements Function<Book, BookDto> {

    @Override
    public BookDto apply(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pages(book.getPages())
                .dateOfPublication(book.getDateOfPublication())
                .build();
    }
}
