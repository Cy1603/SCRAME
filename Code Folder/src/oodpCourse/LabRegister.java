package oodpCourse;
import java.io.*;

public class LabRegister implements Serializable {

	private Student s;
	private Course c;
	private Lab l;
	
	public LabRegister(Student s, Course c, Lab l) {
		this.s = s;
		this.c = c;
		this.l = l;
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
	
	public void setLab(Lab l) {
		this.l = l;
	}
	
	public Lab getLab() {
		return l;
	}
}
