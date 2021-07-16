package com.jm.wikigames.generalitem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Antagonist {
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

	public Antagonist() {}

	public Antagonist(String name, String sex, String race, String faction) {
		this.name = name;
		this.sex = sex;
		this.race = race;
		this.faction = faction;
	}
	
	
	
}
