package pl.krawczykpatryk.libraryrest.dtos;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private LocalDate dateOfPublication;
}
