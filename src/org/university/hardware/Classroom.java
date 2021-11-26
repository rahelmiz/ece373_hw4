package org.university.hardware;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import org.university.people.ScheduleMap;
import org.university.people.Student;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.University;

public class Classroom implements Serializable{
	private String name;
	private String roomNumber;
	private String LazyMemory = "";
	public ArrayList<CampusCourse> courses = new ArrayList<CampusCourse> ();
	private ScheduleMap Map = new ScheduleMap();


	public String getRoomNumber() {
		return this.roomNumber;
	}
	
	public String setRoomNumber(String r) {
		return this.roomNumber = r;
	}
	
	public boolean detectConflict(CampusCourse c) {
		boolean conflict = false;
		for (Integer course_time: c.getSchedule()) {
	    	for (CampusCourse sc: this.courses) {
	  			for (Integer class_time: sc.getSchedule()){
	  			
	  				if (course_time != class_time) {
	  					conflict = false;
	  				}
	  				else {
	  					conflict = true;
	  					System.out.println(c.getCode() + " conflicts with " + sc.getCode() + ". " +
	  							"Conflicting time slot " + getDay(course_time.toString())+ " " + getSlot(course_time.toString()) );
	  					
	  					//return conflict;
	  				}
	  			}
	    	}
		}
		return conflict;
	}
	
	
	
	public void printSchedule() {
		for(CampusCourse cc:this.courses) {
			String Name = cc.getName();
			for(Integer ii: cc.getSchedule()) {
				String Message = this.getDay(ii.toString())+ " " + this.getSlot(ii.toString()) + " " + cc.getCode() + " " + Name;
				System.out.println(Message);
			}
			//String CourseNumber = ii.getCourseNumber().toString();
			System.out.println("\n");
		}
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
	public static void saveData(Classroom c) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("Classroom.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(c);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

}
	
	
