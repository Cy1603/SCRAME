package oodpCourse;
import java.util.*;			
import java.io.*;

public class AddCourse {
	private CourseController CourseControl;
	
	public AddCourse(CourseController CourseControl) {
		this.CourseControl = CourseControl;
	}
	
	public CourseController input() {
		String courseName;
		String courseCode;
		String CoordinatorName;
		int ExamWeightage;
		String addTutorial;
		String addLab;
		
		ProfessorManager pControl = new ProfessorManager();
		Scanner sc = new Scanner(System.in);
		
		do {
			do{
				System.out.println("Please enter Course name:");
				courseName = sc.nextLine();
				if(!courseName.matches("[a-zA-Z\\s]+")) {
					System.out.println("You can only enter alphabets!");
				}
			}while(!courseName.matches("[a-zA-Z\\s]+"));
			
			do{
				System.out.println("Please enter Course code:");
				courseCode = sc.nextLine();
				if(courseCode.length()!=6) {
					System.out.println("Course code consist of 2 Alphabets and 4 Numbers!");
				}
			}while(courseCode.length()!=6);
			if(CourseControl.checkCourseExist(courseCode))
				System.out.println("Course ID already exist!");
		}while(CourseControl.checkCourseExist(courseCode));
		
		do{
			pControl.printProfList();
			System.out.println("Please enter name of Course Coordinator:");
			CoordinatorName = sc.nextLine();
			if(!pControl.checkProfExist(CoordinatorName))
				System.out.println("Professor does not exist!");
		}while(!pControl.checkProfExist(CoordinatorName));
		
		do {
			System.out.println("Please enter Exam Weightage for the course (in terms of Percentage):");
			ExamWeightage = sc.nextInt();
			sc.nextLine();
			if(ExamWeightage>100)
				System.out.println("Exam weightage cannot be more than 100%!");
		}while(ExamWeightage>100);
		CourseControl.setCourseList(CourseControl.addCourse(courseName, courseCode, 100, ExamWeightage, pControl.getProf(CoordinatorName)));
		
		do {
			System.out.println("Add a tutorial? (Y/N)");
			addTutorial = sc.nextLine();
			if(addTutorial.equals("Y")) {
				for(int i=0; i<10; i++) {
					CourseControl.addTutorial(CourseControl.getLastAddedCourse());
				}
			}
			if(!(addTutorial.equals("Y") || addTutorial.equals("N")))
				System.out.println("Invalid input. Try again.");

		}while(!(addTutorial.equals("Y") || addTutorial.equals("N")));
		
		if(CourseControl.checkCourseHasTutorial(CourseControl.getLastAddedCourse())) {
			do {
				System.out.println("Add a Lab? (Y/N)");
				addLab = sc.nextLine();
				if(addLab.equals("Y")) {
					for(int i=0;i<10;i++) {
						CourseControl.addLab(CourseControl.getLastAddedCourse());
					}
				}
			if(!(addLab.equals("Y") || addLab.equals("N")))
				System.out.println("Invalid input. Try again.");
			}while(!(addLab.equals("Y") || addLab.equals("N")));
		}
		System.out.println("Course "+CourseControl.getLastAddedCourse().getCourseCode()+" added.");
		System.out.println("============================================================================");
		CourseControl.printAllCourses();
		System.out.println("============================================================================");
		return CourseControl;
	}
}