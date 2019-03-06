package oodpCourse;

import java.util.ArrayList;

public interface CourseType {

	void setName(String name);
	String getName();
	void setCourseCode(String code);
	String getCourseCode();
	void setVacancy(int vacancy);
	int getVacancy();
	void setExamWeightage(int ExamWeightage);
	int getExamWeightage();
	Professor getCourseCoordinator();
	void setCourseworkComponent(CourseworkComponent cc);
	void setCourseworkComponentList(ArrayList<CourseworkComponent> ccList);
	ArrayList<CourseworkComponent> getCourseworkComponent();

}