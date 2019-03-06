package oodpCourse;
import java.util.*;
import java.io.Serializable;

public class Student implements Serializable {
	private String fullName;
	private String ID;
	
	public Student() {}
	public Student(String fullName, String ID) {
		this.fullName = fullName;
		this.ID = ID;
	}
	
	public String getName() {
		return fullName;
	}
	
	public String getID() {
		return ID;
	}
}
