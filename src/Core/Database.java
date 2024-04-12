
package Core;

import java.time.LocalDate;
import java.util.Random;

public class Database {
	
	
	interface DatabaseInterface{
		int randomMethod();
		void setArrayOfVisaExpirationDate();
		void setArrayOfAccomodationCheckOutDate();
		void setArrayOfStudyEndDate();
		String getName();
		String getSurname();
		String getContacts();
		String getTypeOfDisorder();
		String getMedicines();
		String getAllergies();
		String getSpecialMedicalNeeds();
		String getVisaType();
		String getVisaNumber();
		String getVisaIssuer();
		LocalDate getVisaIssuedDate();
		LocalDate getVisaExpirationDate();
		
		interface DatabaseInterface1{
			String getAccomodationType();
			String getAccomodationCity();
			String getAccomodationConfirmationNumber();
			LocalDate getAccomodationChechInDate();
			LocalDate getAccomodationChechOutDate();
			String getEducationalInstitution();
			String getDegreeProgram();
			String getStudentID();
			LocalDate getStudyStartDate();
			LocalDate getStudyEndDate();
			String[] getDeclaredItemList();
			LocalDate getDeclarationDate();
			String getCustomsOfficerName();
			String getReasonForNoVisa(); 
			String getPlannedActivities();
		}
	}
	
	private static String[] arrayOfNames= {"Elias", "Ava", "Leo", "Sophie", "Mateo"};
	private static String[] arrayOfSurnames= {"Smith", "Johnson","Lee","Silva", "Martinez"};
	private static String[] arrayOfContacts= {"0929456728", "0997105643","0947151333","0958745349", "0914835412"};
	
	private static String[] arrayOfTypeOfDisorder= {"Tuberculosis","COVID-19","HIV/AIDS","Schizophrenia","Mobility impairment"};
	private static String[] arrayofMedicines= {"Medicine for tuberculosis","Acylpyrine","Medicine for HIV/AIDS","Medicine for schizophrenia","None"};
	private static String[] arrayOfAllergies= {"Peanuts","Grass Pollen","Cats","Wasps","None"};
	private static String[] arrayOfSpecialMedicalNeeds= {"Wheel chair"};
	
	private static String[] arrayOfVisaType= {"Tourist visa","Student visa","Work visa","Refugee visa", "Family Visa"};
	private static LocalDate[] arrayOfVisaIssuedDate= {
			LocalDate.of(2023, 7, 8),
            LocalDate.of(2024, 1, 9), 
            LocalDate.of(2023, 12, 10),
            LocalDate.of(2024, 2, 11),
            LocalDate.of(2023, 8, 12) 
	};
	private static LocalDate[] arrayOfVisaExpirationDate= new LocalDate[5];
	private static String[] arrayOfVisaNumber= {"174962815","957134864","796485210","100597234","597070076"};
	private static String[] arrayOfVisaIssuer= {"Great Britain","Italy","Niederlands","Austria","Spain"};
	
	private static String[] arrayOfAccomodationType= {"Hotel","Hostel","Camping","Servied Apartments","Questhouse"};
	private static String[] arrayOfAccomodationCity= {"New York City","Los Angeles","Chicago","Las Vegas","Washington"};
	private static LocalDate[] arrayOfAccomodationChechInDate= {LocalDate.now()};
	private static LocalDate[] arrayOfAccomodationCheckOutDate= new LocalDate[5];
	private static String[] arrayOfAccomodationConfirmationNumber= {"ABC123456789","987ZYX654321","HJK789456123","QWE654123789","LMN456321987"};
	
	private static String[] arrayOfEducationalInstitution= {"Harvard University","Massachusetts Institute of Technology","Stanford University","Yale University", "Princeton University"};
	private static String[] arrayOfDegreeProgram= {"Bachelor","Master","Doctor","Bachelor","Master"};
	private static String[] arrayOfStudentID= {"URS123456","CCHS987654","EE12345","BA202210","MC567890"};
	private static LocalDate[] arrayOfStudyStartDate= {LocalDate.now().plusDays(3)};
	private static LocalDate[] arrayOfStudyEndDate= new LocalDate[5];
	
	private static LocalDate[] arrayOfDeclarationDate= {LocalDate.now().minusDays(2)};
	private static String[] arrayOfCustomsOfficerName= {"Alexander","Benjamin","Liam","Elijah","Mason"};
	private static String[] arrayOfDeclaredItemsList= {"Larger amount of currency","Firearms and ammunation","Fruits and vegetables","Alcohol","Tobacco products"};
	
	private static String[] arrayOfReasonForNoVisa= {"VWP (Visa Waiver Program)","Reciprocal agreement","Diplomatic or Official passport holder","Reciprocal agreement","Specific travel purpose"};
	private static String[] arrayOfPlannedActivities= {"Tourism","Business meeting","Attending cultural or sports event","Medical treatment","Short course or worshop"};
	


	

    private static Random random = new Random();
    private static int randomIndex;

    private static int randomMethod() {
        return randomIndex = random.nextInt(5);
    }
    
    private static void setArrayOfVisaExpirationDate() {		
    	for (int i=0;i<5;i++) {
    		LocalDate nextYear= arrayOfVisaIssuedDate[i].plusYears(1);
    		arrayOfVisaExpirationDate[i]=nextYear;
    	}
    }			
    
    private static void setArrayOfAccomodationCheckOutDate() {
    	Random weekOrMonth = new Random();
    	for (int i=0;i<5;i++) {
    		int resultOfWeekOrMonth=weekOrMonth.nextInt(3);
    		
    		if (resultOfWeekOrMonth==0) {
    			LocalDate nextWeek=arrayOfAccomodationChechInDate[0].plusWeeks(1);
    			arrayOfAccomodationCheckOutDate[i]=nextWeek;
    		}
    		if (resultOfWeekOrMonth==1) {
    			LocalDate nextWeek=arrayOfAccomodationChechInDate[0].plusWeeks(2);
    			arrayOfAccomodationCheckOutDate[i]=nextWeek;
    		}
    		if (resultOfWeekOrMonth==2) {
    			LocalDate nextMonth=arrayOfAccomodationChechInDate[0].plusMonths(1);
    			arrayOfAccomodationCheckOutDate[i]=nextMonth;
    		}
    	}
    }
    
    private static void setArrayOfStudyEndDate() {
    	Random numberOfYears=new Random();
    	for (int i=0;i<5;i++) {
    		int resultOfNumberOfYears=numberOfYears.nextInt(3);
    		
    		if (resultOfNumberOfYears==0) {
    			LocalDate oneYear=arrayOfStudyStartDate[0].plusYears(1);
    			arrayOfStudyEndDate[i]=oneYear;
    		}
    		if (resultOfNumberOfYears==1) {
    			LocalDate twoYears=arrayOfStudyStartDate[0].plusYears(2);
    			arrayOfStudyEndDate[i]=twoYears;
    		}
    		if (resultOfNumberOfYears==2) {
    			LocalDate threeYears=arrayOfStudyStartDate[0].plusYears(3);
    			arrayOfStudyEndDate[i]=threeYears;
    		} 
    	}
    }
    
    
    
    public static String getName() {						// getters for Persons attributes
        return arrayOfNames[randomMethod()];
    }

    public static String getSurname() {
        return arrayOfSurnames[randomMethod()];
    }

    public static String getContacts() {
        return arrayOfContacts[randomMethod()];
    }
    
    
    
    public static String getTypeOfDisorder() {				// getters for PersonWithHealthProblems's attributes
    	randomMethod();
    	return arrayOfTypeOfDisorder[randomIndex];
    }
    
    public static String getMedicines() {
    	return arrayofMedicines[randomIndex];
    }
    
    public static String getAllergies() {
    	return arrayOfAllergies[randomMethod()];
    }
    
    public static String getSpecialMedicalNeeds() {
    	return arrayOfSpecialMedicalNeeds[0];
    }
    
    
    public static String getVisaType() {					// getters for PersonWithValidData's attributes
    	return arrayOfVisaType[randomMethod()];
    }
    
    public static String getVisaNumber() {
    	return arrayOfVisaNumber[randomMethod()];
	}
    public static String getVisaIssuer() {
    	return arrayOfVisaIssuer[randomMethod()];
    }
    public static LocalDate getVisaIssuedDate() {
    	randomMethod();
    	return arrayOfVisaIssuedDate[randomIndex];
    }
    public static LocalDate getVisaExpirationDate() {
    	setArrayOfVisaExpirationDate();
    	return arrayOfVisaExpirationDate[randomIndex];
    }
    
    
    
    public static String getAccomodationType() {			//getters for PersonWithAccomodation's attributes
    	return arrayOfAccomodationType[randomMethod()];
    }
    public static String getAccomodationCity() {
    	return arrayOfAccomodationCity[randomMethod()];
    }
    public static String getAccomodationConfirmationNumber() {
    	return arrayOfAccomodationConfirmationNumber[randomMethod()];
    }
    public static LocalDate getAccomodationChechInDate() {
    	return arrayOfAccomodationChechInDate[0];
    }
    public static LocalDate getAccomodationCheckOutDate() {
    	setArrayOfAccomodationCheckOutDate();
    	return arrayOfAccomodationCheckOutDate[randomMethod()];
    }
    
    
    public static String getEducationalInstitution() {		//getters for PersonWithStudyPlans's attributes
    	return arrayOfEducationalInstitution[randomMethod()];
    }
    public static String getDegreeProgram() {
    	return arrayOfDegreeProgram[randomMethod()];
    }
    public static String getStudentID() {
    	return arrayOfStudentID[randomMethod()];
    }
    public static LocalDate getStudyStartDate() {
    	return arrayOfStudyStartDate[0];
    }
    public static LocalDate getStudyEndDate() {
    	setArrayOfStudyEndDate();
    	return arrayOfStudyEndDate[randomMethod()]; 
    }
     
    
    public static String[] getDeclaredItemList() {		//getters for PersonWithDeclaredItems's attributes
    	return arrayOfDeclaredItemsList;
    } 
    public static LocalDate getDeclarationDate() {
    	return arrayOfDeclarationDate[0];
    }
    public static String getCustomsOfficerName() {
    	return arrayOfCustomsOfficerName[randomMethod()];
    }
    
    
    public static String getReasonForNoVisa() {			//getters for PersonWithoutValidVisa's attributes
    	return arrayOfReasonForNoVisa[randomMethod()];
    } 
    public static String getPlannedActivities() {
    	return arrayOfPlannedActivities[randomMethod()];
    }
    
} 

