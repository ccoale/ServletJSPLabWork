package com.simpleprogram;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities{
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistryBuilder serviceRegistry;
	
	static {
		try {
			Configuration config = new Configuration().configure();
			config.addResource("User.hbm.xml");
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			sessionFactory = config.buildSessionFactory(serviceRegistry.build());
			
		} catch (Exception e) {
			System.out.println("Problem creating session factory..." + e.getMessage() );
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
