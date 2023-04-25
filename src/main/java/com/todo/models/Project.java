package com.todo.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.todo.models.enums.Status;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String description;
	private String responsable;
	private Integer projectStatus;
	private Instant createdAt;
	private Instant updatedAt;
	private List<Task> tasks = new ArrayList<>();

	public Project() {
	}

	public Project(Integer id, String title, String description, String responsable, Status projectStatus, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.responsable = responsable;
		setProjectStatus(projectStatus);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Status getProjectStatus() {
		return Status.valueOf(projectStatus);
	}

	public void setProjectStatus(Status projectStatus) {
		if(projectStatus != null) {
			this.projectStatus = projectStatus.getCode();
		}
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(id, other.id);
	}


}