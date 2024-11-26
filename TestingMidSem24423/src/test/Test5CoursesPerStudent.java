package test;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;


import dao.*;
import model.*;

import org.junit.Test;

public class Test5CoursesPerStudent {

	private CourseDao courseDao;

	    @Before
	    public void setUp() {
	        // Initialize the studentCourseDao object here
	        courseDao = new CourseDao();
	    }
	
	    @Test
	    public void testGetCoursesByStudent() {
	        // Create a Student object for the test
	        Student student = new Student();
	        student.setRegNo("24423");
	
	        // Call the getCoursesByStudent method and store the result
	        java.util.List<Course> courses = courseDao.getCoursesByStudent(student);
	
	        // Verify that the result is not null
	        assertNotNull(courses);
	
	        // Verify that the list is not empty
	        assertTrue(courses.isEmpty() == false);
	    }

}
