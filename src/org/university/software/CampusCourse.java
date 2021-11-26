package org.university.software;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.people.Professor;
import org.university.people.ScheduleMap;
import org.university.people.Student;

public  class CampusCourse extends Course {
	public ArrayList<Integer> schedule = new ArrayList<Integer>();
	private Classroom classroom;
	private ScheduleMap Map = new ScheduleMap();
	public Integer maxCapacity; // max number of students in course

	public String getCode() {
		return this.getDepartment().getDepartmentName() + this.getCourseNumber().toString();
	}
	
	public void setSchedule(int s){
		this.schedule.add(s);
	}
	
	public ArrayList<Integer> getSchedule(){
		return this.schedule;
	}
	
	public void setRoomAssigned(Classroom cr) {
		//before assigning, check if clasroom is available
		boolean conflict = cr.detectConflict(this);
		if (conflict == false) {
			this.classroom = cr;
			cr.courses.add(this);
		}
	}
	public void printSchedule() {

		String b = this.classroom.getRoomNumber();
		for(Integer ii: this.getSchedule()) {
			String Message = this.getDay(ii.toString())+ " " + this.getSlot(ii.toString()) + " " + b;
			System.out.println(Message);
		}
		//String CourseNumber = ii.getCourseNumber().toString();
		System.out.println("\n");

	}
	private String getDay(String SlotString){
		char Index1 = SlotString.charAt(0);
		Integer Index2 = Index1 - '0';
		return this.Map.Days[Index2 - 1];
	}
	private String getSlot(String SlotString) {
		char Index1 = SlotString.charAt(2);
		Integer Index2 = Index1 - '0';
		return this.Map.Slots[Index2 - 1];
	}
	private ArrayList<Integer> unpack_schedule(Classroom cr){ 
		ArrayList<Integer> temp_schedule = new ArrayList<Integer>();
		for (CampusCourse cc: cr.courses) {
			for (Integer course_time: cc.getSchedule()) {
				temp_schedule.add(course_time);
			}
		}
		return temp_schedule;
	}
	public boolean detectConflict(Classroom cr) {
		boolean conflict = false;
		ArrayList<Integer> curr_schedule = unpack_schedule(cr);
		if (curr_schedule.isEmpty() ) {
			return conflict;}
		else {
			for (Integer class_time: curr_schedule) {
				for (Integer course_time: this.schedule) {
					if ((class_time - course_time) == 0) {
						conflict = true;
						return conflict;
						}
				}
			}
			return conflict;
		}
	}
	
	@Override
	public boolean availableTo(Student s) {
	//available if the course has not reached its enrollment limit).
		boolean available = true;
		if (!(this.getStudentRoster().size() < this.maxCapacity)) {
			available = false;
		}
		else {
			available = true;
		}
		return available;
	}

	public void setCreditUnits(Integer i) {
		this.numCredits = i;
		
	}

	public void setMaxCourseLimit(Integer i) {
		this.maxCapacity = i;
		
	}
	public static void saveData(CampusCourse C) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("CampusCourse.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(C);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

}
