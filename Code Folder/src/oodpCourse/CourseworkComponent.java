package oodpCourse;
import java.io.Serializable;

public class CourseworkComponent implements Serializable {

	private String ccName;
	private int ccWeightage;
	
	public CourseworkComponent(){}
	
	public CourseworkComponent(String name, int weightage){
		this.ccName = name;
		this.ccWeightage = weightage;
	}
	
	public String getName() {
		return ccName;
	}
	
	public int getWeightage() {
		return ccWeightage;
	}

}
