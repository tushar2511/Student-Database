package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Student;
import com.example.service.StudentService;

//@Controller
@RestController
@RequestMapping("/index")
public class StudentController {

	@Autowired
	private StudentService StudentService;

	// Save operation

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("list", StudentService.fetchStudentList());
		return model;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView deleteUsers(@PathVariable long id) {
		StudentService.deleteStudentById(id);
		return new ModelAndView("redirect:/index");
	}


	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView StudentRegister(@ModelAttribute("Student")Student Student){
		ModelAndView model = new ModelAndView("index");
		if(Student!=null){
			StudentService.saveStudent(Student);
			model.addObject("warning", "User Registration Success");

		}
		else{
			model.addObject("danger","Something Going Bad" );

		}
		return new ModelAndView("redirect:/index");
	}
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") @RequestBody Student student, long id) {
		ModelAndView model = new ModelAndView("edit");
		Student Student = StudentService.fetchStudentListById(student, id);
		model.addObject("Student", Student);
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("id") @RequestBody Student student, long id,
			@RequestParam("name") String name,@RequestParam("subject") String subject,
			@RequestParam("address") String address, @RequestParam("mobilePhone") String mobilePhone) {
		Student Student = StudentService.fetchStudentListById(student, id);
		Student.setName(name);
		Student.setSubject(subject);
		Student.setAddress(address);
		Student.setMobilePhone(mobilePhone);
		StudentService.saveStudent(student);
		return new ModelAndView("redirect:/index");
	}




	//	 copy
	//	 @PostMapping("/Students")
	//
	//	 public Student saveStudent(@Valid @RequestBody Student student)
	//	 {
	//	     return StudentService.saveStudent(student);
	//	 }

	//	 // Read operation
	//	 @GetMapping("/Students")
	//
	//	 public List<Student> fetchStudentList()
	//	 {
	//	     return StudentService.fetchStudentList();
	//	 }
	//	 
	//	// Read operation by id
	//	 @GetMapping("/Students/{id}")
	//	 public ResponseEntity<?> fetchStudentListById(@RequestBody Student student, @PathVariable Long id)
	//	 {
	//		 Student studret=StudentService.fetchStudentListById(student, id);
	//		 return new ResponseEntity<Student>(studret, HttpStatus.OK);
	//	 }	 
	//
	//	 // Update operation
	//	 @PutMapping("/Students/{id}")
	//	 public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable Long id)
	//	 {
	//	    StudentService.updateStudent(student, id);
	//	    return new ResponseEntity<String>("Updated Successfully",HttpStatus.ACCEPTED);
	//	 }
	//
	//	 // Delete operation
	//	 @DeleteMapping("/Students/{id}")
	//
	//	 public ResponseEntity<String> deleteStudentById(@PathVariable Long id)
	//	 {
	//		 StudentService.deleteStudentById(id);
	//		 return new ResponseEntity<String>("Deleted Successfully",HttpStatus.ACCEPTED);
	//	 }

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}

}