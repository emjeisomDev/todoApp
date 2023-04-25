package com.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
