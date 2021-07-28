package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.model.characters.Character;
import com.jm.wikigames.generalitem.model.enums.InsideGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Inside {
    @Transient
    private List<Character> characters;
    @Column(table = "game_item")
    private String lore;
    @Transient
    private String originalSource;
    @Transient
    private List<InsideGenre> genre;
}
