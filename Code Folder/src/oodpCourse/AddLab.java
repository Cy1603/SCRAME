package oodpCourse;

import java.util.ArrayList;
import java.util.Scanner;

public class AddLab {
	private String lCode;
	private String courseCode;
	private int lVacancy;
	private LabController labControl;
	private ArrayList<Lab> lList;
	
	public AddLab(ArrayList<Lab> lList) {
		this.lList = lList;
	}
	
	public LabController input(String courseCode) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter lab code:");
		lCode = sc.nextLine();
		this.courseCode = courseCode;
		//System.out.println("Please enter vacancy:");
		//lVacancy = sc.nextInt();
		labControl = new LabController(lList);
		labControl.addlab(lCode,courseCode,10);
		System.out.println("Lab added: "+lCode);
		return labControl;
	}
}
