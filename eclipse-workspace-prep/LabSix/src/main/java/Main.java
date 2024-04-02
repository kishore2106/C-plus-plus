import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder.Case;

public class Main {
	public static void main(String a[]) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sFactory = configuration.buildSessionFactory();
		Session session;
		Student student;
		int ch;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			session = sFactory.openSession();
			student = new Student();
	System.out.println("Menu\n1.Add record\n2.Display\n3.Exit");
			ch = scanner.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Enter name and marks");
				student.setName(scanner.next());
				student.setTotalMarks(scanner.nextInt());

				// Save the student to the database
				Transaction transaction = session.beginTransaction();

				// Save the student to the database
				session.save(student);

				// Commit the transaction
				transaction.commit();
				break;
			}
			case 2: { // Retrieve all students from the database
				java.util.List<Student> students = session.createQuery("FROM Student").list();

				// Display the retrieved students
				System.out.println("Retrieved Students:");
				for (Student s : students) {
					System.out.println(
							"ID: " + s.getId() + ", Name: " + s.getName() + ", Total Marks: " + s.getTotalMarks());
				}
				break;

			}
			case 3: { // Close the SessionFactory
				sFactory.close();
				System.exit(0);
			}
			}
		}

	}
}