package oodpCourse;
import java.util.*;
import java.io.Serializable;

public class Tutorial implements Serializable {

	private String courseCode;
	private String tutorialCode;
	private int tutorialVacancy;
	private ArrayList<Student> sList;
	
	public Tutorial(){};
	
	public Tutorial(String tCode, String courseCode, int tVacancy) {
		this.tutorialCode = tCode;
		this.courseCode = courseCode;
		this.tutorialVacancy = tVacancy;
	}
	
	public String getTutorialCode() {
		return tutorialCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setVacancy(int vacancy) {
		tutorialVacancy = vacancy;
	}
	
	public int getVacancy() {
		return tutorialVacancy;
	}
	
	public void setStudent(Student s) {
		sList.add(s);
		tutorialVacancy--;
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
