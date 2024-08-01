package edu.alpha.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PanDetalies {
	@Id
	private int panId;
	private String panNumber;
	@OneToOne
	private Person person;

	public int getPanId() {
		return panId;
	}

	public void setPanId(int panId) {
		this.panId = panId;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
