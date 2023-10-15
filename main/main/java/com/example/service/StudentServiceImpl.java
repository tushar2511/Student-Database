package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
//Class implementing StudentService class
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository StudentRepository;

	// Save operation
	@Override
	public Student saveStudent(Student Student)
	{
		return StudentRepository.save(Student);
	}

	// Read operation
	@Override public List<Student> fetchStudentList()
	{
		return (List<Student>)StudentRepository.findAll();
	}
	
	// Read operation by id
	@Override public Student fetchStudentListById(Student Student, Long StudentId)
	{
		Student depDB = StudentRepository.findById(StudentId).get();
		return StudentRepository.save(depDB);
	}

	// Update operation
	@Override
	public Student
	updateStudent(Student Student, Long StudentId)
	{

		Student depDB = StudentRepository.findById(StudentId).get();

		if (Objects.nonNull(Student.getName()) && !"".equalsIgnoreCase(Student.getName())) {
			depDB.setName(Student.getName());
		}

		if (Objects.nonNull(Student.getAddress())&& !"".equalsIgnoreCase(Student.getAddress())) {
			depDB.setAddress(Student.getAddress());
		}
		
		if (Objects.nonNull(Student.getSubject())&& !"".equalsIgnoreCase(Student.getSubject())) {
			depDB.setSubject(Student.getSubject());
		}
		
		if (Objects.nonNull(Student.getMobilePhone())&& !"".equalsIgnoreCase(Student.getMobilePhone())) {
			depDB.setMobilePhone(Student.getMobilePhone());
		}
		
		return StudentRepository.save(depDB);
	}

	// Delete operation
	@Override
	public void deleteStudentById(Long StudentId)
	{
		StudentRepository.deleteById(StudentId);
	}
}
