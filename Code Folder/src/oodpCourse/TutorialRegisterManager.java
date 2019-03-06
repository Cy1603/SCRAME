package oodpCourse;
import java.util.*;
public class TutorialRegisterManager {

	private CourseController cControl;
	private TutorialController tControl;
	private StudentController sControl;
	private ArrayList<TutorialRegister> trList;
	private ArrayList<Student> sList;
	private ArrayList<Tutorial> tList;
	
	public TutorialRegisterManager (CourseController cControl, StudentController sControl, ArrayList<TutorialRegister> trList) {
		this.trList = trList;
		this.sControl = sControl;
		this.cControl = cControl;
	}
	
	public ArrayList<Student> getStudentsInTutorial(String courseCode, String tCode){
		ArrayList<Student> sTemp = new ArrayList<Student>();
		for(int i=0; i<trList.size(); i++) {
			if(trList.get(i).getTutorial().getTutorialCode().equals(tCode) && trList.get(i).getTutorial().getCourseCode().equals(courseCode))
				sTemp.add(sControl.getStudent(trList.get(i).getStudent().getID()));
		}
		return sTemp;
	}
	
	public void printStudentsInTutorial(String courseCode, String tCode) {
		PrintStudentUI printer = new PrintStudentUI(this);
		ArrayList<Student> sTemp = getStudentsInTutorial(courseCode,tCode);
		for(int i=0;i<sTemp.size();i++) {
			printer.print(sTemp.get(i).getName());
		}
	}
	
	public ArrayList<Tutorial> getTutorialOfStudent(String sID){
		for(int i=0; i<trList.size(); i++) {
			if(trList.get(i).getStudent().getID().equals(sID)) 
				tControl = new TutorialController(cControl.getCourse(trList.get(i).getCourse().getCourseCode()).getTutorial());
				tList.add(tControl.getTutorial(trList.get(i).getTutorial().getTutorialCode()));
		}
		return tList;
	}
	
	public boolean checkStudentRegistered(String sID, String cCode, String tCode) {
		for(int i=0; i<trList.size(); i++) {
			if(trList.get(i).getStudent().getID().equals(sID) && trList.get(i).getCourse().getCourseCode().equals(cCode) && trList.get(i).getTutorial().getTutorialCode().equals(tCode))
				return true;
		}
		return false;
	}
	
	public ArrayList<TutorialRegister> addStudentinTut(String studentID, String courseID ,String tCode) {
		
		Course course1 = cControl.getCourse(courseID);
		TutorialController tControl = new TutorialController(course1.getTutorial()); 
		
		//check if tutorial exists
		if(tControl.checkTutorialExist(tCode) == false) {
			System.out.println("Tutorial Class ID does not exist ");
			return trList;
		}
		
		//check if student already in
		if(checkStudentRegistered(studentID,courseID, tCode) == true) {
			System.out.println("This Student is already in Tutorial!");
		}
		else if(tControl.checkFullCapacity(tCode) == true) {
			System.out.println("This Tutorial Class is full!");
		}

		else {
			trList.add(new TutorialRegister(sControl.getStudent(studentID),course1,tControl.getTutorial(tCode)));
		}
		return trList;
	}
	public TutorialRegister getLastAddedTutorialRegister() {
		return trList.get(trList.size()-1);
	}
}
