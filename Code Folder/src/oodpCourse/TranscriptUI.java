package oodpCourse;
import java.util.Scanner;

public class TranscriptUI {
		
	private TranscriptMgr TM;
	private String studentid; // private variable student id to take in user input
	private Scanner sc = new Scanner(System.in);
	
	public TranscriptUI(TranscriptMgr TM) {
		this.TM = TM;
	}
	
	public void print(String output) {
		System.out.println(output);
	}
	
	public void InputStud() {
		System.out.println("Enter valid studentID: ");
		studentid = sc.nextLine(); //get student ID

		if(TM.verifystud(studentid) == true) { //call transcript manager to verify if student exist
			
			System.out.println("\nOverall Grade for Each Course:");
			System.out.println("-------------------------------");
			TM.printoverallstud(studentid); 
			
			System.out.println("\nOverall Breakdown Grade for Each Course:");
			System.out.println("------------------------------------------");
			TM.printindividualstud(studentid);
			}
		else if(TM.verifystud(studentid) == false) {
			System.out.println("\nInvalid studentID");
		}
	}

	
	
	
	
	
		
		
}/*TranscriptUI calls studTranscript to print out student's  the individual overall course mark and grade, it will also print
		the student’s individual component marks – exam, coursework, subcomponents. The configured
		weightages should be displayed as well*/
