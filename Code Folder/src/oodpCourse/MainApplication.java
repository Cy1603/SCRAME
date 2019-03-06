package oodpCourse;
import java.util.*;
public class MainApplication {

	private static MainController MainControl = new MainController();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			try {
				System.out.println("Welcome to SCRAME! Choose your options");
				System.out.println("(1) Add a student");
				System.out.println("(2) Add a course");
				System.out.println("(3) Enter course assessment components weightage");
				System.out.println("(4) Register student for a course");
				System.out.println("(5) Check available slot in a class");
				System.out.println("(6) Print student list by lecture, tutorial or laboratory session for a course");
				System.out.println("(7) Enter coursework mark - inclusive of its components");
				System.out.println("(8) Enter exam mark.");
				System.out.println("(9) Print course statistics");
				System.out.println("(10) Print student transcript");
				System.out.println("(11) Exit");
				choice = sc.nextInt();
				MainControl.delegate(choice); //call Main Controller to call boundary with choice as argument
				
			}catch(InputMismatchException e) {
				System.out.println("Please input a valid integer!");
				sc.next();
			}
		}while(choice!=11);
	}
}
