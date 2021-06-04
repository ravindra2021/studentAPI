package com.studentproject.student.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {
	







	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email; 
	private String password;
	
	
	
	
	public Student() {}

	public Student(String username, String firstname, String lastname, String email, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + "]";
	}
		
	

}
