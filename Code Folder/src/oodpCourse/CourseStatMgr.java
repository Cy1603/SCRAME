package oodpCourse;

import java.util.ArrayList;

public class CourseStatMgr {

	private CourseController CC;
	private RegistrationMgr RM;
	private CourseStatUI csBoundary = new CourseStatUI(this);
	
	
	public CourseStatMgr(CourseController CC, RegistrationMgr RM) {
		this.CC = CC;
		this.RM = RM;
	}
	
	public boolean verifycourse(String courseID) //pass in courseID
	{
		return CC.checkCourseExist(courseID);
	}
	
	public double gradePercentOverall(String courseID) {
		double OverallGrade = RM.getCourseResults(courseID);
		return OverallGrade;
	}
	
	public double gradePercentExam(String courseID) {
		double OverallExam = RM.getExamResults(courseID);
		return OverallExam;
	}
	
	public double gradePercentCoursework(String courseID) {
		double OverallCoursework = RM.getCourseworkResults(courseID);
		return OverallCoursework;
	}
	public CourseController getCourseController() {
		return CC;
	}
	public void printOverall(String courseID) {
		int CountAp = 0;
		int CountA = 0;
		int CountAm = 0;
		int CountBp = 0;
		int CountB = 0;
		int CountBm = 0;
		int CountCp = 0;
		int CountC = 0;
		int CountCm = 0;
		int CountF = 0;
		for(int i=0; i<RM.getRList().size(); i++) {
			if(RM.getRList().get(i).getCourse().getCourseCode().equals(courseID)) {
				ArrayList<Result> resultList = RM.getRList().get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, RM.getCourseController());
				if(getGrade(rmTemp.getTotalResultMarks()).equals("A+")) CountAp++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("A")) CountA++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("A-")) CountAm++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("B+")) CountBp++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("B")) CountB++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("B-")) CountBm++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("C+")) CountCp++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("C")) CountC++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("C-")) CountCm++;
				else if(getGrade(rmTemp.getTotalResultMarks()).equals("F")) CountF++;
			}
		}
		csBoundary.print("A+: "+CountAp+"\n");
		csBoundary.print("A: "+CountA+"\n");
		csBoundary.print("A-: "+CountAm+"\n");
		csBoundary.print("B+: "+CountBp+"\n");
		csBoundary.print("B: "+CountB+"\n");
		csBoundary.print("B-: "+CountBm+"\n");
		csBoundary.print("C+: "+CountCp+"\n");
		csBoundary.print("C: "+CountC+"\n");
		csBoundary.print("C-: "+CountCm+"\n");
		csBoundary.print("F: "+CountF+"\n");
	}
	
	public void printExam(String courseID) {
		int CountAp = 0;
		int CountA = 0;
		int CountAm = 0;
		int CountBp = 0;
		int CountB = 0;
		int CountBm = 0;
		int CountCp = 0;
		int CountC = 0;
		int CountCm = 0;
		int CountF = 0;
		for(int i=0; i<RM.getRList().size(); i++) {
			if(RM.getRList().get(i).getCourse().getCourseCode().equals(courseID)) {
				ArrayList<Result> resultList = RM.getRList().get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, RM.getCourseController());
				if(getGrade(rmTemp.getTotalExamMarks()).equals("A+")) CountAp++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("A")) CountA++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("A-")) CountAm++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("B+")) CountBp++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("B")) CountB++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("B-")) CountBm++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("C+")) CountCp++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("C")) CountC++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("C-")) CountCm++;
				else if(getGrade(rmTemp.getTotalExamMarks()).equals("F")) CountF++;
			}
		}
		csBoundary.print("A+: "+CountAp+"\n");
		csBoundary.print("A: "+CountA+"\n");
		csBoundary.print("A-: "+CountAm+"\n");
		csBoundary.print("B+: "+CountBp+"\n");
		csBoundary.print("B: "+CountB+"\n");
		csBoundary.print("B-: "+CountBm+"\n");
		csBoundary.print("C+: "+CountCp+"\n");
		csBoundary.print("C: "+CountC+"\n");
		csBoundary.print("C-: "+CountCm+"\n");
		csBoundary.print("F: "+CountF+"\n");
	}
	
	public void printCoursework(String courseID) {
		int CountAp = 0;
		int CountA = 0;
		int CountAm = 0;
		int CountBp = 0;
		int CountB = 0;
		int CountBm = 0;
		int CountCp = 0;
		int CountC = 0;
		int CountCm = 0;
		int CountF = 0;
		for(int i=0; i<RM.getRList().size(); i++) {
			if(RM.getRList().get(i).getCourse().getCourseCode().equals(courseID)) {
				ArrayList<Result> resultList = RM.getRList().get(i).getResultList();
				ResultManager rmTemp = new ResultManager(resultList, RM.getCourseController());
				if(getGrade(rmTemp.getTotalExamMarks()).equals("A+")) CountAp++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("A")) CountA++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("A-")) CountAm++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("B+")) CountBp++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("B")) CountB++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("B-")) CountBm++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("C+")) CountCp++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("C")) CountC++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("C-")) CountCm++;
				else if(getGrade(rmTemp.getTotalCourseworkMarks()).equals("F")) CountF++;
			}
		}
		csBoundary.print("A+: "+CountAp+"\n");
		csBoundary.print("A: "+CountA+"\n");
		csBoundary.print("A-: "+CountAm+"\n");
		csBoundary.print("B+: "+CountBp+"\n");
		csBoundary.print("B: "+CountB+"\n");
		csBoundary.print("B-: "+CountBm+"\n");
		csBoundary.print("C+: "+CountCp+"\n");
		csBoundary.print("C: "+CountC+"\n");
		csBoundary.print("C-: "+CountCm+"\n");
		csBoundary.print("F: "+CountF+"\n");
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
}
