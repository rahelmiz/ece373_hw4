package org.university.software;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Professor;
import org.university.people.Staff;
//import org.university.people.Staff;
import org.university.people.Student;
import org.university.software.Course;
import org.university.software.University;
import org.university.software.UniversityGUI;

public class Driver2 {


	// Created by Lahiru Ariyananda and Peter Hall
	// Updated by Yuchao Liao 
	
	public static void main(String[] args) {
	
		
		University univ1 = new University();
		UniversityGUI newGUI;
		University univ2; 

		
		// Create  University of Dept, , buildings, classrooms,  professors,students, staff
	     	
		
		
		// Set Dept
		Department dept1 = new Department();
		Department dept2 = new Department();

		// Set Student
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		
		// Set CampusCourse
		CampusCourse c1 = new CampusCourse();
		CampusCourse c2 = new CampusCourse();
		CampusCourse c3 = new CampusCourse();
		CampusCourse c4 = new CampusCourse();
		CampusCourse c5 = new CampusCourse();
		CampusCourse c6 = new CampusCourse();
		CampusCourse c7 = new CampusCourse();
		CampusCourse c8 = new CampusCourse();
		CampusCourse c9 = new CampusCourse();
		
		/* Set Online Courses */
		OnlineCourse oc1 = new OnlineCourse();
		OnlineCourse oc2 = new OnlineCourse();
		OnlineCourse oc3 = new OnlineCourse();
		OnlineCourse oc4 = new OnlineCourse();
		
		// Set Rooms
		Classroom cr1 = new Classroom();
		Classroom cr2 = new Classroom();
		Classroom cr3 = new Classroom();
		Classroom cr4 = new Classroom();
	
		
		// Set Professor
		Professor p1 = new Professor();
		Professor p2 = new Professor();
		Professor p3 = new Professor();
		Professor p4 = new Professor();
		Professor p5 = new Professor();

		// Set Staff
		Staff sf1 = new Staff();
        
		// Set attributes ,  Initialization 
		
		dept1.setDepartmentName("ECE");
		dept2.setDepartmentName("CS");
        
		
		s1.setName("Lahiru");
		dept1.addStudent(s1);
		s2.setName("Daz");
		dept1.addStudent(s2);
		s3.setName("Yuchao");
		dept2.addStudent(s3);
		s4.setName("Jerry");
		dept2.addStudent(s4);
        
		c1.setCourseNumber(387);
		c1.setName("Enterprise Web Applications");
		c1.setCreditUnits(3);
		c1.setMaxCourseLimit(4);
		dept2.addCourse(c1);

		c2.setCourseNumber(372);
		c2.setName("Comparative Programming Languages");
		c2.setCreditUnits(4);
		c2.setMaxCourseLimit(3);
		dept2.addCourse(c2);

		c3.setCourseNumber(345);
		c3.setName("Discrete Structures");
		c3.setCreditUnits(4);
		c3.setMaxCourseLimit(2);
		dept2.addCourse(c3);

		c4.setCourseNumber(426);
		c4.setName("Computer Networks");
		c4.setCreditUnits(4);
		c4.setMaxCourseLimit(3);
		dept2.addCourse(c4);

		c5.setCourseNumber(275);
		c5.setName("Computer Programming II");
		c5.setCreditUnits(3);
		c5.setMaxCourseLimit(3);
		dept1.addCourse(c5);

		c6.setCourseNumber(320);
		c6.setName("Circuits Analysis");
		c6.setCreditUnits(3);
		c6.setMaxCourseLimit(3);
		dept1.addCourse(c6);

		c7.setCourseNumber(373);
		c7.setName("Object Oriented Software Design");
		c7.setCreditUnits(3);
		c7.setMaxCourseLimit(3);
		dept1.addCourse(c7);

		c8.setCourseNumber(107);
		c8.setName("Experimental Course");
		c8.setCreditUnits(3);
		c8.setMaxCourseLimit(3);
		dept1.addCourse(c8);
		
		c9.setCourseNumber(501);
		c9.setName("test Course");
		c9.setCreditUnits(3);
		c9.setMaxCourseLimit(3);
		
		/* Set Online course name, number and department*/
		oc1.setCourseNumber(610);
		oc1.setName("Online_Course_1");
		oc1.setCreditUnits(3);
		dept1.addCourse(oc1);
		
		oc2.setCourseNumber(620);
		oc2.setName("Online_Course_2");
		oc2.setCreditUnits(3);
		dept1.addCourse(oc2);
		
		oc3.setCourseNumber(630);
		oc3.setName("Online_Course_3");
		oc3.setCreditUnits(3);
		dept2.addCourse(oc3);
		
		
		oc4.setCourseNumber(640);
		oc4.setName("Online_Course_4");
		oc4.setCreditUnits(4);
		dept2.addCourse(oc4);
		
		cr1.setRoomNumber("Harvill 101");
		cr2.setRoomNumber("Harvill 203");
		cr3.setRoomNumber("Gould Simpson 102");
		cr4.setRoomNumber("Gould Simpson 105");
    
		p1.setName("Regan");
		dept1.addProfessor(p1);
		p2.setName("RosenBlit");
		dept1.addProfessor(p2);
		p3.setName("Tharp");
		dept1.addProfessor(p3);
		p4.setName("Kececioglu");
		dept2.addProfessor(p4);
		p5.setName("Homer");
		dept2.addProfessor(p5);
        
		sf1.setName("Carol");
		dept2.addStaff(sf1);
		
		
		univ1.departmentList.add(dept1);
		univ1.departmentList.add(dept2);
        
		univ1.classroomList.add(cr1);
		univ1.classroomList.add(cr2);
		univ1.classroomList.add(cr3);
		univ1.classroomList.add(cr4);
        
		        

		c1.setSchedule(201);
		c1.setSchedule(401);
		c2.setSchedule(202);
		c2.setSchedule(402);
		c3.setSchedule(303);
		c3.setSchedule(503);
		c4.setSchedule(102);
		c4.setSchedule(302);
		c5.setSchedule(303);
		c5.setSchedule(503);
		c6.setSchedule(102);
		c6.setSchedule(302);
		c7.setSchedule(201);
		c7.setSchedule(401);
		c8.setSchedule(102);
    
    
		
		// ****************Initialization ending*****************
        
		
		
	
        
        
		    
		
		// sign up professors
		
		p3.addCourse(c6);
        //sign up Prof. Tharp for class ECE320         
		p4.addCourse(c1);
        //sign up Prof. Kececioglu for class CS387 
		p4.addCourse(c2);
        //sign up Prof.Kececioglu for class CS372 
		p5.addCourse(c3);
        //sign up Prof. Homer for class CS345 
		p5.addCourse(c4);
        //sign up Prof. Homer for class CS426 
        
		
		
		//set classrooms for courses
		c1.setRoomAssigned(cr2);
		c2.setRoomAssigned(cr4);
		c3.setRoomAssigned(cr3);
		c4.setRoomAssigned(cr3);
		c6.setRoomAssigned(cr1);
	    
		
        
		// add course to students
		
		s1.addCourse(c4);
        // add CS426 to student Lahiru
		s1.addCourse(c1);
		
		//s2.addCourse(c2);
		s2.addCourse(c3);
			
		s3.addCourse(c1);
		s3.addCourse(c2);
    	s3.addCourse(c3);
    	s3.addCourse(c4);
        
		s4.addCourse(c1);
		s4.addCourse(c2);
		s4.addCourse(c6);
       
		/* Adding online courses to students */

		s1.addCourse(oc1);
		//s2.addCourse(oc2);
		//s3.addCourse(oc3);
		s4.addCourse(oc4);
		////
		
       // add course to staff 

        sf1.addCourse(c1);
        sf1.setPayRate(20.0);
        sf1.setMonthlyHours(160);
        
        
      
       // Instantiate GUI
        
        newGUI = new UniversityGUI("UniversityGUI", univ1);	
         
         
	}

	

}
