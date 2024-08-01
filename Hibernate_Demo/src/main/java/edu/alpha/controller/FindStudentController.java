package edu.alpha.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.alpha.entity.Student;

public class FindStudentController {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alpha");
		EntityManager em = emf.createEntityManager();

		Student obj = em.find(Student.class, 101);
		
		System.out.println("Student Id = " + obj.getId());
		System.out.println("Student Name = " + obj.getName());
		System.out.println("Student Age = " + obj.getAge());

	}

}
