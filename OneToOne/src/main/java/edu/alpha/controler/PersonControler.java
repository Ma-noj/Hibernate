package edu.alpha.controler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.entity.PanDetalies;
import edu.alpha.entity.Person;

public class PersonControler {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = new Person();
		person.setPersonId(101);
		person.setPersonName("Ram");
		person.setPersonAge(25);
		person.setPhoneNumber(87654278191l);

		PanDetalies pan = new PanDetalies();
		pan.setPanId(201);
		pan.setPanNumber("GTFDJ6756G");
		pan.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(pan);
		entityTransaction.commit();

	}
}
