package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
		
			int theId = 1;
			Course course1 = session.get(Course.class, theId);
			
			//delete the course
			System.out.println("course1: "+course1);
			
			//delete the revies 
			System.out.println("Review: "+course1.getReviews());

			session.delete(course1);
			
			//	session.save(course2);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("--------Done!!!---------");
		}finally
		{
			System.out.println("Close factory object!!");
			session.close();
			factory.close();
		}
		
	}

}
