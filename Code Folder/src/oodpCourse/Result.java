package oodpCourse;
import java.io.Serializable;

public class Result implements Serializable{
	
	private String ResultName;
	private double ResultMark;
	private int ResultWeightage;
	
	public Result() {}
	
	public Result(String ResultName, int ResultWeightage) {
		this.ResultName = ResultName;
		this.ResultMark = 0;
		this.ResultWeightage = ResultWeightage;
	}
	
	public String getResultName() {
		return ResultName;
	}
	
	public void setResultMark(double ResultMark) {
		this.ResultMark = ResultMark;
	}
	
	public double getResultMark() {
		return ResultMark;
	}
	
	public void setResultWeightage(int ResultWeightage) {
		this.ResultWeightage = ResultWeightage;
	}
	
	public int getResultWeightage() {
		return ResultWeightage;
	}
}
