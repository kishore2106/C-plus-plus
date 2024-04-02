package com.example.labEight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	void insertMessage(String name,int marks) {
	Student m = new Student();
		m.setName(name);
		m.setTotalmarks(marks);
		studentRepository.save(m);
	}
	
	List<Student> displayMessage(){
		return studentRepository.findAll();
	}
}

