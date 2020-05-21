package pl.krawczykpatryk.libraryrest.converters;

import org.springframework.stereotype.Component;
import pl.krawczykpatryk.libraryrest.dtos.BookDto;
import pl.krawczykpatryk.libraryrest.models.Book;

import java.util.Collections;
import java.util.function.Function;

@Component
public class BookConverter implements Function<BookDto, Book> {

    @Override
    public Book apply(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pages(bookDto.getPages())
                .dateOfPublication(bookDto.getDateOfPublication())
                .comment(Collections.emptyList())
                .build();
    }
}