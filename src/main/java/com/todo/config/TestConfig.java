package com.todo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todo.models.Project;
import com.todo.models.Task;
import com.todo.models.enums.Status;
import com.todo.repositories.ProjectRepository;
import com.todo.repositories.TaskRepository;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {

		Project proj1 = new Project(null, "Subir de nivel no inglês", "Usar métodos para poder avançar no listenind e no speaking.", "Emanuel", Status.STARTED, Instant.parse("2023-03-15T17:36:21Z"), Instant.parse("2023-03-15T17:36:21Z"));
		Project proj2 = new Project(null, "Atualizar sistema de dimensionamento fotovoltaico.","Atualizar todo o sistema de dimensionamento fotovoltaico em um sistema WEB, com as mesmas funcionalidades que temos hoje no Excel.","Emanuel",Status.ASSIGNED, Instant.parse("2023-03-15T17:50:01Z"), Instant.parse("2023-03-15T17:50:01Z"));

		projectRepository.saveAll(Arrays.asList(proj1, proj2));

		Task tk1 = new Task(null, "Cambly", "Participar das aulas de conversação em grupo em grupo","Emanuel", Status.RECEIVED, Instant.parse("2023-03-15T17:39:29Z"), Instant.parse("2023-03-15T17:39:29Z"), proj1);
		Task tk2 = new Task(null, "Netflix","Assistir série em inglês com as legendas em inglês.","Emanuel", Status.STARTED, Instant.parse("2023-03-15T17:39:29Z"), Instant.parse("2023-03-15T17:39:29Z"), proj1);
		Task tk3 = new Task(null, "Spotfy","Ouvir pocasts de cusiosidades em inglês","Emanuel", Status.ASSIGNED, Instant.parse("2023-03-15T17:39:29Z"), Instant.parse("2023-03-15T17:39:29Z"), proj1);
		Task tk4 = new Task(null, "Lei 14.300","Buscar maior entendimento sobre a regulamentação e listar os principais pontos da nova lei","Emanuel", Status.ASSIGNED, Instant.parse("2023-03-15T17:52:48Z"), Instant.parse("2023-03-15T17:52:48Z"), proj2);
		Task tk5 = new Task(null, "Payback","Fazer o novo cálculo do payback levando em consideração a tarifação do Fio B","Emanuel", Status.ASSIGNED, Instant.parse("2023-03-15T17:52:48Z"), Instant.parse("2023-03-15T17:52:48Z"), proj2);

		taskRepository.saveAll(Arrays.asList(tk1, tk2, tk3, tk4, tk5));

	}	
}