package test;

import static org.junit.Assert.*;


import org.hibernate.mapping.List;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;


import dao.*;
import model.*;

import org.junit.Test;

public class Test3StudentsPerCourseAndSemester {

	private StudentRegistrationDao studentDao;

	    @Before
	    public void setUp() {
	        // Initialize the studentDao object here
	        studentDao = new StudentRegistrationDao();
	    }
	
	    @Test
	    public void testGetStudentsByCourseAndSemester() {
	        // Create a Course object for the test
	        Course course = new Course();
	        course.setCourseCode("INSY280");
	
	        // Create a Semester object for the test
	        Semester semester = new Semester();
	        semester.setSemId("1");
	
	        // Call the getStudentsByCourseAndSemester method and store the result
	        java.util.List<Student> students = studentDao.getStudentsByCourseAndSemester(course, semester);
	
	        // Verify that the result is not null
	        assertNotNull(students);
	
	        // Verify that the list is not empty
	        assertTrue(students.isEmpty() == false);
	    }

}
