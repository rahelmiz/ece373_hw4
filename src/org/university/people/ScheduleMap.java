package org.university.people;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.university.software.CampusCourse;

public class ScheduleMap implements Serializable{
	public String[] Days = {"Mon","Tue","Wed","Thu","Fri"};
	public String[] Slots = {"8:00am to 9:15am",
			"9:30am to 10:45am",
			"11:00am to 12:15pm",
			"12:30pm to 1:45pm",
			"2:00pm to 3:15pm",
			"3:30pm to 4:45pm"};
	public static void saveData(ScheduleMap M) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("ScheduleMap.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(M);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

}
