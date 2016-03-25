package com.simpleprogram;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		User user = new User();
		user.setName("joe");
		user.setGoal(250);
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		User myUser = session.load(User.class, 1);
		System.out.println("User: " + myUser.getName());
		myUser.setGoal(myUser.getGoal() + 50);
		session.getTransaction().commit();
		
		session.close();
	}

}
