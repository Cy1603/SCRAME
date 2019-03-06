package oodpCourse;
import java.util.*;
public class ResultManager {

	private ArrayList<Result> ResultList;
	private CourseController cControl;
	
	public ResultManager(ArrayList<Result> ResultList, CourseController cControl) {
		this.ResultList = ResultList;
		this.cControl = cControl;
	}
	
	public void addResultComponent(String studentID, String courseID, String ResultName) {
		CourseworkComponentController ccControl = new CourseworkComponentController(cControl.getCourse(courseID).getCourseworkComponent());
		if(ccControl.checkComponentExist(ResultName)) {
			Result r = new Result(ResultName,ccControl.getCourseworkComponentWeightage(ResultName));
			ResultList.add(r);
		}
	}
	
	public ArrayList<Result> getResultList(){
		return ResultList;
	}
	
	public Result getResultName(String ResultName) {
		Result rTemp = new Result();
		for(int i=0; i<ResultList.size(); i++) {
			if(ResultList.get(i).getResultName().equals(ResultName)) rTemp = ResultList.get(i);
		} return rTemp;
	}
	
	public ArrayList<Result> addResultMarks(String ResultName, double ResultMarks) {
		getResultName(ResultName).setResultMark(ResultMarks);
		return ResultList;
	}
	
	public double getExamWeightage() {
		double ExamWeightage = 100;
		for(int i=0; i<ResultList.size(); i++) {
			if(ResultList.get(i).getResultName().equals("Exam")) {
				ExamWeightage = ResultList.get(i).getResultWeightage();
			}
		}
		return ExamWeightage;
	}
	
	public double getTotalResultMarks() {
		double TotalResults = 0;
		TotalResults = getTotalExamMarks()*(getExamWeightage()/100.0) + getTotalCourseworkMarks()*(1-(getExamWeightage()/100.0));
		return TotalResults;
	}
	
	public double getTotalExamMarks() {
		double TotalExamResults = 0;
		for(int i=0; i<ResultList.size(); i++) {
			if(ResultList.get(i).getResultName().equals("Exam")) {
				TotalExamResults += ResultList.get(i).getResultMark();
			}
		}
		return TotalExamResults;
	}
	
	public double getTotalCourseworkMarks() {
		double TotalCourseworkMarks = 0;
		for(int i=0; i<ResultList.size(); i++) {
			if(!ResultList.get(i).getResultName().equals("Exam")) {
				TotalCourseworkMarks += (ResultList.get(i).getResultMark())*(ResultList.get(i).getResultWeightage()/100.0);
			}
		}
		return TotalCourseworkMarks;
	}
	
	public boolean checkResultExist(String ResultName) {
		for(int i=0; i<ResultList.size(); i++) {
			if(ResultName == ResultList.get(i).getResultName()) return true;
		} return false;
	}
}
