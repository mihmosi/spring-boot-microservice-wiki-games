package com.jm.wikigames.generalitem.model;


import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Inside {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "protagonist_id")
    private Protagonist protagonist;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "antagonist_id")
    private Antagonist antagonist;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "linorСharacter_id")
    private List<MinorСharacter> minorСharacters;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "lore_id")
    private Lore lore;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
