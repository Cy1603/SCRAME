package oodpCourse;

import java.io.*;

public class TutorialRegister implements Serializable{

	private Student s;
	private Course c;
	private Tutorial t;
	private LabRegister lRegister;
	
	public TutorialRegister(Student s, Course c, Tutorial t) {
		this.s = s;
		this.c = c;
		this.t = t;
	}
	
	public void setStudent(Student s) {
		this.s = s;
	}
	
	public Student getStudent() {
		return s;
	}
	
	public void setCourse(Course c) {
		this.c = c;
	}
	
	public Course getCourse() {
		return c;
	}
	
	public void setTutorial(Tutorial t) {
		this.t = t;
	}
	
	public Tutorial getTutorial() {
		return t;
	}
	
	public void setLabRegister(LabRegister lRegister) {
		this.lRegister = lRegister;
	}
	
	public LabRegister getLabRegister() {
		return lRegister;
	}
}
