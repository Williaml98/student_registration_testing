package test;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.hibernate.mapping.List;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import dao.*;
import model.*;

import org.junit.Test;

public class Test2StudentsPerDepartmentAndSemester {

	 private StudentRegistrationDao studentDao;

		
		  @Before public void setUp() { // Initialize the studentDao object here
		  studentDao = new StudentRegistrationDao(); }
		 

	    @Test
	    public void testGetAllStudentsByDepartmentAndSemester() {
	        // Create a Department object for the test
	        AcademicUnit department = new AcademicUnit();
	        department.setUnitCode("6");

	        // Create a Semester object for the test
	        Semester semester = new Semester();
	        semester.setSemId("1");

	        // Call the getAllStudentsByDepartmentAndSemester method and store the result
	        java.util.List<Student> students = studentDao.getAllStudentsByDepartmentAndSemester(department, semester);

	        // Verify that the result is not null
	        assertNotNull(students);

	        // Verify that the list is not empty
	        assertTrue(students.isEmpty() == false);
	    }

}

