package com.jm.wikigames.generalitem.model.characters;

import javax.persistence.Entity;

@Entity
public class Protagonist extends Character {

	public Protagonist() {
	}

	public Protagonist(String name, String sex, String race, String faction) {
		this.name = name;
		this.sex = sex;
		this.race = race;
		this.faction = faction;
	}

}
