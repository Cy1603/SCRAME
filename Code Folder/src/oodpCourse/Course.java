package oodpCourse;
import java.util.*;
import java.io.Serializable;

public class Course implements Serializable, CourseType {
	
	private ArrayList<CourseworkComponent> ccList = new ArrayList<CourseworkComponent>();
	private ArrayList<Tutorial> tList = new ArrayList<Tutorial>();
	private ArrayList<Lab> lList = new ArrayList<Lab>();
	private String CourseName;
	private String CourseCode;
	private Professor CourseCoordinator;
	private int CourseVacancy;
	private int ExamWeightage;
	
	public Course(){};
	
	public Course(String name, String code, int vacancy, int ExamWeightage, Professor CourseCoordinator){
		this.CourseName = name;
		this.CourseCode = code;
		this.CourseVacancy = vacancy;
		this.ExamWeightage = ExamWeightage;
		this.CourseCoordinator = CourseCoordinator;
	}
	
	public void setName(String name) {
		this.CourseName = name;
	}
	
	public String getName() {
		return CourseName;
	}
	
	public void setCourseCode(String code) {
		this.CourseCode = code;
	}
	
	public String getCourseCode() {
		return CourseCode;
	}
	
	public void setVacancy(int vacancy) {
		this.CourseVacancy = vacancy;
	}
	
	public int getVacancy() {
		return CourseVacancy;
	}
	
	public void setExamWeightage(int ExamWeightage) {
		this.ExamWeightage = ExamWeightage;
	}
	
	public int getExamWeightage() {
		return ExamWeightage;
	}
	
	public void setCourseworkComponent(CourseworkComponent cc) {
		ccList.add(cc);
	}
	
	public void setCourseworkComponentList(ArrayList<CourseworkComponent> ccList) {
		this.ccList = ccList;
	}
	
	public ArrayList<CourseworkComponent> getCourseworkComponent() {
		return ccList;
	}
	
	public void setTutorial(Tutorial t) {
		tList.add(t);
	}
	
	public ArrayList<Tutorial> getTutorial() {
		return tList;
	}
	
	public void setLab(Lab l) {
		lList.add(l);
	}
	
	public ArrayList<Lab> getLab() {
		return lList;
	}
	
	public Professor getCourseCoordinator() {
		return CourseCoordinator;
	}
}
