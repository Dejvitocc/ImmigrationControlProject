package People;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;

import Core.Database;
import Core.DatabaseOfWantedPeople;

public class PersonWithoutValidVisa extends PersonWithAccomodation implements Serializable{
		private String reasonForNoVisa;
		private long intendedStayDuration;
		private String intendedDestination;
		private String plannedActivities;
		
		public PersonWithoutValidVisa() {
			super();
			this.reasonForNoVisa=Database.getReasonForNoVisa();
			this.intendedStayDuration=accomodationCheckInDate.until(accomodationCheckOutDate,ChronoUnit.DAYS);     
			this.intendedDestination=accomodationCity;
			this.plannedActivities=Database.getPlannedActivities();

		}
		
		@Override 
		public String displayInfo() {
			/*super.displayInfo();
	        System.out.println("Reason for not having visa: "+reasonForNoVisa);
	        System.out.println("Intended duration of stay: "+intendedStayDuration);
	        System.out.println("Intended destination: "+intendedDestination);
	        System.out.println("Planned activities: "+plannedActivities);*/
			
			StringBuilder builder = new StringBuilder();
			builder.append(super.displayInfo()); // Použite metódu z nadradenej triedy na získanie základných informácií
		    builder.append("Reason for not having visa: ").append(reasonForNoVisa).append("\n");
		    builder.append("Intended duration of stay: ").append(intendedStayDuration).append("\n");
		    builder.append("Intended destination: ").append(intendedDestination).append("\n");
		    builder.append("Planned activities: ").append(plannedActivities).append("\n").append("\n");
		    return builder.toString();
		}
		
		@Override
	    public boolean wantedMethod() {
	        return DatabaseOfWantedPeople.isWanted(name, surname); 
	    }
		
}
 