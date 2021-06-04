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
public Optional<Student> getStudent(String username){
	Optional<Student> studentByUserName= studentRepository.findStudentByUsername(username); 
	
	return studentByUserName;	

}

public void addNewStudent(Student student) {
	Optional<Student> studentByUsername= studentRepository.findStudentByUsername(student.getUsername()); 
	if(studentByUsername.isPresent()) {
		throw new IllegalStateException("username already exists, please try using another username");
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
public String verifyLogin(Student student) {
	try {
		
	Optional<Student> studentByUsername= studentRepository.findStudentByUsername(student.getUsername()); 
	Student stu=studentByUsername.get();
	
		if(student.getPassword().equals(stu.getPassword())) {
		return "Login successfull";
		}
		else {
			throw new IllegalStateException("invalid password! please try again");		
	}	
	}
	catch(IllegalStateException exp){
		throw exp;
         }
	
	catch(Exception exp){
		throw new IllegalStateException("username does not exist, please try again with valid credentials");
         }
	
	
	
}
}
