package oodpCourse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseStatUI {

	private CourseStatMgr CM;
	private static Scanner sc = new Scanner(System.in);
	private String courseID;
	private int choice;
	
	public CourseStatUI(CourseStatMgr CM) {
		this.CM = CM;
	}
	
	public void inputCourseIDstat() {
		System.out.println("Enter CourseID whose course statistic you want to print out: ");
		courseID = sc.nextLine();
		if(CM.verifycourse(courseID) == false) {
			System.out.println("CourseID entered is invalid");
		}
		else userStatchoice(courseID);
	}
	
	
	
	public void userStatchoice(String courseID) //pass in courseID
	{
		do {
			try {
				System.out.println("Enter your choice:");
				System.out.println("(1) Print Course Overall Grade Percentage:");
				System.out.println("(2) Print Course Exam Grade Percentage:");
				System.out.println("(3) Print Course Coursework Grade Percentage:");
			choice = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Please input a valid integer(1-3)!");
				sc.next();
			}
		}while(!(choice== 1 || choice == 2 || choice ==3));
		
		sc.nextLine();
		
		do {
			switch(choice) {
			case 1:
				System.out.print(courseID+" Overall Average Grade Percentage: ");
				System.out.println(CM.gradePercentOverall(courseID)+" , "+getGrade(CM.gradePercentOverall(courseID)));
				CM.printOverall(courseID);
				break;
			case 2:
				System.out.print(courseID+" Course Exam Average Grade Percentage: ");
				System.out.println(CM.gradePercentExam(courseID)+" , "+getGrade(CM.gradePercentExam(courseID)));
				CM.printExam(courseID);
				break;
			case 3:
				System.out.print(courseID+" Course Coursework Average Grade Percentage: ");
				System.out.println(CM.gradePercentCoursework(courseID)+" , "+getGrade(CM.gradePercentCoursework(courseID)));
				CM.printCoursework(courseID);
				break;
			}
		}while(choice<1 || choice>3);
	}
	
	private String getGrade(Double grade) {
		if(grade>85.0) return "A+";
		else if(grade>80.0) return "A";
		else if(grade>75.0) return "A-";
		else if (grade>70.0) return "B+";
		else if(grade>66.0) return "B";
		else if(grade>60.0) return "B-";
		else if(grade>55.0) return "C+";
		else if(grade>50.0) return "C";
		else if(grade>45.0) return "C-";
		else return "F";
	}
	
	public void print(String s) {
		System.out.print(s);
	}
	

}
