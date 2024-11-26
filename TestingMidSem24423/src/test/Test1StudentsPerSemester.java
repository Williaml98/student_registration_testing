package test;

import static org.junit.Assert.*;

import org.hibernate.mapping.List;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import dao.*;
import model.*;


public class Test1StudentsPerSemester {

	private StudentRegistrationDao studentRegistrationDao;

    @Before
    public void setUp() {
        // Initialize the studentRegistrationDao object here
        studentRegistrationDao = new StudentRegistrationDao();
    }

    @Test
    public void testGetAllStudentsBySemester() {
        // Create a Semester object for the test
        Semester semester = new Semester();
        semester.setSemId("1");

        // Call the getAllStudentsBySemester method and store the result
        java.util.List<Student> students = studentRegistrationDao.getAllStudentsBySemester(semester);

        // Verify that the result is not null
        assertNotNull(students);

        // Verify that the list is not empty
        assertTrue(students.isEmpty() == false);
    
    }
}
