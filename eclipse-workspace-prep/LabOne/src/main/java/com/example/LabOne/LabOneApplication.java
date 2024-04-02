package com.example.LabOne;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LabOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabOneApplication.class, args);
		Scanner sc = new Scanner(System.in);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
		Customer c = (Customer) ac.getBean("customer");
		Ticket t = (Ticket) c.getTick();
		while(true) {
			System.out.println("1.Enter Data. \n2.Display Data.\n3.Exit.");
			System.out.println("Enter your choice - ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter the Customer name - ");
					c.setName(sc.next());
					System.out.println("Enter the Customer Address - ");
					c.setAddress(sc.next());
					System.out.println("enter the ticket number");
					t.setTicno(sc.nextInt());
					System.out.println("enter the ticket seat no");
					t.setSeatno(sc.nextInt());
					System.out.println("enter the ticket price");
					t.setPrice(sc.nextInt());
					System.out.println("enter the ticket Type - economic/gold/platinum");
					t.setTicktype(sc.next());
					c.setTick(t);
					System.out.println("Thanks for input");
					break;
			case 2: System.out.println("Customer Details:");
					System.out.println("Name:"+c.getName()+" "+" Address:"+c.getAddress());
					System.out.println("Ticket Details");
					t=c.getTick();
					System.out.println("Ticket No: "+t.getTicno());
	    			System.out.println("Ticket Type: "+t.getTicktype());
	    			System.out.println("Ticket Seat No: "+t.getSeatno());
	    			System.out.println("Ticket Price: "+t.getPrice());
	    			break;
			case 3: System.exit(0);
			}
		}
	}

}
