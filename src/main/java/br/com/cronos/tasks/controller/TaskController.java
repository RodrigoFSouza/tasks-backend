package br.com.cronos.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cronos.tasks.domain.Task;
import br.com.cronos.tasks.respositories.TaskRepository;
import br.com.cronos.tasks.utils.DateUtils;
import br.com.cronos.tasks.utils.ValidationException;

@RestController
@RequestMapping(value ="/todo")
public class TaskController {

	@Autowired
	private TaskRepository todoRepo;

	@CrossOrigin(origins = "http://localhost:8002")
	@GetMapping
	public List<Task> findAll() {
		return todoRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task todo) throws ValidationException {
		if(todo.getTask() == null || todo.getTask() == "") {
			throw new ValidationException("Task não tem descrição");
		}
		if(todo.getDueDate() == null) {
			throw new ValidationException("Informe uma data");
		}
		if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
			throw new ValidationException("Informe uma atual ou futura");
		}
		Task saved = todoRepo.save(todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
}
