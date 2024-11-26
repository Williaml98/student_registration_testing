package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class StudentCourseDao {
	
	public void saveStudentCourse(StudentCourse studentCourse) {
	    Session session = HibernateUtility.getSession().openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
	        Course course = studentCourse.getCourse();
	        if (course.getCourseCode() == null) {
	            session.save(course);
	        }
	        session.save(studentCourse);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public List<StudentCourse> displayAllStudentCourses() {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			List<StudentCourse> studentCourses = ss.createQuery("from StudentCourse").list();
			return studentCourses;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
	
	public List<StudentCourse> getStudentsByCourses(Course course) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = ss.createQuery("select studentCourse from StudentCourse studentCourse where studentCourse.course = :course");
			query.setParameter("course", course);
			return ((org.hibernate.query.Query) query).list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

}
