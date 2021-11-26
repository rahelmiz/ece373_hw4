package org.university.people;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList; // Needed for the ArrayList class
import java.util.Collections;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;


public class Student extends Person implements Serializable {
	private Integer units_completed=0;
	private Integer requiredCredits=0;
	private Integer currentCredits=0; 
	private Integer tuitionFee=0;
	private ScheduleMap Map = new ScheduleMap();

	
	public void setDepartment(Department dept) {
		this.dept = dept;
	}
	public Department getDepartment() {
		return this.dept;
	}
	public String getCode(Course C) {
		return this.getDepartment().getDepartmentName() + C.getCourseNumber().toString();
	}

	public void dropCourse(CampusCourse c ) {
		if (this.campus_courses.contains(c)){
			Integer flag = this.CampusCredits() - c.getNumCredits();
			if (flag <= 6) {
				System.out.println(this.getName() + " can't drop this " + c.getName() + "  because student doesn't have enough "
						+ "campus course credit to hold online courses.");
			}
			else {
				this.campus_courses.remove(c);
				this.currentCredits-= c.getNumCredits();
				c.removeStudent(this);
			}
		}
		else {
			System.out.println("The course " + this.getCode(c) + 
					" could not be dropped because "+ this.getName() + 
					" is not enrolled in " + this.getCode(c));
		}
	}
	

	public boolean check_exists(CampusCourse course2check) {
		boolean match = false;
		for (CampusCourse cc: this.campus_courses) {
			match = cc.getName().equals(course2check.getName());
			if (match == true) {
				return match;
			}
		}
		return match;
	}
	
	
	//this function just extracts the times from each course in student.courseList  
	//and puts them into a list
	// it is a helper function for detect conflict
	
	

	public void setCompletedUnits(int i) {
		this.units_completed = i;
		
	}

	public int requiredToGraduate() {
		return this.requiredCredits - this.units_completed;
	}

	public void setRequiredCredits(int i) {
		this.requiredCredits = i;
		
	}
	
	
	@Override
	public void addCourse(CampusCourse cCourse) {
		boolean conflict_flag = detectConflict(cCourse);
		if (conflict_flag == false) {
			if (cCourse.availableTo(this)) {
				this.campus_courses.add(cCourse);
				cCourse.addStudent(this);
				cCourse.getDepartment().addStudent(this);
				this.currentCredits += cCourse.getNumCredits();
			}
			else {
				System.out.println(this.getName() + " can't add " + cCourse.getCode()+ " " + cCourse.getName()+ ". Because this Campus course has enough student.");
			}
		}
	}	
	

	@Override
	public void addCourse(OnlineCourse oCourse) {
		boolean available = oCourse.availableTo(this);
		if (available) {
			this.online_courses.add(oCourse);
			oCourse.addStudent(this);
			oCourse.getDepartment().addStudent(this);
			this.currentCredits+=oCourse.getNumCredits();
		}
	}
		

	public Integer getTuitionFee() {
		this.tuitionFee = _CampusTuition()+_OnlineTuition();
		return this._CampusTuition()+_OnlineTuition();
	}
	public void dropCourse(OnlineCourse o) {
		//ArrayList<Integer> ans = check_exists(o);
		// ans looks like [0 or 1, idx]. 
		// ans[0] = 0 if course dne
		// ans[1] tells you the idx of elem, assuming it matched.  
		int counter = 0;
		for (OnlineCourse oc : this.online_courses) {
			if (o.getCourseNumber() - oc.getCourseNumber() == 0) {
				this.online_courses.remove(counter);
				this.currentCredits -= o.getNumCredits();
				return;
			}
			counter = counter + 1;
		}
		//String b = c.getDepartment().getDepartmentName() + c.getCourseNumber().toString();
		System.out.println("The course " + this.getCode(o) + 
				" could not be dropped because "+ this.getName() + 
				" is not enrolled in " + this.getCode(o) + "\n");
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
	public void printSchedule() {
		for(CampusCourse CC:this.campus_courses) {
			String Name = CC.getName();
			for(Integer ii: CC.getSchedule()) {
				String Message = this.getDay(ii.toString())+ " " + this.getSlot(ii.toString()) + " " + Name;
				System.out.println(Message);
				break;
			}
			//String CourseNumber = ii.getCourseNumber().toString();
		}
		for(OnlineCourse OC:this.online_courses) {
				System.out.println(OC.getCode() +" "+ OC.getName());
			
			//String CourseNumber = ii.getCourseNumber().toString();
			System.out.println("\n");
		}
	}
	public static void saveData(Student S) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("Student.ser");
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