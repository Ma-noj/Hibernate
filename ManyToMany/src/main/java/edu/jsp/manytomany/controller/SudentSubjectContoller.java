package edu.jsp.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.manytomany.entity.Student;
import edu.jsp.manytomany.entity.Subject;

public class SudentSubjectContoller {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student studnet = entityManager.find(Student.class, 201);

		Subject subject = entityManager.find(Subject.class, 104);

		if (studnet != null) {
			if (subject != null) {
				List<Subject> listOfSubject = studnet.getSubjects();
				if (listOfSubject == null) {
					listOfSubject = new ArrayList<>();
				}
				listOfSubject.add(subject);
				studnet.setSubjects(listOfSubject);
				
				entityTransaction.begin();
				entityManager.merge(studnet);
				entityTransaction.commit();

			} else {
				System.err.println("Subject with the Given Id Not Persent");
			}
		} else {
			System.err.println("Student with the Given Id Not Persent");
		}
	}
}
