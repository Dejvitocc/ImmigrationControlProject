package Core;

import java.time.LocalDate;

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
        /*System.out.println("Type of visa: "+visaType);
        System.out.println("Issued date of visa: "+visaIssuedDate);
        System.out.println("Expiration date of visa: "+visaExpirationDate);
        System.out.println("Visa number: "+visaNumber);
        System.out.println("Visa issuer: "+visaIssuer);*/ 
    	
    	StringBuilder builder = new StringBuilder();
	    builder.append("Type of visa: ").append(visaType).append("\n");
	    builder.append("Issued date of visa: ").append(visaIssuedDate).append("\n");
	    builder.append("Expiration date of visa: ").append(visaExpirationDate).append("\n");
	    builder.append("Visa number: ").append(visaNumber).append("\n");
	    builder.append("Visa issuer: ").append(visaIssuer).append("\n").append("\n");
	    return builder.toString(); 
    }
}