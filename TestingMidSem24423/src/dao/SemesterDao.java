package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class SemesterDao {
	
	public void saveSemester(Semester semester) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Transaction tr = ss.beginTransaction();
			ss.save(semester);
			tr.commit();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Semester> displayAllSemesters() {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			List<Semester> semesters = ss.createQuery("from Semester").list();
			return semesters;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
	
	public Semester searchSemesterById(String id) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = ss.createQuery("select semester from Semester semester where semester.semId = :id");
			query.setParameter("id", id);
			return (Semester) ((org.hibernate.query.Query) query).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
	
	public void updateSemester(Semester semester) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Transaction tr = ss.beginTransaction();
			ss.update(semester);
			tr.commit();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getAllStudentsBySemester(Semester semester) {
	    Session ss = HibernateUtility.getSession().openSession();
	    try {
	        Query query = ss.createQuery("select reg.student from StudentRegistration reg where reg.semester = :semester");
	        query.setParameter("semester", semester);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ss.close();
	    }
	    return null;
	}

	
	

}
