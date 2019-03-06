package oodpCourse;
import java.util.*;

public class RegisterStudentUI {
	
	private RegistrationMgr RM;
	private String studentidregister;
	private String courseidregister;
	private String tutidregister;
	private String labidregister;
	
	static Scanner sc = new Scanner(System.in);
	
	public RegisterStudentUI() {}
	public RegisterStudentUI(RegistrationMgr RM) {
		this.RM = RM;
	}
	
	public RegistrationMgr StudentRegisterInput() {
		
		do{
			do{
				System.out.println("Enter student ID: ");
				studentidregister = sc.nextLine(); //assign student ID to next input
				if(!RM.getStudentController().checkStudentExist(studentidregister)) {
					System.out.println("Student does not exist!");
				}
			}while(!RM.getStudentController().checkStudentExist(studentidregister));
			do {
				System.out.println("Enter course ID to be registered into");
				courseidregister = sc.nextLine();
				if(!RM.getCourseController().checkCourseExist(courseidregister)) {
					System.out.println("Course does not exist!");
				}
			}while(!RM.getCourseController().checkCourseExist(courseidregister));
			
			if(RM.checkStudentRegistered(studentidregister, courseidregister))
				System.out.println("Student is already registered!");
		}while(RM.checkStudentRegistered(studentidregister, courseidregister));
		
		RM.addStudentinCourse(studentidregister,courseidregister);
		System.out.println("Added to course "+RM.getLastAddedRegister().getCourse().getName());
		
		if(RM.checkCourseHasTut(courseidregister) == true) {
			boolean checktutRegistered;
			do {
				System.out.println("Enter Tutorial ID to be registered in: ");
				tutidregister = sc.nextLine();
				checktutRegistered = RM.addStudentinTut(studentidregister,courseidregister,tutidregister);
				if(checktutRegistered) {
					System.out.println("Added to Tutorial "+RM.getLastAddedRegister().getTutorialRegister().getTutorial().getTutorialCode());
				}
			}while(!checktutRegistered);
			
		}
		
		if(RM.checkCourseHasLab(courseidregister) == true) {
			boolean checkLabRegistered;
			do {
				System.out.println("Enter Lab ID to be registered in: ");
				labidregister = sc.nextLine();
				checkLabRegistered = RM.addStudentinLab(studentidregister,courseidregister,labidregister);
				if(checkLabRegistered) {
				System.out.println("Added to Lab "+RM.getLastAddedRegister().getTutorialRegister().getLabRegister().getLab().getLabCode());
				}
			}while(!checkLabRegistered);
		}
		
		
		return RM;
	}
	
	public void printStudentRegistered() {
		System.out.println("Student already registered!");
	}
	
	
}
