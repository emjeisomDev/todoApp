package com.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todo.models.Project;
import com.todo.repositories.ProjectRepository;
import com.todo.services.exceptions.DatabaseException;
import com.todo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Project update(Integer id, Project obj) {
		try {
			Project entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Project entity, Project obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setResponsable(obj.getResponsable());
		entity.setProjectStatus(obj.getProjectStatus());
		entity.setUpdatedAt(obj.getUpdatedAt());
	}

}