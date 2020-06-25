package org.ogorodin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long _id;

	@Column(name = "projectName")
	@NotBlank(message = "Project name is required")
	private String _projectName;

	@Column(name = "projectIdentifier", updatable = false, unique = true)
	@NotBlank(message = "Project identifier is required")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
	private String _projectIdentifier;

	@Column(name = "description")
	@NotBlank(message = "Project description is required")
	private String _description;

	@Column(name = "startDate")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date _startDate;

	@Column(name = "endDate")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date _endDate;

	@Column(name = "createdAt")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date _createdAt;

	@Column(name = "updatedAt")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date _updatedAt;

	public Project() {
	}

	public Long getId() {
		return _id;
	}

	public void setId(Long id) {
		this._id = id;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		this._projectName = projectName;
	}

	public String getProjectIdentifier() {
		return _projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this._projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		this._startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		this._endDate = endDate;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this._createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this._updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this._createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this._updatedAt = new Date();
	}

}
