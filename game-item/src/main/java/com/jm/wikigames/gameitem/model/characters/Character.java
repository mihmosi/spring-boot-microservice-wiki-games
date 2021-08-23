package com.jm.wikigames.gameitem.model.characters;

import com.jm.wikigames.gameitem.model.enums.CharacterStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CharacterStatus status;
    private String sex;
    private String race;
    private String faction;

}
