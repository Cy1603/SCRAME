package oodpCourse;
import java.io.Serializable;

public class Professor implements Serializable {
	private String profName;
	private String facName;
	private int ctc;
	private String email;
	
	public Professor() {}
	
	public Professor(String profName,String facName,int ctc, String email) {
		this.profName = profName;
		this.facName = facName;
		this.ctc = ctc;
		this.email = email;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
