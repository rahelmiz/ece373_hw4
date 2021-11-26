package org.university.people;

import java.io.Serializable;

import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public abstract class Employee extends Person implements Serializable{
	public abstract double earns();
	public abstract void raise(Integer i);

}
