package edu.alpha.ems.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import edu.alpha.ems.dao.ProjectDao;
import edu.alpha.ems.entity.Project;
import edu.alpha.ems.exception.ProjectNotFoundException;
import edu.alpha.ems.util.EntityManagerUtil;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public Project saveProject(Project project) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(project);
		entityTransaction.commit();
		return project;
	}

	@Override
	public Project findProjectById(int projectId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		Project project = entityManager.find(Project.class, projectId);
		return project;
	}

	@Override
	public Project updateProject(Project project) {
		if (project.getProjectId() != 0) {
			Project exstingProject = findProjectById(project.getProjectId());
			if (exstingProject != null) {
				EntityManager entityManager = EntityManagerUtil.getEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.merge(project);
				entityTransaction.commit();
				return project;
			}
			throw new ProjectNotFoundException("Project with the Given Id " + project.getProjectId() + " Not Found");
		}
		throw new ProjectNotFoundException("Project with the Given Id " + project.getProjectId() + " Not Found");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Project> findAll() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		String jpqlQuery = "SELECT p From Project p";
		Query query = entityManager.createQuery(jpqlQuery);

		List listOfProject = query.getResultList();
		return listOfProject;
	}

	@Override
	public boolean deleteById(int projectId) {
		Project project = findProjectById(projectId);
		if (project != null) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(project);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
