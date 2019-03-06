package oodpCourse;
import java.util.ArrayList;

public class ProfessorManager {
	private InOutput io = new InOutput();
	private ArrayList<Professor> profList = (ArrayList<Professor>)io.readFile("Professor.dat");
	
	public ProfessorManager() {}
	
	public void printProfList() {
		System.out.println("Professor List:");
		for (int i = 0 ; i < profList.size() ; i++) {
			Professor p = profList.get(i);
			System.out.println(p.getProfName());
		}
	}
	
	public boolean checkProfExist(String profName) {
		for (int i = 0 ; i < profList.size() ; i++) {
			Professor p = profList.get(i);
			if(p.getProfName().equals(profName)) {
				return true;
			}
		}
		return false;
	}
	
	public Professor getProf(String profName) {
		Professor p = new Professor();
		for (int i = 0 ; i < profList.size() ; i++) {
			p = profList.get(i);
			if(p.getProfName().equals(profName)) {
				break;
			}
		}
		return p;
	}
}