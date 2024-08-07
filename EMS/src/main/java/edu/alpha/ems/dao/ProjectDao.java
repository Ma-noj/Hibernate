package edu.alpha.ems.dao;

import java.util.List;

import edu.alpha.ems.entity.Project;

public interface ProjectDao {

	Project saveProject(Project project);

	Project findProjectById(int projectId);

	Project updateProject(Project project);

	List<Project> findAll();

	boolean deleteById(int projectId);
}
