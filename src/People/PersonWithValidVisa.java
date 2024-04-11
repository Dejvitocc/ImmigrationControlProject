package People;

import java.io.Serializable;
import java.time.LocalDate;

import Core.Database;
import Core.DatabaseOfWantedPeople;

public class PersonWithValidVisa extends Person implements Serializable{
	
	public class Visa {
	    private String visaType;
	    private LocalDate visaIssuedDate;
	    private LocalDate visaExpirationDate;
	    private String visaNumber;
	    private String visaIssuer;

	    public Visa(String visaType, LocalDate visaIssuedDate, LocalDate visaExpirationDate, String visaNumber, String visaIssuer) {
	        this.visaType = visaType;
	        this.visaIssuedDate = visaIssuedDate;
	        this.visaExpirationDate = visaExpirationDate;
	        this.visaNumber = visaNumber;
	        this.visaIssuer = visaIssuer;
	    }

	    public String displayInfo() {
	        
	    	StringBuilder builder = new StringBuilder();
		    builder.append("Type of visa: ").append(visaType).append("\n");
		    builder.append("Issued date of visa: ").append(visaIssuedDate).append("\n");
		    builder.append("Expiration date of visa: ").append(visaExpirationDate).append("\n");
		    builder.append("Visa number: ").append(visaNumber).append("\n");
		    builder.append("Visa issuer: ").append(visaIssuer).append("\n").append("\n");
		    return builder.toString(); 
	    }
	}
	
    private Visa visa; 

    public PersonWithValidVisa() {
        super();
        this.visa = new Visa(Database.getVisaType(), Database.getVisaIssuedDate(), Database.getVisaExpirationDate(), Database.getVisaNumber(), Database.getVisaIssuer());
    }

    @Override
    public String displayInfo() {
    	
    	StringBuilder builder=new StringBuilder();
    	builder.append(super.displayInfo());
    	builder.append(visa.displayInfo());
    	return builder.toString(); 
    }
    
    @Override
    public boolean wantedMethod() {
        return DatabaseOfWantedPeople.isWanted(name, surname); 
    }
} 
