package edu.alpha.onetomany.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	private int id;
	private String type;
	private int numberOfBed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfBed() {
		return numberOfBed;
	}

	public void setNumberOfBed(int numberOfBed) {
		this.numberOfBed = numberOfBed;
	}

}
