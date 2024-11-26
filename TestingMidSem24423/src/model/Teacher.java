package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Teacher {
	@Id
	private String teacherCode;
	
	private String names;
	
	@Enumerated(EnumType.STRING)
	private TeacherEnum qualification;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teachers_courses",
		joinColumns = @JoinColumn(name = "teacherCode"),
		inverseJoinColumns = @JoinColumn(name = "courseCode")
			)
	private List<Course> courses = new ArrayList<>();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String teacherCode) {
		super();
		this.teacherCode = teacherCode;
	}

	public Teacher(String teacherCode, String names, TeacherEnum qualification, List<Course> courses) {
		super();
		this.teacherCode = teacherCode;
		this.names = names;
		this.qualification = qualification;
		this.courses = courses;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public TeacherEnum getQualification() {
		return qualification;
	}

	public void setQualification(TeacherEnum qualification) {
		this.qualification = qualification;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	

}
