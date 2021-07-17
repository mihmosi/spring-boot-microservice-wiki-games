package com.jm.wikigames.generalitem.model.characters;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Character {
	@Id
	long id;

	@Column(name = "name")
	String name;

	@Column(name = "sex")
	String sex;

	@Column(name = "race")
	String race;

	@Column(name = "faction")
	String faction;

}
