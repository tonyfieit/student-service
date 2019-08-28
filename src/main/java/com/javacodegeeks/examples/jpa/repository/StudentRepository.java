package com.javacodegeeks.examples.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.javacodegeeks.examples.jpa.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
