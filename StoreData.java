package com.sameer.lab_07;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StoreData {
	public static void main(String[] args) {
		int i;
		Scanner input = new Scanner(System.in);
		int id;
		String name;
		String fathername;
		String organization;
		String mobile;

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Person.class);

		cfg.configure("hibernate.cfg.xml");// populates the configuration file

		// creating session factory object
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		// creating session object
		Session session = factory.openSession();
		// creating transaction object
		Transaction t = session.beginTransaction();

		Person e1 = new Person();

		System.out.println("Press 1 to add, 2 to delete, 3 to update and 4 to show result");
		i = input.nextInt();
		if (i == 1) {
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			System.out.println("Stuendent name?");
			name = input.nextLine();
			name = input.nextLine();
			System.out.println("Stuendent fathername?");
			fathername = input.nextLine();
			System.out.println("Stuendent organization?");
			organization = input.nextLine();
			System.out.println("Stuendent mobile?");
			mobile = input.nextLine();

			e1.setId(id);
			e1.setName(name);
			e1.setFatherName(fathername);
			e1.setOrganization(organization);
			e1.setMobile(mobile);

			session.persist(e1);// persisting the object
			t.commit();// transaction is commited
			session.close();
		} else if (i == 2) {

			System.out.println("Stuendent ID?");
			id = input.nextInt();
			System.out.println("Stuendent name?");
			name = input.nextLine();
			name = input.nextLine();
			System.out.println("Stuendent fathername?");
			fathername = input.nextLine();
			System.out.println("Stuendent organization?");
			organization = input.nextLine();
			System.out.println("Stuendent mobile?");
			mobile = input.nextLine();

			e1.setId(id);
			e1.setName(name);
			e1.setFatherName(fathername);
			e1.setOrganization(organization);
			e1.setMobile(mobile);

			session.delete(e1);
			t.commit();// transaction is commited
			session.close();
		} else if (i == 3) {

			System.out.println("Stuendent ID?");
			id = input.nextInt();
			System.out.println("Stuendent name?");
			name = input.nextLine();
			name = input.nextLine();
			System.out.println("Stuendent fathername?");
			fathername = input.nextLine();
			System.out.println("Stuendent organization?");
			organization = input.nextLine();
			System.out.println("Stuendent mobile?");
			mobile = input.nextLine();

			e1.setId(id);
			e1.setName(name);
			e1.setFatherName(fathername);
			e1.setOrganization(organization);
			e1.setMobile(mobile);

			session.update(e1);
			t.commit();// transaction is commited
			session.close();

		} else if (i == 4) {
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			Person per = get(id);
			System.out
					.println("id: " + per.getId() + " Name: " + per.getName() + " Fathers Name: " + per.getFatherName()
							+ " Organization: " + per.getOrganization() + " Mobile Number: " + per.getMobile() + "\n");

		}
	}

	public static Person get(int id) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Person.class);

		cfg.configure("hibernate.cfg.xml");// populates the configuration fil
		// creating session factory object
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		// creating session object
		Session session = factory.openSession();
		// creating transaction object
		Transaction t = session.beginTransaction();

		Person person = (Person) session.get(Person.class, id);
		t.commit();// transaction is commited
		session.close();

		return person;
	}
}
