package pl.krawczykpatryk.libraryrest.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private LocalDate dateOfPublication;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bookId", updatable = false)
    private List<Comment> comment;
}