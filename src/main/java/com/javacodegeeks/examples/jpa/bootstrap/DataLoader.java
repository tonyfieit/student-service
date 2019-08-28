package com.javacodegeeks.examples.jpa.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javacodegeeks.examples.jpa.model.Student;
import com.javacodegeeks.examples.jpa.repository.StudentRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final StudentRepository repository;
	
	
	public DataLoader(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Student student_a = new Student();
		student_a.setFirstName("Jane");
		student_a.setLastName("Doe");
		student_a.setYear("Junior");
		repository.save(student_a);
		
		Student student_b = new Student();
		student_b.setFirstName("Martin");
		student_b.setLastName("Fowler");
		student_b.setYear("Senior");
		repository.save(student_b);
		
		Student student_c = new Student();
		student_c.setFirstName("Roy");
		student_c.setLastName("Fielding");
		student_c.setYear("Freshman");
		repository.save(student_c);
	}

}
