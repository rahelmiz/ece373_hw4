package org.university.software;
import java.io.Serializable;
import java.util.ArrayList; // Needed for the ArrayList class
import java.util.Collections;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Person;
import org.university.people.Professor;
import org.university.people.ScheduleMap;
import org.university.people.Staff;
import org.university.people.Student;

public abstract class Course implements Serializable {
	
	private int CourseNumber;
	private String CourseName;
	protected ArrayList<Person> studentRoster = new ArrayList<Person>();
	public Department department;
	public Professor professor = null; //only 1 prof per course, but proff can teach multiple courses 
	protected Integer numCredits;
	
	public void addStudent(Person s) {
			this.studentRoster.add(s);
	}
	public void removeStudent(Student s) {
		int counter = 0;
		for (Person ss : this.studentRoster) {
			if (s.equals(ss)){
				this.studentRoster.remove(counter);
				return;
			}
			counter = counter + 1;
		}
	}
	public void setProfessor(Professor p) {
		this.professor = p;
	}
	public Professor getProfessor() {
		return this.professor;
	}
	public void setName(String name) {
		this.CourseName = name;
	}
	
	public String getName() {
		return this.CourseName;
	}
	
	public ArrayList<Person> getStudentRoster(){
		return this.studentRoster;
	}
	
	public void setCourseNumber(int number){
		this.CourseNumber = number;
	}
	public Integer getCourseNumber() {
		return this.CourseNumber;
	}
	public String getCode() {
		return this.getDepartment().getDepartmentName() + this.getCourseNumber().toString();
	}
	
	public Department getDepartment() {
		return this.department;
	}
	public void addDepartment(Department d) {
		this.department = d;
	}
	public Integer getNumCredits() {
		return this.numCredits;
	}
	
	public void addStudentToRoster(Student s1) {
		this.studentRoster.add(s1);
	}
	public abstract boolean  availableTo(Student s);
		
	}
	
	

