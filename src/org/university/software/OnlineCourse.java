package org.university.software;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.university.people.Student;

public class OnlineCourse extends Course {
	
	@Override
	public boolean availableTo(Student s) {
		boolean available = true;
		Integer campus_credits = s.CampusCredits();
		if (campus_credits >= 6) {
			available = true;
		}
		else {
			available = false;
			System.out.println("Student " + s.getName() + " has only " + s.CampusCredits().toString() + 
					".Students should have at least 6 units registered before registering for online courses.");
		}
		return available;
	}

	public void setCreditUnits(int i) {
		this.numCredits = i;
		
	}
	public static void saveData(OnlineCourse OC) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("OnlineCourse.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(OC);
			objOut.close();
			fileOut.close();
		}
		catch(IOException i ){
			i.printStackTrace();
		}
	}

}
