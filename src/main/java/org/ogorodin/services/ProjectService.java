package org.ogorodin.services;

import org.ogorodin.domain.Project;
import org.ogorodin.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private IProjectRepository _projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		return _projectRepository.save(project);
	}
	
}
