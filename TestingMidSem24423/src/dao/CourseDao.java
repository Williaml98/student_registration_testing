package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;

import jakarta.persistence.Query;
import model.*;
import repository.*;

public class CourseDao {
	
	public void saveCourse(Course course) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Transaction tr = ss.beginTransaction();
			ss.save(course);
			tr.commit();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Course> displayAllCourses() {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			List<Course> courses = ss.createQuery("from Course").list();
			return courses;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	/*
	 * public Course searchCourseById(String id) { Session ss =
	 * HibernateUtility.getSession().openSession(); try { Query query = ss.
	 * createQuery("select course from Course course where course.courseCode = :id"
	 * ); query.setParameter("id", id); return (Course) ((org.hibernate.query.Query)
	 * query).uniqueResult(); }catch(Exception e) { e.printStackTrace(); }finally {
	 * ss.close(); } return null; }
	 */
	
	public Optional<Course> searchCourseById(String id) {
	    Session ss = HibernateUtility.getSession().openSession();
	    try {
	        Query query = ss.createQuery("select course from Course course where course.courseCode = :id");
	        query.setParameter("id", id);
	        return Optional.ofNullable((Course) ((org.hibernate.query.Query) query).uniqueResult());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ss.close();
	    }
	    return Optional.empty();
	}
	
	public void addTeacherToCourse(Teacher teacher, Course course) {
	    Transaction transaction = null;
	    Session session = HibernateUtility.getSession().openSession();
	    try {
	        transaction = session.beginTransaction();
	        teacher = session.get(Teacher.class, teacher.getTeacherCode());
	        course = session.get(Course.class, course.getCourseCode());
	        teacher.getCourses().add(course);
	        course.getTeachers().add(teacher);
	        session.saveOrUpdate(teacher);
	        session.saveOrUpdate(course);
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    } finally {
	        session.close();
	    }
	}
	
	
	
	public List<Course> getCoursesByDepartmentAndSemester(AcademicUnit department, Semester semester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery(
                "select distinct c from Course c " +
                "inner join c.semesters s " +
                "where c.department = :department " +
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
	
	public void addCourseToSemester(Course course, Semester semester) {
	    Session session = HibernateUtility.getSession().openSession();
	    System.out.println("Course object: " + course);
	    System.out.println("Course code: " + course.getCourseCode());
	    System.out.println("Semester object: " + semester);
	    System.out.println("Semester ID: " + semester.getSemId());

	    try {
	        Transaction transaction = session.beginTransaction();

	        System.out.println("Course object: " + course);
	        System.out.println("Course code: " + course.getCourseCode());
	        if (course.getCourseCode() == null) {
	            System.out.println("Course code is null!");
	        }

	        System.out.println("Retrieving Course object...");
	        course = session.get(Course.class, course.getCourseCode());
	        System.out.println("Course object retrieved: " + course);

	        System.out.println("Merging Semester object...");
	        semester = (Semester) session.merge(semester);
	        System.out.println("Semester object merged: " + semester);

	        System.out.println("Semester ID: " + semester.getSemId());
	        if (semester.getSemId() == null) {
	            System.out.println("Semester ID is null!");
	        }

	        course.getSemesters().add(semester);
	        semester.getCourses().add(course);

	        System.out.println("Saving Course and Semester objects...");
	        session.saveOrUpdate(course);
	        session.saveOrUpdate(semester);

	        transaction.commit();
	        System.out.println("Course added to semester successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public List<Course> getCoursesByStudent(Student student) {
	    Session session = HibernateUtility.getSession().openSession();
	    try {
	        Query query = session.createQuery(
	            "select sc.course from StudentCourse sc " +
	            "where sc.student = :student"
	        );
	        query.setParameter("student", student);
	        return ((org.hibernate.query.Query) query).list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return null;
	}
	
	

}
