package com.concretepage.util;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.concretepage.persistence.College;
import com.concretepage.persistence.Student;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final SessionFactory concreteSessionFactory;
	
	    static {
	        try {
	            concreteSessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    
	    public static Session getSession() throws HibernateException {
	        return concreteSessionFactory.openSession();
	    }
	    
	    
	    
	    public static void main(String... args) throws InterruptedException{
	    	Session session=getSession();
	    	session.beginTransaction();
	    	
	    	College c=new College("BSAITM");    	
	    	
	    	Student s1=new Student("Atul", "hisar");	        
	        Student s2=new Student("Saurabh", "bhiwani");	        
	        Student s3=new Student("Saurabh", "bhiwani");
	        
	        
	        c.getStudents().add(s1);
	        c.getStudents().add(s2);
	        c.getStudents().add(s3);
	    	session.save(c);
	    	session.save(c);
	    		    	
	       	session.getTransaction().commit();
	       	
	       	Thread.sleep(500000);
	       	
	
	       	
	     
	    }
	}