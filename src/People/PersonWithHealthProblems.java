package People;

import java.io.Serializable;

import Core.Database;
import Core.DatabaseOfWantedPeople;

public class PersonWithHealthProblems extends Person implements Serializable{
	private String typeOfDisorder;
	private String medicines;
	private String allergies;
	private String emergencyContactInfo; 
	private String specialMedicalNeeds;
	
	 
	public PersonWithHealthProblems() {
		super();
		this.typeOfDisorder=Database.getTypeOfDisorder();
		this.medicines=Database.getMedicines();
		this.allergies=Database.getAllergies(); 
		this.emergencyContactInfo=contact;
		if (typeOfDisorder=="Mobility impairment") this.specialMedicalNeeds=Database.getSpecialMedicalNeeds();
		else this.specialMedicalNeeds="None";
	}
	
	@Override
	public String displayInfo() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(super.displayInfo()); // Použite metódu z nadradenej triedy na získanie základných informácií
	    builder.append("Type of disorder: ").append(typeOfDisorder).append("\n");
	    builder.append("Medicines: ").append(medicines).append("\n");
	    builder.append("Allergies: ").append(allergies).append("\n");
	    builder.append("Contact info in case of emergency: ").append(emergencyContactInfo).append("\n");
	    builder.append("Special medical needs: ").append(specialMedicalNeeds).append("\n").append("\n");
	    return builder.toString();
		
		
        /*super.displayInfo();
        System.out.println("Type of disorder: "+typeOfDisorder);
        System.out.println("Medicines: "+medicines);
        System.out.println("Allergies: "+allergies);
        System.out.println("Contact info in case of emergency: "+emergencyContactInfo);
        System.out.println("Special medical needs: "+specialMedicalNeeds);*/
    }
	
	@Override
    public boolean wantedMethod() {
        return DatabaseOfWantedPeople.isWanted(name, surname); 
    }
	
}
	