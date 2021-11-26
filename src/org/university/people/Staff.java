package org.university.people;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public class Staff extends Employee{
	Double payRate;
	Integer hoursWorked;
	Integer tuitionFee;
 
	public String getName() {
		return this.name;
	}

	@Override
	public double earns() {
		return this.hoursWorked * payRate;
	}

	@Override
	public void raise(Integer i) {
		this.payRate = this.payRate*(1+i);
		
	}

	@Override
	public void addCourse(CampusCourse cCourse) {
		if (this.campus_courses.size() == 0) {
			this.campus_courses.add(cCourse);
			cCourse.addStudent(this);
			cCourse.getDepartment().addStaff(this);
		}
		else {
			//S387 is removed from Carol's schedule(Staff can only take one class at a time). CS372 has been added to Carol's Schedule.
			this.campus_courses.set(0,cCourse);
			System.out.println(this.campus_courses.get(0).getCode() + " is removed from " + this.getName() +"'s schedule(Staff can only take one class at a time)."
					+ cCourse.getCode() + " has been added to " + this.getName() +" Schedule. ");
			cCourse.addStudent(this);
			cCourse.getDepartment().addStaff(this);
		}
		
		
	}

	@Override
	public void addCourse(OnlineCourse oCourse) {
		if (this.online_courses.size() == 0) {
			this.online_courses.add(oCourse);
			
		}
		else {
			this.online_courses.set(0,oCourse);
			System.out.println(this.campus_courses.get(0).getCode() + " is removed from " + this.getName() +"'s schedule(Staff can only take one class at a time)."
					+ oCourse.getCode() + " has been added to " + this.getName() +" Schedule. ");
			}
		oCourse.addStudent(this);
		}
		
	

	public Integer getTuitionFee() {
		this.tuitionFee = this._CampusTuition()+_OnlineTuition();
		return this._CampusTuition()+_OnlineTuition();
	}

	public void setMonthlyHours(int i) {
		this.hoursWorked = i;
		
	}

	public void setPayRate(double d) {
		this.payRate = d;
		
	}
	 
	public Integer _CampusTuition() {
		Integer sum = 0;
		for (CampusCourse cc: this.campus_courses) {
			sum = sum + (cc.getNumCredits()*300);
		}
		return sum;
	}
	public Integer _OnlineTuition() {
		Integer flatFee = 2000;
		for (OnlineCourse oc: this.online_courses) {
			if ((oc.getNumCredits() - 4) == 0) {
				flatFee = 3000;
				return flatFee;
			}
		}
		return flatFee;
		
	}
	public static void saveData(Staff S) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("Staff.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(S);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}
}


	
