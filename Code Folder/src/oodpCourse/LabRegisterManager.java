package oodpCourse;
import java.util.*;
public class LabRegisterManager {

	private CourseController cControl;
	private LabController lControl;
	private StudentController sControl;
	private ArrayList<LabRegister> lrList;
	private ArrayList<Student> sList;
	private ArrayList<Lab> lList;
	
	public LabRegisterManager (CourseController cControl, StudentController sControl, ArrayList<LabRegister> lrList) {
		this.lrList = lrList;
		this.sControl = sControl;
		this.cControl = cControl;
	}
	
	public ArrayList<Student> getStudentsInLab(String lCode){
		ArrayList<Student> sTemp = new ArrayList<Student>();
		for(int i=0; i<lrList.size(); i++) {
			if(lrList.get(i).getLab().getLabCode().equals(lCode))
				sTemp.add(sControl.getStudent(lrList.get(i).getStudent().getID()));
		}
		return sTemp;
	}
	
	public void printStudentsInLab(String lCode) {
		PrintStudentUI printer = new PrintStudentUI(this);
		ArrayList<Student> sTemp = getStudentsInLab(lCode);
		for(int i=0;i<sTemp.size();i++) {
			printer.print(sTemp.get(i).getName());
		}
	}
	
	public ArrayList<Lab> getLabOfStudent(String sID){
		for(int i=0; i<lrList.size(); i++) {
			if(lrList.get(i).getStudent().getID().equals(sID))
				lControl = new LabController(cControl.getCourse(lrList.get(i).getCourse().getCourseCode()).getLab());
				lList.add(lControl.getLab(lrList.get(i).getLab().getLabCode()));
		}
		return lList;
	}
	
	public boolean checkStudentRegistered(String sID, String cCode, String lCode) {
		for(int i=0; i<lrList.size(); i++) {
			if(lrList.get(i).getStudent().getID().equals(sID) && lrList.get(i).getCourse().getCourseCode().equals(cCode) && lrList.get(i).getLab().getLabCode().equals(lCode))
				return true;
			
		}
		return false;
	}
	
	public ArrayList<LabRegister> addStudentinLab(String studentID, String courseID ,String lCode) {
		
		Course course1 = cControl.getCourse(courseID);
		LabController lControl = new LabController(course1.getLab()); 
		
		//check if lab exists
		if(lControl.checkLabExist(lCode) == false) {
			System.out.println("Lab ID does not exist ");
			return lrList;
		}
		
		//check if student already in
		if(checkStudentRegistered(studentID,courseID,lCode) == true) {
			System.out.println("This Student is already in Lab!");
		}
		else if(lControl.checkFullCapacity(lCode) == true) {
			System.out.println("This Lab Class is full!");
		}

		else {
			lrList.add(new LabRegister(sControl.getStudent(studentID),course1,lControl.getLab(lCode)));
		}
		return lrList;
	}
	public LabRegister getLastAddedLabRegister() {
		return lrList.get(lrList.size()-1);
	}
}
