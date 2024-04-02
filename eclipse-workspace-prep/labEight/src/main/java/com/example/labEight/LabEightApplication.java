package com.example.labEight;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.core.net.ssl.SSL;

@SpringBootApplication
public class LabEightApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(LabEightApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        int ch;
        String name;
        int marks;
		StudentService studentService= context.getBean(StudentService.class);
		while(true) { 
			System.out.println("MENU\n1.Enter name\n2.Display table\n3.Exit");
			
			switch (scanner.nextInt()) {
			case 1: {
				System.out.println("Enter Student name:");
				name=scanner.next();
				System.out.println("Enter Marks");
				marks=scanner.nextInt();
				studentService.insertMessage(name,marks);
break;
			}
				
		
case 2: {
	List<Student> cl = studentService.displayMessage();
	
	for(Student m: cl) {
		System.out.println(m.getName()+"--"+m.getTotalmarks());
	}
	break;
				
			}
case 3: {
	System.exit(0);
}
		
	}
		}
	
}
}
