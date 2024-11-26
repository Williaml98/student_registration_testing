package view;

import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dao.*;

public class RegistrationManagementSystem {
	
	public static void  main(String[] args) {
		boolean condition = true;
		double results;
		String num ;
		
		//String unitCode, academicUnit, unitName, facultyUnCode, progUnitCode;
		
		String semId, semName, teacherCode, teacherName, regNo, studId, names, answer, courseCode, courseName, courseDescription, department;
		LocalDate startDate, endDate, regDate, dob;
		
		Student student = new Student();
		StudentDao dao = new StudentDao();
		//AcademicUnit acUnit = new AcademicUnit();
		AcademicUnit departments = new AcademicUnit();
		AcademicUnitDao acDao = new AcademicUnitDao();
		Semester semester = new Semester();
		Course course = new Course();
		Teacher teacher = new Teacher();
		StudentRegistration studReg = new StudentRegistration();
		CourseDao courseDao = new CourseDao();
		SemesterDao semDao = new SemesterDao();
		TeacherDao tDao = new TeacherDao();
		
		while(condition) {
			System.out.println("==================================================================");
			System.out.println("STUDENT REGISTRATION MANAGEMENT SYSTEM");
			System.out.println("------------------------------------------------------------------");
			
			System.out.println("01. Register Student ");
			System.out.println("02. Register Semester");
			System.out.println("03. Register Course");
			System.out.println("04. Register Teacher");
			System.out.println("05. Student Registration");
			System.out.println("06. Assign Course to a semester");
			System.out.println("07. Assign Teacher to a Course");
			System.out.println("08. Students courses Results");
			System.out.println("09. Display Students Registered in a given Semester");
			System.out.println("10. Display Students Registered in a given Department and Semester");
			System.out.println("11. Display Students Registered in a given Course and Semester");
			System.out.println("12. Display Courses Registered in a given department and Semester");
			System.out.println("13. All courses per student");
			System.out.println("0.  Exit ");
			System.out.println("------------------------------------------------------------------");
			System.out.print("Choose: ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Student ID");
				studId = input.next();
				input.nextLine();
				System.out.println("Enter Names");
				names = input.nextLine().trim();
				System.out.println("Enter Date of birth");
				String dobirth = input.next();
				dob = LocalDate.parse(dobirth);
				System.out.println("Enter Student department");
				department = input.next();
				
				student.setRegNo(studId);   
				student.setNames(names);   
				student.setDateOfBirth(dob); 
				 departments = acDao.searchUnitById(department);
				student.setDepartment(departments);
				
				dao.saveStudent(student);
				System.out.println("Student saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition = true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
				break;
				
			/*
			 * case 2: System.out.println("Enter Unit Code"); unitCode = input.next();
			 * System.out.println("Enter Academic Unit"); academicUnit = input.next();
			 * System.out.println("Enter Unit Name"); unitName = input.next();
			 * System.out.println("Enter Faculty unit code"); facultytUnCode = input.next();
			 * System.out.println("Enter Program unit code"); progUnitCode = input.next();
			 * 
			 * acUnit.setUnitCode(unitCode);
			 * acUnit.setAcademicUnit(EAcademicUnit.DEPARTMENT);
			 * acUnit.setUnitName(unitName); //acUnit.setFaculty(null);
			 * //acUnit.setProgram(null);
			 * 
			 * AcademicUnit programUnit = acDao.searchUnitById(progUnCode); AcademicUnit
			 * facultUnit = acDao.searchUnitById(facultUnCode);
			 * acUnit.setFaculty(facultUnit); acUnit.setProgram(programUnit);
			 * acDao.saveUnit(acUnit); System.out.println("Unit saved successfully.");
			 * System.out.println("Do you wish to continue?, yes or no "); String answers =
			 * input.next(); if(answers.equalsIgnoreCase("yes")) { condition = true; }else {
			 * System.out.println("Thank you for using the system"); condition = false; } break;
			 */
				
			case 2:
				System.out.println("Enter Semester ID");
				semId = input.next();
				System.out.println("Enter semester name");
				semName = input.next();
				System.out.println("Enter start date");
				String start = input.next();
				startDate = LocalDate.parse(start);
				System.out.println("Enter end date");
				String end = input.next();
				endDate = LocalDate.parse(end);
				
				semester.setSemId(semId);
				semester.setSemName(semName);
				semester.setStartDate(startDate);
				semester.setEndDate(endDate);
				
				semDao.saveSemester(semester);
				System.out.println("Semester saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition = true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
				break;
				
			case 3:
				System.out.println("Enter course ID");
				courseCode = input.next();
				input.nextLine();
				System.out.println("Enter course name");
				courseName = input.nextLine().trim();
				input.nextLine();
				System.out.println("Enter course description");
				courseDescription = input.nextLine().trim();
				System.out.println("Enter Department");
				department = input.next();
				
				course.setCourseCode(courseCode);
				course.setCourseName(courseName);
				course.setDescription(courseDescription);
				departments = acDao.searchUnitById(department);
				course.setDepartment(departments);
				
				
				courseDao.saveCourse(course);
				System.out.println("Course saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition = true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
				break;
				
			case 4:
				System.out.println("Enter teacher ID");
				teacherCode = input.next();
				input.nextLine();
				System.out.println("Enter teacher name");
				teacherName = input.nextLine().trim();
				
				teacher.setTeacherCode(teacherCode);
				teacher.setNames(teacherName);
				teacher.setQualification(TeacherEnum.PHD);
				
				tDao.saveTeacher(teacher);
				System.out.println("Teacher saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition= true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
				break;
				
			case 5:
				System.out.println("Enter Registration number");
				regNo = input.next();
				input.nextLine();
				System.out.println("Enter the registration date");
				String reg = input.next();
				regDate = LocalDate.parse(reg);
				System.out.println("Enter Semester Id");
				semId = input.next();
				System.out.println("Enter Student Id");
				studId = input.next();
				
				studReg.setRegId(regNo);
				studReg.setRegDate(regDate);
				semester = semDao.searchSemesterById(semId);
				studReg.setSemester(semester);
				Student students = dao.searchStudentById(studId);
				studReg.setStudent(students);
				
				StudentRegistrationDao regStudDao = new StudentRegistrationDao();
				regStudDao.saveRegistration(studReg);
				System.out.println("Student Registration saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition = true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
				break;
				
			case 6:
			    System.out.println("Enter course code:");
			    courseCode = input.next();
			    System.out.println("Enter semester ID:");
			     semId = input.next();
			    Course courses = null;
			    semester = semDao.searchSemesterById(semId);
			    if (semester != null) {
			        courses = courseDao.searchCourseById(courseCode).get();
			        if (courses != null) {
			        	courseDao.addCourseToSemester(courses, semester);
			            System.out.println("Course added to semester successfully.");
			        } else {
			            System.out.println("Course not found.");
			        }
			    } else {
			        System.out.println("Semester not found.");
			    }
			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 7:
			    System.out.println("Enter course code:");
			    courseCode = input.next();
			    System.out.println("Enter teacher ID:");
			    teacherCode = input.next();	
			    
			    course = courseDao.searchCourseById(courseCode).get();
			    teacher = tDao.searchTeacherById(teacherCode).get();
			    if (course != null && teacher != null) {
			    	courseDao.addTeacherToCourse(teacher, course);
			        System.out.println("Teacher added to course successfully.");
			    } else {
			        System.out.println("Course or teacher not found.");
			    }
			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition= true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 8:
				System.out.println("Enter Student Id:");
			    reg = input.next();
			    System.out.println("Enter course code:");
			    courseCode = input.next();
			    System.out.println("Enter Results:");
			    results = input.nextDouble();
			    
			    StudentCourseDao studCourDao = new StudentCourseDao();
			    StudentCourse studC = new StudentCourse();
			    student = dao.searchStudentById(reg);
			    try {
			        course = courseDao.searchCourseById(courseCode).orElseThrow(() -> new NoSuchElementException("Course not found."));
			    } catch (NoSuchElementException e) {
			        System.out.println("Course not found.");
			        return;
			    }
			    
			    studC.setStudent(student);
			    studC.setCourse(course);
			    studC.setResults(results);
			    
			    studCourDao.saveStudentCourse(studC);
				System.out.println("Student marks saved successfully.");
				System.out.println("Do you wish to continue?, yes or no ");
				answer = input.next();
				if(answer.equalsIgnoreCase("yes")) {
					condition = true;
				}else {
					System.out.println("Thank you for using the system");
					condition = false;
				}
			    
				break;
			    
			case 9:
			    System.out.println("Enter Semester ID");
			    semId = input.next();
			    
			    semester = semDao.searchSemesterById(semId);

			    if (semester != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentss = regStudDaos.getAllStudentsBySemester(semester);

			        if (!studentss.isEmpty()) {
			            System.out.println("Students enrolled in semester " + semester.getSemName() + ":");
			            for (Student stud : studentss) {
			                System.out.println("- " + stud.getNames() + " (" + stud.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this semester.");
			        }
			    } else {
			        System.out.println("Semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 10:
			    System.out.println("Enter Department Code:");
			    String departmentCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semId = input.next();

			    departments = acDao.searchUnitById(departmentCode);
			    semester = semDao.searchSemesterById(semId);

			    if (departments != null && semester != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentes = regStudDaos.getAllStudentsByDepartmentAndSemester(departments, semester);

			        if (!studentes.isEmpty()) {
			            System.out.println("Students enrolled in " + departments.getUnitName() + " department for semester " + semester.getSemName() + ":");
			            for (Student stude : studentes) {
			                System.out.println("- " + stude.getNames() + " (" + stude.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this department and semester combination.");
			        }
			    } else {
			        System.out.println("Department or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 11:
			    System.out.println("Enter Course Code:");
			    courseCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semId = input.next();

			    course = courseDao.searchCourseById(courseCode).orElse(null);
			    semester = semDao.searchSemesterById(semId);

			    if (course != null && semester != null) {
			        StudentRegistrationDao regStudDaos = new StudentRegistrationDao();
			        List<Student> studentees = regStudDaos.getStudentsByCourseAndSemester(course, semester);

			        if (!studentees.isEmpty()) {
			            System.out.println("Students enrolled in " + course.getCourseName() + " for semester " + semester.getSemName() + ":");
			            for (Student studen : studentees) {
			                System.out.println("- " + studen.getNames() + " (" + studen.getRegNo() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this course and semester combination.");
			        }
			    } else {
			        System.out.println("Course or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition= true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 12:
			    System.out.println("Enter Department Code:");
			    departmentCode = input.next();
			    System.out.println("Enter Semester ID:");
			    semId = input.next();

			    departments = acDao.searchUnitById(departmentCode);
			    semester = semDao.searchSemesterById(semId);

			    if (departments != null && semester != null) {
			        List<Course> coursees = courseDao.getCoursesByDepartmentAndSemester(departments, semester);

			        if (!coursees.isEmpty()) {
			            System.out.println("Courses offered by " + departments.getUnitName() + " department for semester " + semester.getSemName() + ":");
			            for (Course coursed : coursees) {
			                System.out.println("- " + coursed.getCourseName() + " (" + coursed.getCourseCode() + ")");
			            }
			        } else {
			            System.out.println("No courses found for this department and semester combination.");
			        }
			    } else {
			        System.out.println("Department or semester not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 13:
			    System.out.println("Enter Student ID: ");
			    studId = input.next();
			    
			    student = dao.searchStudentById(studId);

			    if (student != null) {
			        List<Course> coursesd = courseDao.getCoursesByStudent(student);

			        if (!coursesd.isEmpty()) {
			            System.out.println("Courses for student " + student.getNames() + " (" + student.getRegNo() + "):");
			            for (Course coursed : coursesd) {
			                System.out.println("- " + coursed.getCourseName() + " (" + coursed.getCourseCode() + ")");
			            }
			        } else {
			            System.out.println("No courses found for the given student ID.");
			        }
			    } else {
			        System.out.println("Student not found.");
			    }

			    System.out.println("Do you wish to continue?, yes or no ");
			    answer = input.next();
			    if (answer.equalsIgnoreCase("yes")) {
			    	condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition= false;
			    }
			    break;
             case 0:
                 System.out.println("Thank you for using the system");
                 condition = false;
                 break;
				
			}
		}
		

		
	}

}
