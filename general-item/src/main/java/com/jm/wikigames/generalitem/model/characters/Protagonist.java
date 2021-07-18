package com.jm.wikigames.generalitem.model.characters;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "protagonists")
@NoArgsConstructor
public class Protagonist extends Character {

}
