package com.hibernateutils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration config=null;
static	SessionFactory sessionfact=null;

	
static {
	try {
		config=new Configuration();
		config.configure();
		sessionfact=config.buildSessionFactory();
	} catch (HibernateException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

public static Session getSession() {
	Session s=null;
	try {
		s=sessionfact.openSession();
	
	} catch (Exception e) {
	e.printStackTrace();
	}
		return s;	
}

public static void closeSession(Session s) {
	if(s!=null) {
		s.close();
	}
}
}
