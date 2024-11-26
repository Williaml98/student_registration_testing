package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	private String regNo;
	private String names;
	
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourse = new ArrayList<>();
	
	@OneToMany(mappedBy = "student")
	private List<StudentRegistration> studentRegistration = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "department")
	private AcademicUnit department;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String regNo) {
		super();
		this.regNo = regNo;
	}

	public Student(String regNo, String names, LocalDate dateOfBirth, List<StudentCourse> studentCourse,
			List<StudentRegistration> studentRegistration, AcademicUnit department) {
		super();
		this.regNo = regNo;
		this.names = names;
		this.dateOfBirth = dateOfBirth;
		this.studentCourse = studentCourse;
		this.studentRegistration = studentRegistration;
		this.department = department;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public List<StudentRegistration> getStudentRegistration() {
		return studentRegistration;
	}

	public void setStudentRegistration(List<StudentRegistration> studentRegistration) {
		this.studentRegistration = studentRegistration;
	}

	public AcademicUnit getDepartment() {
		return department;
	}

	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}
	
	

}
