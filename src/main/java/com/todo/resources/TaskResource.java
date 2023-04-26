package com.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todo.models.Task;
import com.todo.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService service;

	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		List<Task> tasks = service.findAll();
		return ResponseEntity.ok().body(tasks);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findById(@PathVariable Integer id){
		Task task = service.findById(id);
		return ResponseEntity.ok().body(task);
	}

	@PostMapping
	public ResponseEntity<Task> insert(@RequestBody Task obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> update(@PathVariable Integer id, @RequestBody Task obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}