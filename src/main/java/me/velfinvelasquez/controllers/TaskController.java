package me.velfinvelasquez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.velfinvelasquez.models.Tarea;
import me.velfinvelasquez.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping()
	List<Tarea> getAll() {
		return taskRepository.findAll();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	Tarea create(@RequestBody Tarea tarea) {
		return taskRepository.save(tarea);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	Tarea edit(@PathVariable String id, @RequestBody Tarea tarea) {
		Tarea tareaDb = taskRepository.findById(id).orElseThrow(RuntimeException::new);

		tareaDb.setName(tarea.getName());
		tareaDb.setCompleted(tarea.getCompleted());

		return taskRepository.save(tareaDb);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteById(@PathVariable String id) {
		Tarea tareaDb = taskRepository.findById(id).orElseThrow(RuntimeException::new);
		taskRepository.delete(tareaDb);
	}

}
