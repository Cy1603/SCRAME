package oodpCourse;
import java.util.*;

public class TutorialController {
	private ArrayList<Tutorial> tList;
	
	public TutorialController(ArrayList<Tutorial> tList){
		this.tList = tList;
	}
	
	public void addtut(String tName, String courseCode, int tVacancy) {
		Tutorial t = new Tutorial(tName,courseCode,tVacancy);
		tList.add(t);
	}
	
	public Tutorial getLastAddedTutorial() {
		return tList.get(tList.size()-1);
	}
	
	public Tutorial getTutorial(String tutorialCode) {
		Tutorial tTemp = new Tutorial();
		for(int i=0; i<tList.size(); i++) {
			if(tutorialCode.equals(tList.get(i).getTutorialCode())) tTemp = tList.get(i);
		} return tTemp;
	}
	
	public boolean checkTutorialExist(String tutorialCode) {
		for(int i=0; i<tList.size(); i++) {
			if(tutorialCode.equals(tList.get(i).getTutorialCode())) return true;
		} return false;
	}
	
	public void reduceVacancy(String tutorialCode) {
		getTutorial(tutorialCode).setVacancy(getTutorial(tutorialCode).getVacancy()-1);
	}
	
	public boolean checkFullCapacity(String tutorialCode) {
		if(getTutorial(tutorialCode).getVacancy()>0) return false;
		else return true;
	}
	
	public boolean checkStudentRegistered(Tutorial t, Student s) {
		ArrayList<Student> sList = t.getStudentList();
		for(int i=0; i<sList.size(); i++) {
			if(s == sList.get(i)) return true;
		} return false;
	}
}
