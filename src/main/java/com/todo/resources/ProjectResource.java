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

import com.todo.models.Project;
import com.todo.services.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

	@Autowired
	private ProjectService service;

	@GetMapping
	public ResponseEntity<List<Project>> findAll(){
		List<Project> projects = service.findAll();
		return ResponseEntity.ok().body(projects);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Project> findById(@PathVariable Integer id){
		Project project = service.findById(id);
		return ResponseEntity.ok().body(project);
	}

	@PostMapping
	public ResponseEntity<Project> insert(@RequestBody Project obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Project> update(@PathVariable Integer id, @RequestBody Project obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}



}