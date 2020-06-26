package org.ogorodin.web;

import javax.validation.Valid;

import org.ogorodin.domain.Project;
import org.ogorodin.services.MapValidationErrorService;
import org.ogorodin.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService _projectService;

	@Autowired
	private MapValidationErrorService _mapValidationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

		ResponseEntity<?> errorMap = _mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		_projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectIdentifier}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier ){
		Project project = _projectService.findBy_ProjectIdentifier(projectIdentifier);
		
		return new ResponseEntity<Project>(project, HttpStatus.OK);
		
	}

}
