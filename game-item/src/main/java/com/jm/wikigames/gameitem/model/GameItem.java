package com.jm.wikigames.gameitem.model;

import com.jm.wikigames.gameitem.converter.StatusEnumToStringConverter;
import com.jm.wikigames.gameitem.model.enums.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id","name"})
@Builder

public class GameItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @Embedded
    private Inside inside;
    @Embedded
    private Outside outside;

    //private String dateOfCreation;
    //private String genre;
    //private String heroes;
    //private String villains;

    @Convert(converter = StatusEnumToStringConverter.class)
    private Status status;
    private String link;

}
