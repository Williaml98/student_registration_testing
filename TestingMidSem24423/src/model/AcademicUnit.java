package model;

import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class AcademicUnit {
	@Id
	private String unitCode;
	
	private String unitName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "academic_unit")
	private EAcademicUnit academicUnit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AcademicUnit program;
	
	@OneToMany(mappedBy = "program")
	private List<AcademicUnit> faculties;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AcademicUnit faculty;
	
	@OneToMany(mappedBy = "faculty")
	private List<AcademicUnit> departments;
	
	@OneToMany(mappedBy = "department")
	private List<Student> students;
	
	@OneToMany(mappedBy = "department")
	private List<Course> courses = new ArrayList<>();

	public AcademicUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcademicUnit(String unitCode) {
		super();
		this.unitCode = unitCode;
	}

	public AcademicUnit(String unitCode, String unitName, EAcademicUnit academicUnit, AcademicUnit program,
			List<AcademicUnit> faculties, AcademicUnit faculty, List<AcademicUnit> departments, List<Student> students,
			List<Course> courses) {
		super();
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.academicUnit = academicUnit;
		this.program = program;
		this.faculties = faculties;
		this.faculty = faculty;
		this.departments = departments;
		this.students = students;
		this.courses = courses;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public EAcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(EAcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

	public AcademicUnit getProgram() {
		return program;
	}

	public void setProgram(AcademicUnit program) {
		this.program = program;
	}

	public List<AcademicUnit> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<AcademicUnit> faculties) {
		this.faculties = faculties;
	}

	public AcademicUnit getFaculty() {
		return faculty;
	}

	public void setFaculty(AcademicUnit faculty) {
		this.faculty = faculty;
	}

	public List<AcademicUnit> getDepartments() {
		return departments;
	}

	public void setDepartments(List<AcademicUnit> departments) {
		this.departments = departments;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	@Override
	public String toString() {
		return "AcademicUnitModel [unitCode=" + unitCode + ", unitName=" + unitName + ", academicUnit=" + academicUnit + ", program="
				+ program + ", faculties=" + faculties + ", faculty=" + faculty + ", departments=" + departments
				+ ", student=" + students + ", courses=" + courses + "]";
	}

}
