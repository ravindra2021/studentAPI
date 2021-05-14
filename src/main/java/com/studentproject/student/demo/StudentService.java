package com.studentproject.student.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
public List<Student> getStudents(){
	return studentRepository.findAll();
}
public Optional<Student> getStudent(String name){
	Optional<Student> studentByName= studentRepository.findStudentByName(name); 
	
	return studentByName;	

}

public void addNewStudent(Student student) {
	Optional<Student> studentByEmail= studentRepository.findStudentByEmail(student.getEmail()); 
	if(studentByEmail.isPresent()) {
		throw new IllegalStateException("email is taken, please try using another email");
	}
	else studentRepository.save(student);

}
public void updateStudent(Student student) {
	Optional<Student> studentById= studentRepository.findById(student.getId());
	if(!studentById.isPresent()) {
		throw new IllegalStateException("student does not exist");
	}
	else studentRepository.save(student);
}
public String deleteStudent(Long id) {
	Optional<Student> studentById= studentRepository.findById(id);
	if(!studentById.isPresent()) {
		throw new IllegalStateException("student-id does not exist");
		
	}
	else {
		studentRepository.deleteById(id);
		return "deleted succesfully";}
    
	
}
}
