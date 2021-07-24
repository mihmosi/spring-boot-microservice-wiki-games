package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.model.characters.Antagonist;
import com.jm.wikigames.generalitem.model.characters.MinorCharacter;
import com.jm.wikigames.generalitem.model.characters.Protagonist;
import com.jm.wikigames.generalitem.model.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "inside")
public class Inside {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "protagonists")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Protagonist> protagonists;

    @Column(name = "antagonist")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Antagonist> antagonists;

    @Column(name = "minorСharacter")
    @OneToMany(fetch = FetchType.LAZY)
    private List<MinorCharacter> minorСharacters;

    @Column(name = "lore")
    private String lore;

    @Column(name = "originalSourse")
    private String originalSourse;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
