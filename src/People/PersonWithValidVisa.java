package People;

import java.io.Serializable;

import Core.Database;
import Core.DatabaseOfWantedPeople;
import Core.Visa;

public class PersonWithValidVisa extends Person implements Serializable{
    private Visa visa; 

    public PersonWithValidVisa() {
        super();
        this.visa = new Visa(Database.getVisaType(), Database.getVisaIssuedDate(), Database.getVisaExpirationDate(), Database.getVisaNumber(), Database.getVisaIssuer());
    }

    @Override
    public String displayInfo() {
        /*super.displayInfo();
        visa.displayInfo(); */
    	
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
