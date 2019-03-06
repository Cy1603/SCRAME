package oodpCourse;
import java.util.*;

public class PrintStudentUI {

	private static Scanner sc = new Scanner(System.in);
	
	private String courseID;
	private String tutCode;
	private String labCode;
	private int choice;
	private RegistrationMgr rControl;
	private TutorialRegisterManager trControl;
	private LabRegisterManager lrControl;
	
	public PrintStudentUI(RegistrationMgr rControl) {
		this.rControl=rControl;
	}
	public PrintStudentUI(TutorialRegisterManager trControl) {
		this.trControl=trControl;
	}
	public PrintStudentUI(LabRegisterManager lrControl) {
		this.lrControl=lrControl;
	}
	
	
	public int chooseType() { //get user input
		do {
			try {
				System.out.println("Please choose type of class:");
				System.out.println("1. Lecture");
				System.out.println("2. Tutorial");
				System.out.println("3. Lab");
				choice = sc.nextInt();
				if(!(choice==1||choice==2||choice==3)) {
					System.out.println("Choice is only 1-3.");
				}
			}catch(InputMismatchException e) {
				System.out.println("Please input a valid integer from 1-3!");
				sc.next();
				choice =0;
			}
		}while(!(choice==1||choice==2||choice==3));
		return choice;
	}
	
	public void print(String output) {
		System.out.println(output);
	}
	
	public void getLecture() { 
		do {
			System.out.println("Please enter Course ID:");
			courseID = sc.next();
			if(!rControl.getCourseController().checkCourseExist(courseID))
				System.out.println("Course does not exist. Please re-input.");
		}while(!rControl.getCourseController().checkCourseExist(courseID));
		rControl.printStudentsInCourse(courseID);
	}
	
	public void getTutorial() {
		do {
			System.out.println("Please enter Course ID:");
			courseID = sc.next();
			if(!rControl.getCourseController().checkCourseExist(courseID))
				System.out.println("Course does not exist. Please re-input.");
		}while(!rControl.getCourseController().checkCourseExist(courseID));
		if(!rControl.checkCourseHasTut(courseID)) {
			System.out.println("Course does not have tutorial.");
			return;
		}
		
		TutorialController tControl = new TutorialController(rControl.getCourseController().getCourse(courseID).getTutorial());
		do {
			System.out.println("Please enter Tutorial Code:");
			tutCode = sc.next();

			if(!tControl.checkTutorialExist(tutCode)) {
				System.out.println("Tutorial code does not exist. Please re-input.");
			}
		}while(!tControl.checkTutorialExist(tutCode));
		TutorialRegisterManager trControl = new TutorialRegisterManager(rControl.getCourseController(),rControl.getStudentController(),rControl.getTRList());
		trControl.printStudentsInTutorial(courseID,tutCode);
		
	}
	
	public void getLab() {
		do {
			System.out.println("Please enter Course ID:");
			courseID = sc.next();
			if(!rControl.getCourseController().checkCourseExist(courseID))
				System.out.println("Course does not exist. Please re-input.");
		}while(!rControl.getCourseController().checkCourseExist(courseID));
		if(!rControl.checkCourseHasLab(courseID)) {
			System.out.println("Course does not have lab.");
			return;
		}
		LabController lControl = new LabController(rControl.getCourseController().getCourse(courseID).getLab());
		do {
			System.out.println("Please enter Lab Code:");
			labCode = sc.next();
			
			if(!lControl.checkLabExist(labCode)) {
				System.out.println("Lab code does not exist. Please re-input.");
			}
		}while(!lControl.checkLabExist(labCode));
		LabRegisterManager lrControl = new LabRegisterManager(rControl.getCourseController(),rControl.getStudentController(),rControl.getLRList());
		lrControl.printStudentsInLab(labCode);
	}
}
