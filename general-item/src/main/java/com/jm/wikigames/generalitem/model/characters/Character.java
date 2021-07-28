package com.jm.wikigames.generalitem.model.characters;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@MappedSuperclass
@Entity
// TODO: Сделать создающуюся таблицу Character
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private StatusCharacter status;
//    private String sex;
//    private String race;
//    private String faction;

}
