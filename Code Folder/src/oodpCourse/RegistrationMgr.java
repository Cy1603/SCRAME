package oodpCourse;

import java.util.ArrayList;

public class RegistrationMgr {

	private CourseController cControl;
	private StudentController sControl;
	private ArrayList<Register> rList;
	private ArrayList<TutorialRegister> trList;
	private ArrayList<LabRegister> lrList;
	private ArrayList<Student> sList; 
	private ArrayList<Course> cList;
	private RegisterStudentUI printer = new RegisterStudentUI(this);
	
	public RegistrationMgr(ArrayList<Course> cList, ArrayList<Student> sList, ArrayList<Register> rList, ArrayList<TutorialRegister> trList, ArrayList<LabRegister> lrList) {
		this.cControl = new CourseController(cList);
		this.sControl = new StudentController(sList);
		this.cList = cList;
		this.sList = sList;
		this.rList = rList;
		this.trList = trList;
		this.lrList = lrList;
	}
	
	public ArrayList<Student> getStudentsInCourse(String courseID){
		ArrayList<Student> sTemp = new ArrayList<Student>();
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getCourse().getCourseCode().equals(courseID)) //string comparison
				sTemp.add(sControl.getStudent(rList.get(i).getStudent().getID())); 
		}
		return sTemp;
	}
	
	public void printStudentsInCourse(String courseID) {
		int count = 0;
		PrintStudentUI printer = new PrintStudentUI(this);
		ArrayList<Student> sTemp = getStudentsInCourse(courseID);
		for(int i=0;i<sTemp.size();i++) {
			printer.print(sTemp.get(i).getName());
			count++;
		}
		if (count==0) {
			printer.print("No student registered");
		}
	}
	
	public ArrayList<Course> getCourseOfStudent(String sID){
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getStudent().getID().equals(sID)) //String comparison
				cList.add(cControl.getCourse(rList.get(i).getCourse().getCourseCode())); //Add course to course list
		}
		return cList; //return course list to boundary to update main controller
	}
	
	public ArrayList<Register> CoursesThatStudentRegistered(String studentID){
		ArrayList<Register> al = new ArrayList<Register>();
		for(int i = 0 ; i<rList.size(); i++) {
			if(rList.get(i).getStudent().getID().equals(studentID)) { 
				al.add(rList.get(i));
			}
		}
		
		return al;
	}
	
	public double getCourseResults(String courseID) {
		double totalResult = 0;
		int count = 0;
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getCourse().getCourseCode().equals(courseID)) { 
				ArrayList<Result> resultList = rList.get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, cControl);
				totalResult += rmTemp.getTotalResultMarks();
				count++;
			}
		}
		totalResult /= count;
		return totalResult;
	}
	
	public double getExamResults(String courseID) {
		double totalExamResult = 0;
		int count = 0;
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getCourse().getCourseCode().equals(courseID)) { 
				ArrayList<Result> resultList = rList.get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, cControl);
				totalExamResult += rmTemp.getTotalExamMarks();
				count++;
			}
		}
		totalExamResult /= count;
		return totalExamResult;
	}
	
	public double getCourseworkResults(String courseID) {
		double totalCourseworkResult = 0;
		int count = 0;
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getCourse().getCourseCode().equals(courseID)) { 
				ArrayList<Result> resultList = rList.get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, cControl);
				totalCourseworkResult += rmTemp.getTotalCourseworkMarks();
				count++;
			}
		}
		totalCourseworkResult /= count;
		return totalCourseworkResult;
	}
	
	public boolean checkCourseHasLab(String courseID) {
		return cControl.checkCourseHasLab(cControl.getCourse(courseID)); //using CourseManager to check if Course Has Labs
	}
	
	public boolean checkCourseHasTut(String courseID) {
		return cControl.checkCourseHasTutorial(cControl.getCourse(courseID)); //using CourseManager to check if Course Has Tutorials
	}
	
	public boolean checkStudentRegistered(String sID, String courseID) {
		for(int i=0; i<rList.size(); i++) {
			if((rList.get(i).getStudent().getID().equals(sID)) && (rList.get(i).getCourse().getCourseCode().equals(courseID))) 
				return true;
		}
		return false;
	}
	
	public Register getStudentRegister(String sID, String courseID) {
		Register rTemp = new Register();
		for(int i=0; i<rList.size(); i++) {
			if((rList.get(i).getStudent().getID().equals(sID)) && (rList.get(i).getCourse().getCourseCode().equals(courseID))) 
				rTemp = rList.get(i);
			
		}
		return rTemp;
	}
	
	public Register getLastAddedRegister() {
		return rList.get(rList.size()-1);
	}
	
	public void addStudentinCourse(String studentID, String courseID) {		
		if(!checkStudentRegistered(studentID,courseID)) {
			rList.add(new Register(sControl.getStudent(studentID), cControl.getCourse(courseID))); 
			ResultManager rmTemp = new ResultManager(getLastAddedRegister().getResultList(), cControl);
			ArrayList<CourseworkComponent> ccListTemp = cControl.getCourse(courseID).getCourseworkComponent();
			for(int i=0; i<ccListTemp.size();i++) {
				rmTemp.addResultComponent(studentID, courseID, ccListTemp.get(i).getName());
			}
			getLastAddedRegister().setResultList(rmTemp.getResultList());
			cControl.reduceVacancy(courseID);
		}
		else
			printer.printStudentRegistered(); 
	}
	
	public boolean addStudentinTut(String studentID, String courseID ,String TutID) {
		TutorialRegisterManager trControl = new TutorialRegisterManager(cControl,sControl,trList);
		if(!trControl.checkStudentRegistered(studentID, courseID, TutID)) {
			TutorialController tControl = new TutorialController(cControl.getCourse(courseID).getTutorial());
			trList = trControl.addStudentinTut(studentID, courseID, TutID);
			if(tControl.checkTutorialExist(TutID) && !(tControl.checkFullCapacity(TutID))) {
				getLastAddedRegister().setTutorialRegister(trControl.getLastAddedTutorialRegister());
				tControl.reduceVacancy(TutID);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			printer.printStudentRegistered();
			return false;
		}
	}
	
	public boolean addStudentinLab(String studentID, String courseID ,String LabCode) {
		TutorialRegisterManager trControl = new TutorialRegisterManager(cControl,sControl,trList);
		LabRegisterManager lrControl = new LabRegisterManager(cControl,sControl,lrList);
		if(!lrControl.checkStudentRegistered(studentID, courseID, LabCode)) {
			LabController lControl = new LabController(cControl.getCourse(courseID).getLab());
			lrList = lrControl.addStudentinLab(studentID, courseID, LabCode);
			if(lControl.checkLabExist(LabCode) && !lControl.checkFullCapacity(LabCode)) {
				trControl.getLastAddedTutorialRegister().setLabRegister(lrControl.getLastAddedLabRegister());
				lControl.reduceVacancy(LabCode);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			printer.printStudentRegistered();
			return false;
		}
	}

	public CourseController getCourseController() {
		return cControl;
	}
	
	public StudentController getStudentController() {
		return sControl;
	}
	
	public ArrayList<TutorialRegister> getTRList() {
		return trList;
	}

	public ArrayList<LabRegister> getLRList() {
		return lrList;
	}
	
	public ArrayList<Course> getCourseList(){
		return cList;
	}
	
	public ArrayList<Student> getStudentList() {
		return sList;
	}
	
	public ArrayList<Register> getRList() {
		return rList;
	}
}