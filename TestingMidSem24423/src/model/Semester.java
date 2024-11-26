package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Semester {
	@Id
	private String semId;
	
	private String semName;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToMany
	@JoinTable(name = "courses_semesters",
		joinColumns = @JoinColumn(name = "semester_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	private List<Course> courses = new ArrayList<Course>();
	
	@OneToMany(mappedBy = "semester")
	private List<StudentRegistration> students = new ArrayList<>();

	public Semester() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semester(String semId) {
		super();
		this.semId = semId;
	}

	public Semester(String semId, String semName, LocalDate startDate, LocalDate endDate, List<Course> courses,
			List<StudentRegistration> students) {
		super();
		this.semId = semId;
		this.semName = semName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courses = courses;
		this.students = students;
	}

	public String getSemId() {
		return semId;
	}

	public void setSemId(String semId) {
		this.semId = semId;
	}

	public String getSemName() {
		return semName;
	}

	public void setSemName(String semName) {
		this.semName = semName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<StudentRegistration> getStudents() {
		return students;
	}

	public void setStudents(List<StudentRegistration> students) {
		this.students = students;
	}
	
	

}
