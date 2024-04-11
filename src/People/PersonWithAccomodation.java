package People;

import java.io.Serializable;
import java.time.LocalDate;

import Core.Database;
//import Controller.*;
import Core.DatabaseOfWantedPeople;

public class PersonWithAccomodation extends Person implements Serializable{
	private String accomodationType;
	protected String accomodationCity;
	protected LocalDate accomodationCheckInDate;
	protected LocalDate accomodationCheckOutDate;
	private String accomodationConfirmationNumber;
	
	public PersonWithAccomodation() {
		super();
		this.accomodationType=Database.getAccomodationType();
		this.accomodationCity=Database.getAccomodationCity();
		this.accomodationCheckInDate=Database.getAccomodationChechInDate();
		this.accomodationCheckOutDate=Database.getAccomodationCheckOutDate();
		this.accomodationConfirmationNumber=Database.getAccomodationConfirmationNumber();
	}
	
	@Override 
	public String displayInfo() {
		/*super.displayInfo();
		System.out.println("Type of accomodation: "+accomodationType);
		System.out.println("City of stay: "+accomodationCity);
		System.out.println("Check in date: "+accomodationCheckInDate);
		System.out.println("Check out date: "+accomodationCheckOutDate);
		System.out.println("Confirmation number of accomodation: "+accomodationConfirmationNumber);*/
		
		StringBuilder builder=new StringBuilder(); 
		
		builder.append(super.displayInfo());
		builder.append("Type of accomodation: ").append(accomodationType).append('\n');
		builder.append("City of stay: ").append(accomodationCity).append('\n');
		builder.append("Check in date: ").append(accomodationCheckInDate).append('\n');
		builder.append("Check out date: ").append(accomodationCheckOutDate).append('\n');
		builder.append("Confirmation number of accomodation: ").append(accomodationConfirmationNumber).append('\n').append("\n");
		return builder.toString();
		
	}
	
	@Override
    public boolean wantedMethod() {
        return DatabaseOfWantedPeople.isWanted(name, surname); 
    }
}
 