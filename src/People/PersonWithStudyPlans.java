package People;

import java.time.LocalDate;

import Core.Database;
//import Controller.*;

public class PersonWithStudyPlans extends Person{
	private String educationalInstitution;
	private String degreeProgram;
	private String studentID;
	private LocalDate studyStartDate;
	private LocalDate studyEndDate;
	
	public PersonWithStudyPlans() {
		super();
		this.educationalInstitution=Database.getEducationalInstitution();
		this.degreeProgram=Database.getDegreeProgram();
		this.studentID=Database.getStudentID();
		this.studyStartDate=Database.getStudyStartDate();
		this.studyEndDate=Database.getStudyEndDate();
	}
	
	@Override
	public String displayInfo() {
		super.displayInfo();
        /*System.out.println("Education institution: "+educationalInstitution);
        System.out.println("Degree program: "+degreeProgram);
        System.out.println("Student ID: "+studentID);
        System.out.println("Starting date of study: "+studyStartDate);
        System.out.println("Ending date of study: "+studyEndDate);*/
		
		StringBuilder builder = new StringBuilder();
		builder.append(super.displayInfo()); // Použite metódu z nadradenej triedy na získanie základných informácií
	    builder.append("Education institution: ").append(educationalInstitution).append("\n");
	    builder.append("Degree program: ").append(degreeProgram).append("\n");
	    builder.append("Student ID: ").append(studentID).append("\n");
	    builder.append("Starting date of study: ").append(studyStartDate).append("\n");
	    builder.append("Ending date of study: ").append(studyEndDate).append("\n").append("\n"); 
	    return builder.toString();
	}
}
