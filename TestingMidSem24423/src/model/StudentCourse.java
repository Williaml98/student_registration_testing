package model;

import jakarta.persistence.*;

@Entity
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "reg_no")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	private Double results;

	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(Integer id) {
		super();
		this.id = id;
	}

	public StudentCourse(Integer id, Student student, Course course, Double results) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.results = results;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getResults() {
		return results;
	}

	public void setResults(Double results) {
		this.results = results;
	}
	
	

}
