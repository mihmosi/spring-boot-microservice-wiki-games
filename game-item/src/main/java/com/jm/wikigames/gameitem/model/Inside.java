package com.jm.wikigames.gameitem.model;


import com.jm.wikigames.gameitem.model.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Inside {

    private List<Character> characters;

    private String lore;

    private String originalSource;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}

