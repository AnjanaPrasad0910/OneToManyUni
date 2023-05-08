package Driver;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import entity.*;

public class InsertTeacherAndTeacherDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Teacher.class)
				                .addAnnotatedClass(TeacherDetails.class)
				                .addAnnotatedClass(Course.class)
				                .addAnnotatedClass(Review.class)
				                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Teacher theTeacher = new Teacher("Amy","Suri","Amy@gl.com");
			TeacherDetails theTeacherDetails = new TeacherDetails("Mumbai","Playing Games");
			
			//associate the object
			theTeacher.setTeacherDetails(theTeacherDetails);
			
			//start transaction
			session.beginTransaction();
			
			 //save the Teacher
			System.out.println("Saving the Teacher" +theTeacher);
			session.save(theTeacher);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed Successfully");
			 
		}finally {
			session.close();
			factory.close();
		}
				

	}

}
