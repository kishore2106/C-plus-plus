package com.example.LabSeven;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	void insertMessage(String name, int marks) {
		Student m = new Student();
		m.setName(name);
		m.setTotalmarks(marks);
		studentRepository.save(m);
	}
	
	List<Student> displayMessage(){
		return studentRepository.findAll();
	}
	
	void updateMessage(Long id, int marks) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			Student student = s.get();
			student.setTotalmarks(marks);
			studentRepository.save(student);
		}else {
			System.out.println("No such record");
		}
		
	}
}
