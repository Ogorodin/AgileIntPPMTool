package org.ogorodin.repositories;

import org.ogorodin.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {
	
	Project findBy_projectIdentifier(String projectIdentifier);
	

}
