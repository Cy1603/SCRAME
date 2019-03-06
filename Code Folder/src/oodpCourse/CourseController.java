package oodpCourse;
import java.util.*;

public class CourseController {
	private ArrayList<Course> cList;
	private AddTutorial addtutorialboundary; //pass in tutcontrol
	private AddLab addlabboundary;
	
	public CourseController(ArrayList<Course> cList) {
		this.cList = cList;
	}
	public ArrayList<Course> addCourse(String name, String code, int vacancy, int ExamWeightage, Professor CourseCoordinator){
		if(checkCourseExist(code)==false) {
			Course c = new Course(name,code,vacancy,ExamWeightage, CourseCoordinator);
			c.getCourseworkComponent().add(new CourseworkComponent("Exam",ExamWeightage));
			cList.add(c);
		}
		return cList;
	}
	
	public void setCourseList(ArrayList<Course> cList) {
		this.cList = cList;
	}
	
	public Course getCourse(String courseID) {
		Course cTemp = new Course();
		for(int i=0; i<cList.size(); i++) {
			if(courseID.equals(cList.get(i).getCourseCode())) cTemp = cList.get(i);
		} return cTemp;
	}
	
	public Course getLastAddedCourse() {
		return cList.get(cList.size()-1);
	}
	
	public boolean checkCourseExist(String courseID) {
		for(int i=0; i<cList.size(); i++) {
			if(courseID.equals(cList.get(i).getCourseCode())) return true;
		} return false;
	}
	
	public void reduceVacancy(String courseID) {
		getCourse(courseID).setVacancy((getCourse(courseID).getVacancy())-1);
	}
	
	public void addTutorial(Course c) {
		addtutorialboundary = new AddTutorial(c.getTutorial());
		TutorialController tControl = addtutorialboundary.input(c.getCourseCode());
		c.setTutorial(tControl.getLastAddedTutorial());
	}
	
	public void addLab(Course c) {
		addlabboundary = new AddLab(c.getLab());
		LabController lControl = addlabboundary.input(c.getCourseCode());
		c.setLab(lControl.getLastAddedLab());
	}
	
	public boolean checkCourseHasTutorial(Course c) {
		if (c.getTutorial().isEmpty()) return false;
		else return true;
	}
	
	public boolean checkCourseHasLab(Course c) {
		if (c.getLab().isEmpty()) return false;
		else return true;
	}
	public void printAllCourses() {
		for(int i=0; i< cList.size();i++) {
			System.out.println(cList.get(i).getCourseCode()+" "+cList.get(i).getName() +" by "+ cList.get(i).getCourseCoordinator().getProfName());
		}
	}
	public ArrayList<Course> getCourseList() {
		return cList;
	}
}
