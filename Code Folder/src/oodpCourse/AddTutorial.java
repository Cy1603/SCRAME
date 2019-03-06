package oodpCourse;
import java.util.*;

public class AddTutorial {

	private String tCode;
	private String courseCode;
	private TutorialController tutControl; //change inside method
	private ArrayList<Tutorial> tList;
	
	public AddTutorial(ArrayList<Tutorial> tList) {
		this.tList = tList;
	}
	
	public TutorialController input(String courseCode) {
		Scanner sc = new Scanner(System.in);
		this.courseCode = courseCode;
		System.out.println("Please enter tutorial code:");
		tCode = sc.nextLine();
		tutControl = new TutorialController(tList);
		tutControl.addtut(tCode,courseCode,10);
		//tutControl.reduceVacancy(tCode);
		System.out.println("Tutorial added: "+tCode);
		return tutControl;
	}
}
