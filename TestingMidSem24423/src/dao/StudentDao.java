package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class StudentDao {
	
	public void saveStudent(Student student) {
		Session ss = HibernateUtility.getSession().openSession();

		Transaction tr = ss.beginTransaction();
		try {
			  	ss.save(student);
			  	tr.commit();
				ss.close();
		   }catch(Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
	
	public List<Student> displayAllStudents() {
		Session ss = HibernateUtility.getSession().openSession();
		
		try {
			List<Student> students = ss.createQuery("from Student").list();
			return students;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Student searchStudentById(String id) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = ss.createQuery("select student from Student student where student.regNo = :id");
			query.setParameter("id", id);
			return (Student) ((org.hibernate.query.Query) query).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	 public List<Student> getAllStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) {
//	        try (Session session = HibernateUtility.getSession().openSession()) {
//	            Query<Student> query = session.createQuery(
//	                "select distinct s from Student s " +
//	                "inner join s.studentRegistration sr " +
//	                "inner join sr.semester sem " +
//	                "where s.department = :department " +
//	                "and sem = :semester",
//	                Student.class
//	            );
//	            query.setParameter("department", department);
//	            query.setParameter("semester", semester);
//	            return query.list();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
	
	
	
	
	
	
	
	
	

}
