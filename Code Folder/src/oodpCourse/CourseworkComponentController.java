package oodpCourse;
import java.util.*;

public class CourseworkComponentController {
	private ArrayList<CourseworkComponent> ccList;
	
	CourseworkComponentController(ArrayList<CourseworkComponent> ccList){
		this.ccList = ccList;
	}
	
	public ArrayList<CourseworkComponent> addComponent(String name, int weightage) {
		CourseworkComponent ccTemp = new CourseworkComponent(name,weightage);
		ccList.add(ccTemp);
		return ccList;
	}
	
	public boolean checkComponentExist(String ccName) {
		for(int i=0; i<ccList.size();i++) {
			if(ccList.get(i).getName().equals(ccName)) return true;
		}return false;
	}
	
	public CourseworkComponent getLastAddedCourseworkComponent() {
		return ccList.get(ccList.size()-1);
	}
	
	public ArrayList<CourseworkComponent> getCourseworkComponentList() {
		return ccList;
	}
	
	public int getCourseworkComponentWeightage(String ccName) {
		for(int i=0; i<ccList.size(); i++) {
			if(ccName.equals(ccList.get(i).getName())) {
				return ccList.get(i).getWeightage();
			}
		}
		return 1;
	}
	
}
