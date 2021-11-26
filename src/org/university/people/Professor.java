package org.university.people;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Professor extends Employee{
	//private String name;
	private Integer Salary;
	//private Department department;
	//private ArrayList<Course> courses = new ArrayList<Course> ();
	private String LazyMemory = "";
	private ScheduleMap Map = new ScheduleMap();
	
	


	//public String getCode(Course C) {
	//	return this.getDepartment().getDepartmentName() + C.getCourseNumber().toString();
	//}


	@Override
	public void addCourse(CampusCourse c ) {
		boolean conflict = detectConflict(c);
		if (conflict == true) {
		}
		else if (c.getProfessor() != null) {
			System.out.println("The professor cannot be assigned to this course because professor " + c.professor.getName() + " is already assigned to the course " + c.getName() + ".");
			this.LazyMemory = "";
		}
		
		else {
			this.campus_courses.add(c);
			c.setProfessor(this);
			//c.department.addProfessor(this); //add proff to the course department
		}
	}
	@Override
	public void addCourse(OnlineCourse oCourse) {
		if (oCourse.getProfessor() == null) {
			this.online_courses.add(oCourse);
			oCourse.professor = this;
		}
		else {
			System.out.println( "The professor cannot be assigned to this course, because professor " + this.getName()+ " is already assigned to the course "+ oCourse.getName() ); 

		}
		
	}
	//checks if each of the proffessor's teaching times are in the 
	//course to be added's schedule.
	// appear in the time slots during which the classroom is in use (via unpack_schedule)
	
	
	
	public void printSchedule() {
		for(CampusCourse CC:this.campus_courses) {
			String Name = CC.getName();
			for(Integer ii: CC.getSchedule()) {
				String Message = this.getDay(ii.toString())+ " " + this.getSlot(ii.toString()) + " " + Name;
				System.out.println(Message);
			}
			//String CourseNumber = ii.getCourseNumber().toString();
			System.out.println("\n");
		}
		for(OnlineCourse OC:this.online_courses) {
				System.out.println(OC.getCode() +" "+ OC.getName());
			
			//String CourseNumber = ii.getCourseNumber().toString();
			System.out.println("\n");
		}
	}
	protected String getDay(String SlotString){
		char Index1 = SlotString.charAt(0);
		Integer Index2 = Index1 - '0';
		return this.Map.Days[Index2 - 1];
	}
	protected String getSlot(String SlotString) {
		char Index1 = SlotString.charAt(2);
		Integer Index2 = Index1 - '0';
		return this.Map.Slots[Index2 - 1];
	}
	
	@Override
	public double earns() {
		return this.Salary/ 26;
	}
	@Override
	public void raise(Integer percent) {
		this.Salary = this.Salary* (1+ percent);
		
	}

	public void setSalary(Integer i) {
		this.Salary = i; 
		
	}

	public static void saveData(Professor P) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("Professor.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(P);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

}
