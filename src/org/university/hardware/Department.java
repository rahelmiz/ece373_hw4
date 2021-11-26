
package org.university.hardware;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList; // Needed for the ArrayList class

import org.university.people.Professor;
import org.university.people.Staff;
import org.university.people.Student;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;
import org.university.software.University;

public class Department implements Serializable{
	private String name;
	private ArrayList<CampusCourse> campus_courses = new ArrayList<CampusCourse>();
	private ArrayList<OnlineCourse> online_courses = new ArrayList<OnlineCourse>();
	public ArrayList<Professor> professors = new ArrayList<Professor>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Staff> staff = new ArrayList<Staff>();

	
	public void setDepartmentName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return this.name;
	}
	
	public void addCourse(CampusCourse course1) {
		this.campus_courses.add(course1);
		course1.addDepartment(this);
	}
	public void addCourse(OnlineCourse course1) {
		this.online_courses.add(course1);
		course1.addDepartment(this);
	}
	
	public void addStudent(Student s) {
		this.students.add(s);
		s.setDepartment(this);
	}
	public void addProfessor(Professor p) {
		this.professors.add(p);
		
	}
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	public ArrayList<Professor> getProfessorList() {
		return this.professors;
	}
	public ArrayList<Student> getStudentList() {
		return this.students;
	}
	
	public void printProfessorList() {
		for (Professor p : this.professors)
			System.out.println(p.getName());
	}
	
	public void printCourseList() {
		for (CampusCourse cc : this.campus_courses) {
			System.out.println(cc.getCode() + " "+cc.getName());
		}
		for (OnlineCourse oc : this.online_courses)
			System.out.println(oc.getCode() + " " + oc.getName());
		}
		
	public void printStudentList() {
		for (Student s : this.students)
			System.out.println(s.getName());
	}
	public void printStaffList() {
		for (Staff s : this.staff)
			System.out.println(s.getName());
	}
			
	
	
	public ArrayList<CampusCourse> getCampusCourseList() {
		return this.campus_courses;
	}
	public ArrayList<OnlineCourse> getOnlineCourseList() {
		return this.online_courses;
	}
	
	public String getName() {
		return this.name;
	}
	public ArrayList<Staff> getStaffList() {
		return this.staff;
	}
	
	public void addStaff(Staff sf1) {
		this.staff.add(sf1);
		
	}
	public static void saveData(Department D) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("Department.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(D);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

	
}

