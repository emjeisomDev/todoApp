package com.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.models.Project;
import com.todo.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public List<Project> findAll(){
		return repository.findAll();
	}

	public Project findById(Integer id) {
		Optional<Project> obj = repository.findById(id);
		return obj.orElseThrow(null);
	}

	public Project insert(Project obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Project update(Integer id, Project obj) {
		Project entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Project entity, Project obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setResponsable(obj.getResponsable());
		entity.setProjectStatus(obj.getProjectStatus());
		entity.setUpdatedAt(obj.getUpdatedAt());
	}

}