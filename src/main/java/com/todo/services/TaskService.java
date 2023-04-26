package com.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.models.Task;
import com.todo.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public List<Task> findAll(){
		return repository.findAll();
	}

	public Task findById(Integer id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow(null);
	}

	public Task insert(Task obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Task update(Integer id, Task obj) {
		Task entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Task entity, Task obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setResponsable(obj.getResponsable());
		entity.setTaskStatus(obj.getTaskStatus());
		entity.setUpdatedAt(obj.getUpdatedAt());
	}

}