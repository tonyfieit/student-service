package com.javacodegeeks.examples.jpa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.examples.jpa.exceptions.StudentNotFoundException;
import com.javacodegeeks.examples.jpa.model.Student;
import com.javacodegeeks.examples.jpa.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {

	private final StudentRepository repository;

	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<Student> getStudents() {
		return repository.findAll();
	}	

	@GetMapping("{id}")
	public Student getStudent(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(StudentNotFoundException::new);
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@PutMapping("{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);

		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setYear(student.getYear());

		return repository.save(studentToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.deleteById(id);
	}
}
