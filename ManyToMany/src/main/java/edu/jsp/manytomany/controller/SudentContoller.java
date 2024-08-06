package edu.jsp.manytomany.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.manytomany.entity.Student;
import edu.jsp.manytomany.entity.Subject;

public class SudentContoller {

	public static void main(String[] args) {
		Subject subject1 = new Subject();
		subject1.setSubjectId(101);
		subject1.setSubjectName("Java");
		subject1.setNumberOfDays(60);

		Subject subject2 = new Subject();
		subject2.setSubjectId(102);
		subject2.setSubjectName("Hibernate");
		subject2.setNumberOfDays(15);

		Subject subject3 = new Subject();
		subject3.setSubjectId(103);
		subject3.setSubjectName("JS");
		subject3.setNumberOfDays(15);

		Subject subject4 = new Subject();
		subject4.setSubjectId(104);
		subject4.setSubjectName("HTML");
		subject4.setNumberOfDays(10);

		List<Subject> listSubjects1 = new ArrayList<>();
		listSubjects1.add(subject1);
		listSubjects1.add(subject2);

		List<Subject> listSubjects2 = Arrays.asList(subject1, subject3);

		List<Subject> listSubjects3 = Arrays.asList(subject2, subject3);

		List<Subject> listSubjects4 = Arrays.asList(subject1, subject2, subject3, subject4);

		Student student1 = new Student();
		student1.setStudentId(201);
		student1.setName("Raju");
		student1.setEmail("raju@abc.in");
		student1.setSubjects(listSubjects1);

		Student student2 = new Student();
		student2.setStudentId(202);
		student2.setName("Rani");
		student2.setEmail("rani@abc.in");
		student2.setSubjects(listSubjects2);

		Student student3 = new Student();
		student3.setStudentId(203);
		student3.setName("Prithi");
		student3.setEmail("prithi@abc.in");
		student3.setSubjects(listSubjects3);

		Student student4 = new Student();
		student4.setStudentId(204);
		student4.setName("Neha");
		student4.setEmail("neha@abc.in");
		student4.setSubjects(listSubjects4);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		/*
		 * entityTransaction.begin(); entityManager.persist(subject1);
		 * entityManager.persist(subject2); entityManager.persist(subject3);
		 * entityManager.persist(student1); entityManager.persist(student2);
		 * entityManager.persist(student3); entityTransaction.commit();
		 */

		entityTransaction.begin();
		entityManager.persist(subject4);
		entityManager.persist(student4);
		entityTransaction.commit();

	}

}
