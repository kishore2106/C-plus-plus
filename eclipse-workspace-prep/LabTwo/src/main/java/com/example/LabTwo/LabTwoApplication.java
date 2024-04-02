package com.example.LabTwo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LabTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabTwoApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
		Department dt = (Department)ac.getBean("department");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. insert the Department details\n"+"2. Display Department with College details \n"+ "3. exit");
			System.out.println("enter the choice");
			int a = sc.nextInt();
			switch(a) {
			case 1:
				System.out.println("enter the Department name");
		
				dt.setName(sc.next());
				System.out.println("enter the Department no");
				dt.setId(sc.nextInt());
				System.out.println("enter the Department Decription");
				dt.setDescription(sc.next());
				System.out.println("thanks for input");
				break;
	
			case 2:
				System.out.println("Department Details:");
				System.out.println("Name:"+dt.getName()+" "+"ID:"+dt.getId()+
				" Department Description"+dt.getDescription());
				System.out.println("College Details");
				College c = dt.getCollege();
				System.out.println("College Name: "+c.getName());
				System.out.println("College Address: "+c.getAddress());
				break;
			
			case 3:
				System.exit(0);
		}
		}
	}

}
