package pl.krawczykpatryk.libraryrest.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Product with id " + id + " was not found");
    }
}
