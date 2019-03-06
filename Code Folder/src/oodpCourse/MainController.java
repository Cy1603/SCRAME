package oodpCourse;
import java.util.*;
public class MainController {
	
	InOutput io = new InOutput();
	private ArrayList<Student> sList = (ArrayList<Student>)io.readFile("Student.dat"); //read from file
	private ArrayList<Course> cList = (ArrayList<Course>)io.readFile("Course.dat"); //read from file
	private ArrayList<Register> rList = (ArrayList<Register>)io.readFile("Register.dat");//read from file
	private ArrayList<TutorialRegister> trList = (ArrayList<TutorialRegister>) io.readFile("TutorialRegister.dat");  //read from file
	private ArrayList<LabRegister> lrList = (ArrayList<LabRegister>) io.readFile("LabRegister.dat"); //read from file

	public void delegate(int choice) {
		switch(choice) { //switch case for calling boundaries
		case 1:
			StudentController sControl1 = new StudentController(sList); //boundaries created within switch case with new list every time
			AddStudent StudentBoundary = new AddStudent(sControl1);
			sControl1 = StudentBoundary.input();
			this.sList = sControl1.getStudentList(); //update list in main controller
			break;
		case 2:
			CourseController cControl2 = new CourseController(cList);
			AddCourse CourseBoundary = new AddCourse(cControl2);
			cControl2 = CourseBoundary.input();
			this.cList = cControl2.getCourseList();
			break;
		case 3:
			CourseController cControl3 = new CourseController(cList);
			AddCourseworkComponent addCCBoundary = new AddCourseworkComponent(cControl3);
			cControl3 = addCCBoundary.input();
			this.cList = cControl3.getCourseList();
			break;
		case 4:
			RegistrationMgr rControl4 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			RegisterStudentUI RegisterBoundary = new RegisterStudentUI(rControl4);
			rControl4 = RegisterBoundary.StudentRegisterInput();
			this.cList = rControl4.getCourseList();
			this.sList = rControl4.getStudentList();
			this.rList = rControl4.getRList();
			this.trList = rControl4.getTRList();
			this.lrList = rControl4.getLRList();
			break;
		case 5:
			CourseController cControl5 = new CourseController(cList);
			CheckAvailSlotUI availSlotBoundary = new CheckAvailSlotUI(cControl5);
			int choice4 = availSlotBoundary.chooseType();
			switch(choice4) {
			case 1:
				availSlotBoundary.getLecture();
				break;
			case 2:
				availSlotBoundary.getTutorial();
				break;
			case 3:
				availSlotBoundary.getLab();
				break;
			}
			this.cList = cControl5.getCourseList();
			break;
		case 6:
			RegistrationMgr rControl6 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			PrintStudentUI printStudentBoundary = new PrintStudentUI(rControl6);
			int choice5 = printStudentBoundary.chooseType();
			switch(choice5) {
			case 1:
				printStudentBoundary.getLecture();
				break;
			case 2:
				printStudentBoundary.getTutorial();
				break;
			case 3:
				printStudentBoundary.getLab();
				break;
			}
			break;
		case 7:
			RegistrationMgr rControl7 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			CourseController cControl7 = new CourseController(cList);
			AddResultUI inputResultBoundary = new AddResultUI(rControl7,cControl7);
			rControl7 = inputResultBoundary.inputCoursework();
			this.cList = rControl7.getCourseList();
			this.sList = rControl7.getStudentList();
			this.rList = rControl7.getRList();
			this.trList = rControl7.getTRList();
			this.lrList = rControl7.getLRList();
			break;
		case 8:
			RegistrationMgr rControl8 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			CourseController cControl8 = new CourseController(cList);
			AddResultUI inputExamBoundary = new AddResultUI(rControl8,cControl8);
			rControl8 = inputExamBoundary.inputExam();
			this.cList = rControl8.getCourseList();
			this.sList = rControl8.getStudentList();
			this.rList = rControl8.getRList();
			this.trList = rControl8.getTRList();
			this.lrList = rControl8.getLRList();
			break;
		case 9:
			CourseController cControl9 = new CourseController(cList);
			RegistrationMgr rControl9 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			CourseStatMgr csControl9 = new CourseStatMgr(cControl9, rControl9);
			CourseStatUI courseStatBoundary = new CourseStatUI(csControl9);
			courseStatBoundary.inputCourseIDstat();
			break;
		case 10:
			StudentController sControl10 = new StudentController(sList);
			CourseController cControl10 = new CourseController(cList);
			RegistrationMgr rControl10 = new RegistrationMgr(cList,sList,rList,trList,lrList);
			TranscriptMgr tControl10 = new TranscriptMgr(sControl10,rControl10,cControl10);
			TranscriptUI transcriptBoundary = new TranscriptUI(tControl10);
			transcriptBoundary.InputStud();
			break;
		case 11:
			io.writeFile("Student.dat",sList);
			io.writeFile("Course.dat",cList);
			io.writeFile("Register.dat",rList);
			io.writeFile("TutorialRegister.dat",trList);
			io.writeFile("LabRegister.dat",lrList);
			return;
		default:
			System.out.println("Invalid choice, pick another choice between 1 to 11.");
			break;
		}
	}
}
