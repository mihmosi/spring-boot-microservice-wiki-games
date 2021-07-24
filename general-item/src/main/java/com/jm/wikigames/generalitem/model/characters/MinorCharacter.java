package com.jm.wikigames.generalitem.model.characters;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "minorCharacters")
@NoArgsConstructor
public class MinorCharacter extends Character{
}
