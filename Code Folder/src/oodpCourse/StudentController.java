package oodpCourse;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

	private ArrayList<Student> sList;

	public StudentController(ArrayList<Student> sList) {
		this.sList = sList;
	}
	
	public int addStudent(String Name, String ID) {
		if(!checkStudentExist(Name)) {
			sList.add(new Student(Name, ID));
			return 1;
		}
		else return 0;
	}
	
	public ArrayList<Student> getStudentList(){
		return sList;
	}
	
	public boolean checkStudentExist(String sID) {
		for(int i=0; i<sList.size(); i++) {
			if(sID.equals(sList.get(i).getID())) return true;
		} return false;
	}
	
	public Student getStudent(String StudentID) {
		Student sTemp = new Student();
		for(int i=0; i<sList.size(); i++) {
			if(StudentID.equals(sList.get(i).getID())) sTemp = sList.get(i);
		} return sTemp;
	}
	
	public void displayStudents() {
		if (sList.size() <= 0) {
			System.out.println("No current students");
		}
		else {
			System.out.println("Current Students: ");
			sList.forEach(i -> System.out.println(i.getID()+" "+i.getName()));
		}
	}
}