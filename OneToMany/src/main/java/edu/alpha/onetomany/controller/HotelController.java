package edu.alpha.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.onetomany.entity.Hotel;
import edu.alpha.onetomany.entity.Room;

public class HotelController {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.setId(101);
		hotel.setName("Asoka");
		hotel.setLocation("Bangalore");

		Room room1 = new Room();
		room1.setId(201);
		room1.setNumberOfBed(3);
		room1.setType("Ac");

		Room room2 = new Room();
		room2.setId(202);
		room2.setNumberOfBed(2);
		room2.setType("Non-Ac");

		Room room3 = new Room();
		room3.setId(203);
		room3.setNumberOfBed(4);
		room3.setType("Ac");

		List<Room> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);

		hotel.setRooms(rooms);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(room1);
		entityManager.persist(room2);
		entityManager.persist(room3);
		entityManager.persist(hotel);
		entityTransaction.commit();
	}
}
