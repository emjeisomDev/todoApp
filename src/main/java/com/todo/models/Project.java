package com.todo.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private String responsable;
	private String status;
	private Instant createdAt;
	private Instant updatedAt;

	public Project() {
	}

	public Project(Long id, String title, String description, String responsable, String status, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.responsable = responsable;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Project [id: " + id + ", title: " + title + ", description: " + description + ", responsable: "
				+ responsable + ", status: " + status + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "]";
	}

}