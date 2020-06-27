package org.ogorodin.exceptions;

public class ProjectIdExceptionResponse {

	private String _projectIdentifier;

	public ProjectIdExceptionResponse(String projectIdentifier) {
		this._projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return _projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this._projectIdentifier = projectIdentifier;
	}

}
