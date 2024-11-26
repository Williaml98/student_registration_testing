package test;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;


import dao.*;
import model.*;

import org.junit.Test;

public class Test4CoursesPerDepartmentAndSemester {

	 private StudentRegistrationDao courseDao;

	    @Before
	    public void setUp() {
	        // Initialize the courseDao object here
	        courseDao = new StudentRegistrationDao();
	    }

	    @Test
	    public void testGetCoursesByDepartmentAndSemester() {
	        // Create a Department object for the test
	        AcademicUnit department = new AcademicUnit();
	        department.setUnitCode("6");

	        // Create a Semester object for the test
	        Semester semester = new Semester();
	        semester.setSemId("1");

	        // Call the getCoursesByDepartmentAndSemester method and store the result
	        java.util.List<Course> courses = courseDao.getCoursesByDepartmentAndSemester(department, semester);

	        // Verify that the result is not null
	        assertNotNull(courses);

	        // Verify that the list is not empty
	        assertTrue(courses.isEmpty() == false);
	    }

}
