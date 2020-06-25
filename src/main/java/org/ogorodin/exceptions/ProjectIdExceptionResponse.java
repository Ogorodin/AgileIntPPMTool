package org.ogorodin.exceptions;

public class ProjectIdExceptionResponse {

	private String _projectIdentifier;

	public ProjectIdExceptionResponse(String projectIdentifier) {
		this._projectIdentifier = projectIdentifier;
	}

	public String get_projectIdentifier() {
		return _projectIdentifier;
	}

	public void set_projectIdentifier(String projectIdentifier) {
		this._projectIdentifier = projectIdentifier;
	}

}
