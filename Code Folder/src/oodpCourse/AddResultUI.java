package oodpCourse;
import java.util.*;
public class AddResultUI {

	private static Scanner sc = new Scanner(System.in);
	private RegistrationMgr rControl;
	private CourseController cControl;
	private String studentID;
	private String courseID;
	private String resultName;
	private double marks;
	
	public AddResultUI(RegistrationMgr rControl, CourseController cControl) {
		this.rControl = rControl;
		this.cControl = cControl;
	}
	
	public RegistrationMgr inputCoursework() {
		int countAdd = 0;
		System.out.println("Please enter student ID: ");
		studentID = sc.nextLine();
		
		System.out.println("Please enter course ID: ");
		courseID = sc.nextLine();
		if(!rControl.checkStudentRegistered(studentID, courseID)){ //Check if student is registered before confirming registration
			System.out.println("Student is not registered in the course or course does not exist!");
			return rControl;
		}
		else {
		
			while(countAdd < (cControl.getCourse(courseID).getCourseworkComponent().size()-1)) {
				int countPrint = 1;
				for(int i=0; i<cControl.getCourse(courseID).getCourseworkComponent().size(); i++) { //Printing existing coursework components as reference list
					if(!cControl.getCourse(courseID).getCourseworkComponent().get(i).getName().equals("Exam")) {
						System.out.println(countPrint+") "+cControl.getCourse(courseID).getCourseworkComponent().get(i).getName());
						countPrint++;
					}
				}
				System.out.println("Please enter Component Name to add result to: "); 
				resultName = sc.nextLine();
				if(!resultName.equals("Exam")) {
					do {
						try {
							System.out.println("Please enter marks to add: ");
							marks = sc.nextDouble();
							if(marks>100 || marks <0) {
								System.out.println("Please input between 0 to 100!");
							}
						}catch(InputMismatchException e) {
							System.out.println("Please enter a valid number!");
							marks =-1;
							sc.next();
						}
					}while(marks>100 || marks <0);
					sc.nextLine();
					if(rControl.checkStudentRegistered(studentID, courseID)) {
						ResultManager resultControl = new ResultManager(rControl.getStudentRegister(studentID,courseID).getResultList(),cControl);
						rControl.getStudentRegister(studentID,courseID).setResultList(resultControl.addResultMarks(resultName,marks));
						countAdd++;
					}
				}
			}
		System.out.println("All Component Marks added!");
		return rControl;
		}
		
	}
	
	public RegistrationMgr inputExam() {
		System.out.println("Please enter student ID: ");
		studentID = sc.nextLine();
		
		System.out.println("Please enter course ID: ");
		courseID = sc.nextLine();
		if(!rControl.checkStudentRegistered(studentID, courseID)){ //Check if student is registered before confirming registration
			System.out.println("Student is not registered in the course or course does not exist!");
			return rControl;
		}
		else {
			resultName = "Exam";
			do {
				try {
					System.out.println("Please enter marks to add: ");
					marks = sc.nextDouble();
					if(marks>100 || marks <0) {
						System.out.println("Please input between 0 to 100!");
					}
				}catch(InputMismatchException e) {
					System.out.println("Please enter a valid number!");
					marks =-1;
					sc.next();
				}
			}while(marks>100 || marks <0);
			sc.nextLine();
			if(rControl.checkStudentRegistered(studentID, courseID)) {
				ResultManager resultControl = new ResultManager(rControl.getStudentRegister(studentID,courseID).getResultList(),cControl);
				rControl.getStudentRegister(studentID,courseID).setResultList(resultControl.addResultMarks(resultName,marks));
			}
			System.out.println("Exam marks added!");
			return rControl;
		}
	}
}
