package com.example.TestTwo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TestTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTwoApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
		Scanner sc = new Scanner(System.in);
		Department dt = (Department) ac.getBean("department");
		while(true) {
			System.out.println("1.Enter Details. \n2.Display Details. \n3.Exit. \nEnter your choice - ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Department name : ");
				dt.setName(sc.next());
				System.out.println("Enter the Department Id : ");
				dt.setId(sc.nextInt());
				System.out.println("Enter the Department Description : ");
				dt.setDescription(sc.next());
				break;
			case 2:
				College c = dt.getCollege();
				System.out.println("College Name : "+c.getName());
				System.out.println("College Address : "+c.getAddress());
				System.out.println("Department ID : "+dt.getId());
				System.out.println("Department Name : "+dt.getName());
				System.out.println("Department Desciption : "+dt.getDescription());
				break;
			case 3:System.exit(0);
			default : System.out.println("Invalid choice");
			}
		}
	}

}
