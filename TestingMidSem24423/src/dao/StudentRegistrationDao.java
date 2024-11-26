package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class StudentRegistrationDao {
	
	public void saveRegistration(StudentRegistration registration) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Transaction tr = ss.beginTransaction();
			ss.save(registration);
			tr.commit();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<StudentRegistration> getAllRegistration() {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			List<StudentRegistration> registration = ss.createQuery("from StudentRegistration").list();
			return registration;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<StudentRegistration> displayAllStudentAndSemester(Semester semester) {
	    Session session = HibernateUtility.getSession().openSession();
	    try {
	        Query query = session.createQuery("select reg from StudentRegistration reg join reg.semester s where s = :semester");
	        query.setParameter("semester", semester);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return null;
	}
	
	public List<Student> getAllStudentsBySemester(Semester semester) {
	    try (Session ss = HibernateUtility.getSession().openSession()) {
	        Query query = ss.createQuery("select reg.student from StudentRegistration reg where reg.semester = :semester");
	        query.setParameter("semester", semester);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public List<Student> getAllStudentsByDepartmentAndSemester(AcademicUnit department, Semester semester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery( "select distinct s from Student s " + "inner join s.studentRegistration sr " +
                 "inner join sr.semester sem " + "where s.department = :department " + "and sem = :semester");
            query.setParameter("department", department);
            query.setParameter("semester", semester);
            return ((org.hibernate.query.Query) query).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public List<Student> getStudentsByCourseAndSemester(Course course, Semester semester) {
	    try (Session session = HibernateUtility.getSession().openSession()) {
	        Query query = session.createQuery(
	                "select distinct sc.student from StudentCourse sc " +
	                "inner join sc.course c " +
	                "inner join sc.student s " +
	                "inner join s.studentRegistration sr " +
	                "where c = :course " +
	                "and sr.semester = :semester"
	        );
	        query.setParameter("course", course);
	        query.setParameter("semester", semester);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public List<Course> getCoursesByDepartmentAndSemester(AcademicUnit department, Semester semester) {
	    try (Session session = HibernateUtility.getSession().openSession()) {
	        Query query = session.createQuery(
	                "select distinct c from Course c " +
	                "join c.department d " +
	                "join c.semesters s " +
	                "where d = :department " +
	                "and s = :semester"
	        );
	        query.setParameter("department", department);
	        query.setParameter("semester", semester);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	

}
