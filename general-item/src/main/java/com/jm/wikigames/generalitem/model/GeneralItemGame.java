package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.converter.GenreEnumToStringConverter;
import com.jm.wikigames.generalitem.converter.StatusEnumToStringConverter;
import com.jm.wikigames.generalitem.model.enums.Genre;
import com.jm.wikigames.generalitem.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","name"})
public class GeneralItemGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    private LocalDate dateOfCreation;

    @Convert(converter = GenreEnumToStringConverter.class)
    private Genre genre;
    private String heroes;
    private String villains;

    @Convert(converter = StatusEnumToStringConverter.class)
    private Status status;

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = LocalDate.parse(dateOfCreation);
    }

    public void setGenre(String genre) {
        this.genre = Genre.valueOf(genre.trim().replace(" ", "_").toUpperCase());
    }
}