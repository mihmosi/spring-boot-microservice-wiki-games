package com.jm.wikigames.generalitem.model.characters;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Character {
	@Id
	@Setter(value = AccessLevel.NONE)
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
