package in.hibernate.main;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.hibernate.main.entities.User;

public class App {
	public static void main(String[] args) {
		User user1 = new User();
		// user1.setId(1); // No need to write this line due to
		// -->@GeneratedValue(strategy = GenerationType.IDENTITY) in entity class
		user1.setName("Anil");
		user1.setEmail("Anil@gmail.com");
		user1.setPassword("Anil123");
		user1.setGender("Male");
		user1.setCity("Pune");

		User user2 = new User();
		// user2.setId(2);
		user2.setName("Hardik");
		user2.setEmail("hardik@gmail.com");
		user2.setPassword("hardik");
		user2.setGender("Male");
		user2.setCity("Banglore");

		Configuration cfg = new Configuration();
		cfg.configure("/in/hibernate/main/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// ---Insert User--------------

		try {
			session.save(user1);
			transaction.commit(); // It is used to store user1 in database permanently
			System.out.println("User details added successfully..!!");
		} catch (Exception e) {
			transaction.rollback(); // If user will not get saved due to some reasonit will Rollback
									// e.printStackTrace();
			System.out.println("User details not added Due to some error..!!");

		}

		// ------ Select User------------------

		// ---Note---------
		// Transaction is needed only for INSERT, UPDATE & DELETE
		// Transaction Not needed for Select Operation
		/*
		 * try { User user = session.get(User.class, 5L);
		 * 
		 * if (user != null) { System.out.println("Id : " + user.getId());
		 * System.out.println("Name : " + user.getName()); System.out.println("Email : "
		 * + user.getEmail()); System.out.println("Password : " + user.getPassword());
		 * System.out.println("Gender : " + user.getGender());
		 * System.out.println("City : " + user.getCity()); } else {
		 * System.out.println("User Not Found..!"); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 */

		// -----Update User------------
		/*
		 * try { User user = session.get(User.class, 3L);
		 * 
		 * if (user != null) { user.setCity("Daund"); transaction.commit(); } else {
		 * System.out.println("User Not Found..!"); transaction.rollback(); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); transaction.rollback(); }
		 * 
		 */

		// --------------Delete User--------------
		/*
		 * try {
		 * 
		 * User user = session.get(User.class, 3L);
		 * 
		 * if (user != null) { session.delete(user); transaction.commit(); } else {
		 * System.out.println("User Not Found..!"); transaction.rollback(); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); transaction.rollback(); }
		 * 
		 */

	}
}
