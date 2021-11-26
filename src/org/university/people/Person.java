package org.university.people;

import java.io.Serializable;
import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;
import org.university.hardware.Classroom;

public abstract class Person implements Serializable{
	protected String name;
	protected Department dept;
	protected ArrayList<CampusCourse> campus_courses = new ArrayList<CampusCourse> ();
	protected ArrayList<OnlineCourse> online_courses = new ArrayList<OnlineCourse> ();

	protected ScheduleMap Map = new ScheduleMap();
	
	public boolean detectConflict(CampusCourse c) {
		boolean conflict = false;
		for (Integer course_time: c.getSchedule()) {
	    	for (CampusCourse sc: this.campus_courses) {
	  			for (Integer class_time: sc.getSchedule()){
	  				//System.out.println(c.getCode() + "=>" + course_time + "\t/\t" + sc.getCode() + "=>" + class_time);
	  				
	  				if(class_time.equals(course_time)) {
	  					
	  					conflict = true;
	  					System.out.println(c.getCode() + " course cannot be added to " + this.getName() + "'s schedule. " +
	  							c.getCode() + " conflicts with " + sc.getCode()+ ". " 
	  							+"Conflicting time slot " + getDay(course_time.toString())+ " " + getSlot(course_time.toString()) );
	  					
	  					//return conflict;
	  				}
	  			}
	    	}
		}
		
		return conflict;
	}
	//ECE107 course cannot be added to Tharp's Schedule. ECE107 conflicts with ECE320. Conflicting time slot is Mon 9:30am to 10:45am.

	public void printSchedule() {
		for(CampusCourse CC:this.campus_courses) {
			String Name = CC.getName();
			for(Integer ii: CC.getSchedule()) {
				String Message = this.getDay(ii.toString())+ " " + this.getSlot(ii.toString()) + " " + Name;
				System.out.println(Message);
			}
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
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(Department dept) {
		this.dept = dept;
	}
	public Department getDepartment() {
		return this.dept;
	}

	public Integer CampusCredits() {
		Integer credits = 0;
		for (CampusCourse cc: this.campus_courses) {
			credits += cc.getNumCredits();
		}
		return credits;
	}
	
	public Integer OnlineCredits() {
		Integer credits = 0;
		for (OnlineCourse cc: this.online_courses) {
			credits += cc.getNumCredits();
		}
		return credits;
	}
	
	public abstract void addCourse(CampusCourse cCourse);
	public abstract void addCourse(OnlineCourse oCourse);
}
