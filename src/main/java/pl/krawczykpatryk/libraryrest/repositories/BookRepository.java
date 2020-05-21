package pl.krawczykpatryk.libraryrest.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.krawczykpatryk.libraryrest.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("Select b from Book b")
    List<Book> findAllBooks(PageRequest pageRequest);
}