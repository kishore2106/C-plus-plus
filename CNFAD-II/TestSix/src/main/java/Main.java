import java.util.List;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder.Case;


public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		Scanner sc = new Scanner(System.in);
		SessionFactory sFactory = configuration.buildSessionFactory();
		Session session;
		Student s;
		while(true) {
			session = sFactory.openSession();
			s = new Student();
			System.out.println("1.Enter Details. \n2.Display Details. \n3.Exit. \nEnter your choice - ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Student Name - ");
				s.setName(sc.next());
				System.out.println("Enter the total Marks - ");
				s.setTotalMarks(sc.nextInt());
				Transaction t = session.beginTransaction();
				session.save(s);
				t.commit();
				break;
			case 2:
				List<Student> students = session.createQuery("FROM student").list();
				for(Student stud: students) {
					System.out.println(stud.getId()+" "+stud.getName()+" "+stud.getTotalMarks());
				}
				break;
			case 3:
				sFactory.close();
				System.exit(0);
			}
		
		}

	}

}
