package oodpCourse;
import java.util.*;
import java.io.*;
public class Register implements Serializable {

	private Student s; //Change to student
	private Course c; //Change to course
	private ArrayList<Result> resultList = new ArrayList<Result>();
	private TutorialRegister trRegister;
	
	public Register() {}
	
	public Register(Student s, Course c) {
		this.s = s;
		this.c = c; //Use ResultManager to Add results
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
	
	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	
	public void setTutorialRegister(TutorialRegister trRegister) {
		this.trRegister = trRegister;
	}
	
	public TutorialRegister getTutorialRegister() {
		return trRegister;
	}

	public ArrayList<Result> getResultList(){
		return resultList;
	}
}