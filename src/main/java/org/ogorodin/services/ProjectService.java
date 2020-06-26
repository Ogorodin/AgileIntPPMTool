package org.ogorodin.services;

import org.ogorodin.domain.Project;
import org.ogorodin.exceptions.ProjectIdException;
import org.ogorodin.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private IProjectRepository _projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return _projectRepository.save(project);
		}catch(Exception exc) {
			throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists.");
		}
	
	}
	
	public Project findBy_ProjectIdentifier(String projectIdentifier) {
		Project project = _projectRepository.findBy_projectIdentifier(projectIdentifier.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID " + projectIdentifier + " does not exists.");
		}
		
		return project; 
	}
	
	public Iterable<Project> findAllProjects(){
		return _projectRepository.findAll();
	}
	
}
