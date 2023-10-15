package com.example.service;

import java.util.List;

import com.example.entity.Student;
public interface StudentService {

	// Save operation
	Student saveStudent(Student student);

	// Read operation
	List<Student> fetchStudentList();

	// Read operation by id
	Student fetchStudentListById(Student student, Long id);

	//Copy
	
	// Update operation
	Student updateStudent(Student student, Long id);

	// Delete operation
	void deleteStudentById(Long studentId);
	
}
