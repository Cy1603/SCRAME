package oodpCourse;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AddCourseworkComponent {

	private String ccCourse;
	private String ccName;
	private int ccWeightage;
	private int checkWeightage = 0;
	private CourseController cControl;
	private CourseworkComponentController ccControl;
	
	public AddCourseworkComponent(CourseController cControl) {
		this.cControl = cControl;
	}
	
	public CourseController input() { //may be optimised
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please enter the Course ID to add Coursework Component to:");
			ccCourse = sc.nextLine();
			if(!cControl.checkCourseExist(ccCourse)) {
				System.out.println("Course does not exist! Please re-input.");
			}
		}while(!cControl.checkCourseExist(ccCourse));
		ccControl = new CourseworkComponentController(cControl.getCourse(ccCourse).getCourseworkComponent());
		
		while(checkWeightage!=100) {
			do {
				System.out.println("Please enter the name of Coursework Component:"); //Error checking for name of CC
				ccName = sc.nextLine();
				if(ccControl.checkComponentExist(ccName)) {
					System.out.println("Component already exist! Please re-input.");
				}	
			}while(ccControl.checkComponentExist(ccName));
			do {
				try {
					System.out.println("Please enter the weightage of the Coursework Component: ");
					ccWeightage = sc.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Please input integer between 0-100.");
					ccWeightage = -1;
					sc.next();
				};
			}while(ccWeightage== -1);
			sc.nextLine();
			checkWeightage += ccWeightage;
			if(checkWeightage>100) {
				ccWeightage = ccWeightage - (checkWeightage-100);
				System.out.println(ccName+" Component Weightage set as "+ccWeightage+" instead.");
				checkWeightage = 100;
			}
			cControl.getCourse(ccCourse).setCourseworkComponentList(ccControl.addComponent(ccName,ccWeightage));
		}
		System.out.println("All Components added!");
		return cControl;
	}
}
