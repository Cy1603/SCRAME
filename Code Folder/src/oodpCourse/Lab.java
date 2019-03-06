package oodpCourse;
import java.util.*;
import java.io.Serializable;
public class Lab implements Serializable {
	private String labCode;
	private String courseCode;
	private int labVacancy;
	private ArrayList<Student> sList;
	
	public Lab(){};
	
	public Lab(String lName,String courseCode, int lVacancy){
		this.labCode = lName;
		this.courseCode = courseCode;
		this.labVacancy = lVacancy;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getLabCode() {
		return labCode;
	}
	
	public void setVacancy(int vacancy) {
		labVacancy = vacancy;
	}
	
	public int getVacancy() {
		return labVacancy;
	}
	
	public boolean checkFullCapacity() {
		if(labVacancy>0) return false;
		else return true;
	}
	
	public void setStudent(Student s) {
		sList.add(s);
		labVacancy--;
	}
	
	public ArrayList<Student> getStudentList() { 
		return sList;
	}
	
	public boolean checkStudentRegistered(Student s) {
		for(int i=0; i<sList.size(); i++) {
			if(s == sList.get(i)) return true;
		} return false;
	}
}
