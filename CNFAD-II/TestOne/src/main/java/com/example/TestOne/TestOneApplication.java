package com.example.TestOne;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TestOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOneApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
		Scanner sc = new Scanner(System.in);
		Customer c = (Customer) ac.getBean("customer");
		Ticket t = (Ticket) c.getTick();
		while(true) {
			System.out.println("1.Enter Details. \n2.Display Details. \n3.Exit. \nEnter your choice - ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Customer Name : ");
				c.setName(sc.next());
				System.out.println("Enter the Customer Address : ");
				c.setAddress(sc.next());
				System.out.println("Enter the Ticket Number : ");
				t.setTickno(sc.nextInt());
				System.out.println("Enter the Seat Number : ");
				t.setSeatno(sc.nextInt());
				System.out.println("Enter the Ticket Type (Economy/Business) : ");
				t.setTicktype(sc.next());
				c.setTick(t);
				break;
			case 2:
				System.out.println("Customer Name : "+c.getName());
				System.out.println("Customer Address : "+c.getAddress());
				t=c.getTick();
				System.out.println("Ticket Number: "+t.getTickno());
				System.out.println("Seat Number: "+t.getSeatno());
				System.out.println("Ticket Type: "+t.getTicktype());
				break;
			case 3:System.exit(0);
			default:System.out.print("Invalid Choice");
			}
		}
	}

}
