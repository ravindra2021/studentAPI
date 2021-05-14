package com.studentproject.student.demo;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(path ="/students")
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping(path ="/student")
	public Optional<Student> getAllStudents(@RequestParam String name) {
		return studentService.getStudent(name);
	}
	//post new student
	@PostMapping(path = "/addstudent")
	public void registerNewStudent(@RequestBody Student student) {
		 studentService.addNewStudent(student);
	}
	//update student
	@PutMapping(path ="/updatestudent")
	public void updateStudent(@RequestBody Student student) {
		 studentService.updateStudent(student);
	}
	
	//delete student
	@DeleteMapping(path="/deletestudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		return studentService.deleteStudent(id);
	}
}
