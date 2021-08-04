package com.jm.wikigames.generalitem.model;


import com.jm.wikigames.generalitem.model.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inside {

    private List<Character> characters;

    private String lore;

    private String originalSourse;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}

