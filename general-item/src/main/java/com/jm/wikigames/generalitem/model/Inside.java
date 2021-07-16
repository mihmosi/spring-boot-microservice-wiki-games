package com.jm.wikigames.generalitem.model;


import com.jm.wikigames.generalitem.model.enums.Genre;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "inside")
public class Inside {

    public Inside(List<Protagonist> protagonists, List<Antagonist> antagonists, List<MinorСharacters> minorСharacters, List<Lore> lore, String originalSourse, Genre genre) {
        this.protagonists = protagonists;
        this.antagonists = antagonists;
        this.minorСharacters = minorСharacters;
        this.lore = lore;
        this.originalSourse = originalSourse;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "protagonists")
    @OneToMany(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "protagonist_id")
    private List<Protagonist> protagonists;

    @Column(name = "antagonist")
    @OneToMany(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "antagonist_id")
    private List<Antagonist> antagonists;

    @Column(name = "minorСharacter")
    @OneToMany(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "minorСharacter_id")
    private List<MinorСharacters> minorСharacters;

    @Column(name = "lore")
    @OneToMany(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "lore_id")
    private List<Lore> lore;

    @Column(name = "originalSourse")
    private String originalSourse;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
