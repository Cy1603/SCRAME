package oodpCourse;
import java.util.*;

public class CheckAvailSlotUI {

	private static Scanner sc = new Scanner(System.in);
	
	private String courseID;
	private String tutCode;
	private String labCode;
	private int choice;
	private int vacancy;
	private CourseController cControl;
	
	public CheckAvailSlotUI(CourseController cControl) {
		this.cControl = cControl;
	}
	
	public int chooseType() {
		do {
			try {
			System.out.println("Please choose type of class:");
			System.out.println("1. Lecture");
			System.out.println("2. Tutorial");
			System.out.println("3. Lab");
			choice = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Please input a valid integer(1-3)!");
				sc.next();
			}
		}while(!(choice== 1 || choice == 2 || choice ==3));
		sc.nextLine();
		return choice;
	}
	
	public void getLecture() {
		do{
			System.out.println("Please enter Course ID:");
			courseID = sc.next();
			if(!cControl.checkCourseExist(courseID)) {
				System.out.println("Course does not exist. Please key in an available course.");
			}
		}while(!cControl.checkCourseExist(courseID));
		
		vacancy = cControl.getCourse(courseID).getVacancy();
		System.out.println("Vacancy for Course "+courseID+": " + vacancy+"/100");
	}
	
	public void getTutorial() {
		do{
			System.out.println("Please enter Course ID:");
			courseID = sc.next();
			if(!cControl.checkCourseExist(courseID)) {
				System.out.println("Course does not exist. Please key in an available course.");
			}
		}while(!cControl.checkCourseExist(courseID));
		TutorialController tControl = new TutorialController(cControl.getCourse(courseID).getTutorial());
		do {
			System.out.println("Please enter Tutorial Code:");
			tutCode = sc.next();
			if(!tControl.checkTutorialExist(tutCode)) {
				System.out.println("Tutorial does not exist. Please key in an available tutorial code.");
			}	
		}while(!tControl.checkTutorialExist(tutCode));
		
		vacancy = tControl.getTutorial(tutCode).getVacancy();
		System.out.println("Vacancy for Course "+courseID+", Tutorial "+tutCode+": " + vacancy+"/10");
	}
	
	public void getLab() {
		do{
			System.out.println("Please enter Course ID:");
			courseID = sc.nextLine();
			if(!cControl.checkCourseExist(courseID)) {
				System.out.println("Course does not exist. Please key in an available course.");
			}
		}while(!cControl.checkCourseExist(courseID));
		LabController lControl = new LabController(cControl.getCourse(courseID).getLab());
		do{
			System.out.println("Please enter Lab Code:");
			labCode = sc.nextLine();
			if(!lControl.checkLabExist(labCode)) {
				System.out.println("Lab does not exist. Please key in an available lab code.");
			}
		}while(!lControl.checkLabExist(labCode));
			
		
		vacancy = lControl.getLab(labCode).getVacancy();
		System.out.println("Vacancy for Course "+courseID+", Lab "+labCode+": " + vacancy+"/10");
	}
}
