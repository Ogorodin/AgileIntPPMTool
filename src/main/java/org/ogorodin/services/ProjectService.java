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
	
}
