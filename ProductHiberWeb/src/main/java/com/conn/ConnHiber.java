package com.conn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

public class ConnHiber {
public Session conHib() throws HibernateException {
	
	
	////Ist
		/*Configuration configuration= new Configuration().configure();
		configuration.addAnnotatedClass(com.to.Student.class);
		StandardServiceRegistryBuilder builder= 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory= configuration.buildSessionFactory(builder.build());
		
		
		Session session= factory.openSession();
		
		works fine with mapping as 'resource'in cfg.xml
		*/
	
	/////////////2nd works with mapping as'class' in cfg.xml
	
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();		
	//Metadata in the config file should be executed		
	Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();	
	//go to session factory and execute the meta data
	SessionFactory sf=md.getSessionFactoryBuilder().build();
	//Session is the place where write our crud operations
	Session session=sf.openSession();
	//Transaction -saving all the crud operations on the db
	//Transaction t=s.beginTransaction();

		return session;
}
}
