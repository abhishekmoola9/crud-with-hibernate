package org.acs.hql.utility;

import java.util.Properties;

import org.acs.hql.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtill {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				//new confugure your hibernate.cfg.xml 
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
				settings.put(Environment.USER, "root");	
				settings.put(Environment.PASS, "Welcome2acs");	
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL, "true");	
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	 
				cfg.setProperties(settings);
				
				cfg.addAnnotatedClass(Student.class);
				
				ServiceRegistry sRegistry = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();
				
				sessionFactory = cfg.buildSessionFactory(sRegistry);
				
			} catch (Exception e) {
			e.printStackTrace();
			}

			
		}
		return sessionFactory;
		
	}

}
