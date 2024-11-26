package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class AcademicUnitDao {
	
	public void saveUnit(AcademicUnit unit) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Transaction tr = ss.beginTransaction(); 
			ss.save(unit);
			tr.commit();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AcademicUnit searchUnitByName(String name) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = ss.createQuery("select unit from AcademicUnitModel unit where unit.name = :name");
			query.setParameter("name", name);
			AcademicUnit unit = (AcademicUnit) ((org.hibernate.query.Query) query).uniqueResult();
			ss.close();
			return unit;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<AcademicUnit> displayAllUnits() {
		Session ss = HibernateUtility.getSession().openSession();
		List<AcademicUnit> units = ss.createQuery("from AcademicUnit").list();
		return units;
	}
	
	public AcademicUnit searchUnitById(String id) {
		Session ss = HibernateUtility.getSession().openSession();
		Query query = ss.createQuery("select unit from AcademicUnit unit where unit.unitCode = :id");
		query.setParameter("id", id);
		return (AcademicUnit) ((org.hibernate.query.Query) query).uniqueResult();
	}
	
	public List<Course> getCoursesByStudentId(String studentId) {
	    try (Session session = HibernateUtility.getSession().openSession()) {
	        Query query = session.createQuery(
	                "select distinct c from Course c " +
	                "join c.studentCourses sc " +
	                "join sc.student s " +
	                "where s.regNo = :studentId",
	                Course.class
	        );
	        query.setParameter("studentId", studentId);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
