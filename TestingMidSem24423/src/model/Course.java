package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Course {
	@Id
	private String courseCode;
	private String courseName;
	private String description;
	
	@OneToMany(mappedBy = "course")
	private List<StudentCourse> studentCourse = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Teacher> teachers = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Semester> semesters = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "department")
	private AcademicUnit department;

	public Course() {
		super();
	}

	public Course(String courseCode) {
		super();
		this.courseCode = courseCode;
	}

	public Course(String courseCode, String courseName, String description, List<StudentCourse> studentCourse,
			List<Teacher> teachers, List<Semester> semesters, AcademicUnit department) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.description = description;
		this.studentCourse = studentCourse;
		this.teachers = teachers;
		this.semesters = semesters;
		this.department = department;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public AcademicUnit getDepartment() {
		return department;
	}

	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}
	
	
	


}
