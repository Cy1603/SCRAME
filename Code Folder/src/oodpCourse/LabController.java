package oodpCourse;

import java.util.ArrayList;

public class LabController {
	private ArrayList<Lab> lList;
	
	public LabController(ArrayList<Lab> lList){
		this.lList = lList;
	}
	
	public void addlab(String lName, String courseCode, int lVacancy) {
		Lab l = new Lab(lName,courseCode,lVacancy);
		lList.add(l);
	}
	
	public Lab getLastAddedLab() {
		return lList.get(lList.size()-1);
	}
	
	public Lab getLab(String labCode) {
		Lab lTemp = new Lab();
		for(int i=0; i<lList.size(); i++) {
			if(labCode.equals(lList.get(i).getLabCode())) lTemp = lList.get(i);
		} return lTemp;
	}
	
	public boolean checkLabExist(String labCode) {
		for(int i=0; i<lList.size(); i++) {
			if(labCode.equals(lList.get(i).getLabCode())) return true;
		} return false;
	}
	
	public boolean checkFullCapacity(String l) {
		if(getLab(l).getVacancy()>0) return false;
		else return true;
	}
	
	public void reduceVacancy(String labCode) {
		getLab(labCode).setVacancy(getLab(labCode).getVacancy()-1);
	}
	
	
	public boolean checkStudentRegistered(Lab l, Student s) {
		ArrayList<Student> sList = l.getStudentList();
		for(int i=0; i<sList.size(); i++) {
			if(s == sList.get(i)) return true;
		} return false;
	}
}
