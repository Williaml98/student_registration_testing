package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class TeacherDao {
	
	public void saveTeacher(Teacher teacher) {
		Session ss = HibernateUtility.getSession().openSession();

		Transaction tr = ss.beginTransaction();
		try {
			  	ss.save(teacher);
			  	tr.commit();
				ss.close();
		   }catch(Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
	}
	
	public Optional<Teacher> searchTeacherById(String teacherId) {
	    Session session = HibernateUtility.getSession().openSession();
	    Teacher teacher = session.get(Teacher.class, teacherId);
	    session.close();
	    return Optional.ofNullable(teacher);
	}
	
	

}
