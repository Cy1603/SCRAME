package oodpCourse;
import java.util.*;
public class AddStudent {
	public StudentController sControl; 
	
	public AddStudent(StudentController sControl) {
		this.sControl = sControl;
	}
	
	public StudentController input(){
		Scanner sc = new Scanner(System.in);
		String studentName;
		String studentID;
		do {
			do {
				studentName = prompt("Enter your name as shown on your NRIC: ");
				if(!studentName.matches("[a-zA-Z\\s]+")) {
					System.out.println("You can only enter alphabets!");
				}
			}while(!studentName.matches("[a-zA-Z\\s]+"));
			
			do {
				studentID = prompt("Enter your matriculation number: ");
				if(sControl.checkStudentExist(studentID)) {
					System.out.println("Student ID already exist!");
					break;
				}
				if(studentID.length()!=9)
					System.out.println("Matriculation number must be 2 Alphabets and 7 Number long.");
			}while(studentID.length()!=9);
		}while(sControl.checkStudentExist(studentID));
		
		int outcome = sControl.addStudent(studentName,studentID);
		if (outcome == 1) 
			System.out.println("Student has been successfully added.");
		else 
			System.out.println("Student not added as Student already exists!");
		System.out.println("============================================================================");
		sControl.displayStudents();
		System.out.println("============================================================================");
		return sControl;
	}
	
	// To print message and acquire user input
	private static String prompt(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextLine();
	}
}