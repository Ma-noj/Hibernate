package edu.alpha.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.manytoone.entity.Product;
import edu.alpha.manytoone.entity.Review;

public class ProductReviewController {

	public static void main(String[] args) {
		Product product = new Product();
		product.setId(101);
		product.setName("LapTop");
		product.setCost(34765.00);

		Review review1 = new Review();
		review1.setId(201);
		review1.setUserName("Raju");
		review1.setDescription("Good Product!!!");
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setId(202);
		review2.setUserName("Rani");
		review2.setDescription("Good Product and Best Qulity!!!");
		review2.setProduct(product);

		Review review3 = new Review();
		review3.setId(203);
		review3.setUserName("Prithi");
		review3.setDescription("Good Product!!!");
		review3.setProduct(product);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityManager.persist(review3);
		entityTransaction.commit();
	}

}
