package org.university.software;
import java.util.ArrayList; // Needed for the ArrayList class

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Person;
import org.university.people.Professor;
import org.university.people.Staff;
import org.university.people.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class University implements Serializable{

	public ArrayList<Department> departmentList = new ArrayList<Department>();
	public ArrayList<Student> studentList = new ArrayList<Student> ();
	public ArrayList<Course> courseList = new ArrayList<Course> ();
	public ArrayList<Classroom> classroomList = new ArrayList<Classroom> ();
	public ArrayList<Staff> staffList = new ArrayList<Staff> ();
	public ArrayList<Professor> professorList = new ArrayList<Professor> ();
	
	 
	public void printDepartmentList() {
		for (Department d: this.departmentList) {
			System.out.println(d.getDepartmentName() + " ");
		}
	}

	public void printStudentList() {
		for (Department d : this.departmentList) {
			for (Student s: d.getStudentList()) {
			System.out.println(s.getName() + " ");
			}
		}
	}

	/*
	 * public void printCourseList() { for (Department d : this.departmentList) {
	 * for (CampusCourse c: d.getCampusCourseList()) {
	 * System.out.println(c.getName() + " "); } for (OnlineCourse oc:
	 * d.getOnlineCourseList()) { System.out.println(oc.getName() + " "); } } }
	 */

	
	  public void printCourseList() { 
		  for (Department d : this.departmentList) {
			  d.printCourseList();
		  }
	  }
	 

	public void printStaffList() {
		for (Department d : this.departmentList) {
			for (Staff s: d.getStaffList()) {
				System.out.println(s.getName() + " ");
			}
		}
	}

	public void printProfessorList() {
		for (Department d : this.departmentList) {
			for (Professor p: d.getProfessorList()) {
			System.out.println(p.getName() + " ");
			}
		}
	}
	public void addCourse(Course c) {
		this.courseList.add(c);
		
	}
	public static void save_data(University u) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("University.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(u);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}
	public static University load_data() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		University u = null;
		try {
			fileIn = new FileInputStream("University.ser");
			objIn = new ObjectInputStream(fileIn);
			u = (University)objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
		catch(ClassNotFoundException c ){ //check if class exists
			c.printStackTrace();
		}
		return u;
	}
	
	public void print_depts() {
		//print dept list
		System.out.println("Department List"); 
		for (Department d: departmentList) {
			System.out.println(d.getName());
		}
		System.out.println("\n");
	}
	public void print_crs() {
		//print classrooms
		System.out.println("Classroom List"); 
		for (Classroom c: classroomList) {
			System.out.println(c.getRoomNumber());
		}
		System.out.println("\n");
	}
	
	public void print_proffs() {
		for (Department d: departmentList) {
			System.out.println("The professor list for " + d.getName()); 
			d.printProfessorList();
			System.out.println("\n");
		}
	}
	public void print_courses() {
		for (Department d: departmentList) {
			System.out.println("the course list for department "+ d.getDepartmentName());
			for (CampusCourse c: d.getCampusCourseList()) {
				System.out.println(c.getCode() + " " + c.getName()); 
			}
			for (OnlineCourse oc: d.getOnlineCourseList()) {
				System.out.println(oc.getCode() + oc.getName()); 
			}
			System.out.println("\n");
		}
		
	}
	public void print_cr_sched() {
		//print class schedule
		for (Classroom c: classroomList) {
			System.out.println("the schedule for " + c.getRoomNumber());
			c.printSchedule();
		}
	}
	
	private void staff_sched() {
		//printing staff schedules
		for (Staff s: this.staffList) {
			System.out.println("the schedule for employee" + s.getName());
			s.printSchedule();
			System.out.printf("staff: "+ s.getName() + " earns  %.2f this month", s.earns());
		}
	}
	public void proff_sched() {
		for (Department d: departmentList) {
			System.out.println("Department "+ d.getName() + "\n");
			System.out.println("Printing professor schedules:");
			for (Professor p: d.professors) {
				System.out.println("the schedule for Prof." + p.getName());
				p.printSchedule();
			}
			System.out.println("\n");
		}
	}
	public void stud_sched() {
		System.out.println("Printing student schedules:");
		for (Department d: departmentList) {
			for (Student s: d.getStudentList()) {
				System.out.println("the schedule for student " + s.getName());
				s.printSchedule();
			}
		}
		
		System.out.println("\n");
	}
	
	public void print_sched_info() {
		proff_sched();
		stud_sched();
		staff_sched();
	}
	public void print_roster() {
		
		for (Department d: departmentList) {
			System.out.println("the roster for courses offered by " + d.getName());
			for (CampusCourse c: d.getCampusCourseList()) {
				System.out.println("the roster for " + c.getName());
				for (Person p: c.getStudentRoster()) {
					System.out.println(p.getName());
				}
				System.out.println("\n");
			}
			
			for (OnlineCourse oc: d.getOnlineCourseList()) {
				for (Person p: oc.getStudentRoster()) {
					System.out.println(p.getName());
				}
			}
			System.out.println("\n");
		}
		
	}
	public void printAll() {
		print_depts();
		print_crs();
		print_proffs();		
		print_courses();
		print_cr_sched();
		print_sched_info();
		print_roster();
	}
}
