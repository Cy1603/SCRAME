package oodpCourse;
import java.util.*;

public class TranscriptMgr {
	
	//Needs Student arrayList from student manager (dependency/association with student manager?)
	
	private StudentController sControl;
	private RegistrationMgr rControl;
	private CourseController cControl;
	
	public TranscriptMgr(StudentController sControl) {
		this.sControl = sControl;
	}
	
	public TranscriptMgr(StudentController sControl,RegistrationMgr rControl, CourseController cControl) {
		this.sControl = sControl;
		this.rControl = rControl;
		this.cControl = cControl;
	}
	
	public boolean verifystud(String studentID) //pass in studentID
	{
		ArrayList <Student> StudList = sControl.getStudentList();
		for(int i=0 ; i<StudList.size() ; i++) {
			if((StudList.get(i)).getID().equals(studentID)) {
				return true;
			}
		}
		return false;
	}

	public Student getStudentfromStudentID(String studentID) {	
		int StudListIndex = 0; 
		ArrayList <Student> StudList = sControl.getStudentList();

		for(int i=0 ; i<StudList.size() ; i++) {
			Student studiterate = StudList.get(i);
			if((studiterate.getID()).equals(studentID)) 
				StudListIndex = i;
		}
		
		Student stud = StudList.get(StudListIndex);
		return stud;
	}
	
	public void printoverallstud(String studentid) //pass in studentID 
	{
		TranscriptUI printer = new TranscriptUI(this);
		
		ArrayList <Register> studcourselist = rControl.CoursesThatStudentRegistered(studentid);
		
		for(int i=0;i<studcourselist.size();i++) {
			Register temp = studcourselist.get(i); 
			
			double CExamweightage = ((double)(temp.getCourse().getExamWeightage()))/100; 
			double CCourseWorkWeightage = 1.0 - CExamweightage;
			double overallstudcoursegrade = 0;
			printer.print("Course: "+temp.getCourse().getCourseCode()+" "+temp.getCourse().getName()); 
			
			//method to get the overall grade of each course of the student		
			for(int j=0;j<temp.getResultList().size();j++) {
				Result tempResult = temp.getResultList().get(j);
				if(tempResult.getResultName().equals("Exam")) {
					double Exammark = tempResult.getResultMark() * CExamweightage;
					overallstudcoursegrade += Exammark;
				}
				else {
					double tempCWmark = tempResult.getResultMark()*((double)tempResult.getResultWeightage())/100;
					double CWmark = tempCWmark * CCourseWorkWeightage;
					overallstudcoursegrade += CWmark;
				}
			}printer.print("Mark: "+Double.toString(overallstudcoursegrade)+"/100 , "+getGrade(overallstudcoursegrade));
		}
	}
	
	public void printindividualstud(String studentid) //pass in studentID and student arrayList -> printout individual sub grade
	{
		TranscriptUI printer = new TranscriptUI(this); //declare printer in method

		ArrayList <Register> studcourselist = rControl.CoursesThatStudentRegistered(studentid); //get register list that student is registered to
		
		for(int i=0;i<studcourselist.size();i++) {
			Register temp = studcourselist.get(i); //declare temp register object of a student
			
			printer.print("Course: "+temp.getCourse().getCourseCode()+" "+temp.getCourse().getName());
			
			for(int j=0;j<temp.getResultList().size();j++) { //iterate through Result list of each Register to check each result object
				Result tempResult = temp.getResultList().get(j); //declare temp result object
				printer.print("-----"+tempResult.getResultName()+"-----"); 
				printer.print("Mark: "+Double.toString(tempResult.getResultMark())+"/100 , "+getGrade(tempResult.getResultMark())); //change to double to avoid getting 0 when /100
				if(!tempResult.getResultName().equals("Exam")) {
					printer.print("Weightage: "+Double.toString(tempResult.getResultWeightage()*(double)(temp.getCourse().getExamWeightage())/100.0)+"%");
					printer.print("\n");
				}
				else {
					printer.print("Weightage: "+Integer.toString(tempResult.getResultWeightage())+"%");
					printer.print("\n");
				}
			}
		
		}
		
	}
	
	private String getGrade(Double grade) { //convert mark to grade
		if(grade>85.0) return "A+";
		else if(grade>80.0) return "A";
		else if(grade>75.0) return "A-";
		else if (grade>70.0) return "B+";
		else if(grade>66.0) return "B";
		else if(grade>60.0) return "B-";
		else if(grade>55.0) return "C+";
		else if(grade>50.0) return "C";
		else if(grade>45.0) return "C-";
		else if(grade>40.0) return "D";
		else return "F";
	}
	
	
}