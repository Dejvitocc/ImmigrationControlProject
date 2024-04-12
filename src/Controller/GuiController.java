package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.function.Consumer;										

import Core.InstinctAdvisor;
import Core.SerializationHelper;
import Core.Statistics;
import People.*;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class GuiController { 											//2 vetvy do jednej viacvrstvej
	private static Random random=new Random();
	
	private static boolean clickedCallVisitor=false;					//lambda -GuiController- visaPersonMethod
	private static boolean letHimPass=false;							//exception -GuiController- passOrArrestTextField
	private static boolean letHimArrest=false;							//default method implementation -Terrorist Interface-
	private static boolean endedDay=false;								//serialisation -GuiController-
																		//inner class -PersonWithValidVisa- visa class, inner interface -Database-
																		//RTTI -GuiController-
		
	public static void serializeObject(String filename, Serializable object) {				//serialisation
        try {
            SerializationHelper.serializeObject(filename, object);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static Object deserializeObject(String filename) {
        try {
            return SerializationHelper.deserializeObject(filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
    
	
	public static class InvalidInputException extends Exception {
	    public InvalidInputException(String message) {
	        super(message); 
	    } 
	}
	
	
	public static String callVisitorMethod() {
		int randomNumber=random.nextInt(4);
		 
		String statement="";
		
		if (!endedDay) {
			switch(randomNumber) {
			case 0: statement= "Visitor: \nHey!\n\n"; break;
			case 1: statement= "Visitor: \nHi there!\n\n"; break;
			case 2: statement= "Visitor: \nHow are you today?\n\n"; break;
			case 3: statement= "Visitor: \nWhat's up?\n\n"; break;
			}
		
		clickedCallVisitor=true;
		} else statement="***Day has already ended***\n";
		return statement;	
	}
	
	
	public static void visaPersonMethod(TextArea textArea) {					//lambda method
        
        Consumer<Boolean> visaConsumer = haveVisa -> { 
            if (haveVisa) {
                textArea.appendText("Yes, I do...\n");
                displayPersonWithValidVisa(textArea);  
            } else {
                textArea.appendText("No, I do not...\n");
                displayPersonWithoutValidVisa(textArea);
            }
        };

        visaConsumer.accept(random.nextBoolean());
    }
	 
	 public static void displayPersonWithHealthProblems(TextArea textArea) { 
		 if (clickedCallVisitor) {
			Statistics.incHealthProblems();
	        clickedCallVisitor=false;
			 
	        PersonWithHealthProblems person = new PersonWithHealthProblems();
	        GuiController.serializeObject("person_with_health_problems.ser", person);
	        
	        String healthInfo = person.displayInfo(); 
	        textArea.appendText("Visitor:\n");
	        textArea.appendText(healthInfo); 
	        
	     
	        int chanceOfTerroristAttack=random.nextInt(5);			
			int leftHandedTerroristOrTerrorist=random.nextInt(2);	
			
			if (chanceOfTerroristAttack<1) {					//chance of attack 1/5
				 
				 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2
					 Terrorist terroristPerson= new Terrorist(); 
					 textArea.appendText(terroristPerson.terroristAttack());
					 textArea.appendText("GAME OVER\n"); 
					 textArea.appendText("__________________________________________________________\n");
					 displayStatistics(textArea);
					 //Statistics.countStatistics();
					 return;
				 } 
				 else {
					 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
					 textArea.appendText(terroristPerson.terroristAttack());
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested();
					 textArea.appendText("***You can call another visitor***\n");
					 return;

				 }
				 
				 
			 }
			
			
			
			if (person.wantedMethod()) {
				 textArea.appendText("__________________________________________________________\n");
				 textArea.appendText("!!!WARNING!!!\n");
				 textArea.appendText("Wanted person detected!\n");
				 textArea.appendText("The order is to arrest!\n");
				 textArea.appendText("...\n");
				 textArea.appendText("Person arrested!\n");
				 textArea.appendText("__________________________________________________________\n");
				 Statistics.incArrested(); 
			} else {
				
				if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
					textArea.appendText("__________________________________________________________\n");
					textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
					 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
					 else textArea.appendText("Instinct tells him: ARREST!\n");
					 textArea.appendText("__________________________________________________________\n");
				 }
				 else { 
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
					 textArea.appendText("__________________________________________________________\n");

				 }
				textArea.appendText("***Pass or Not?***\n");
	        	letHimPass=true;
	        	letHimArrest=true;
			}
			 GuiController.displayObjectType(person, textArea);
		 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithHealthProblems deserializedPerson = (PersonWithHealthProblems) GuiController.deserializeObject("person_with_health_problems.ser");
		 
		 
	    }
	 
	 public static void displayPersonWithAccomodation(TextArea textArea) {

		 
		 if (clickedCallVisitor) {
			Statistics.incAccommodation();
	        clickedCallVisitor=false;
			 
	        PersonWithAccomodation person = new PersonWithAccomodation();
	        GuiController.serializeObject("person_with_accomodation.ser", person);

	        String accomodationInfo = person.displayInfo(); 
	        textArea.appendText("Visitor:\n");
	        textArea.appendText(accomodationInfo); 
	        
	     
	        int chanceOfTerroristAttack=random.nextInt(5);	
			int leftHandedTerroristOrTerrorist=random.nextInt(2);	
			
			if (chanceOfTerroristAttack<1) {					//chance of attack 1/5
				  
				 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2
					 Terrorist terroristPerson= new Terrorist(); 
//					 textArea.appendText(terroristPerson.terroristAttack());
					 textArea.appendText("GAME OVER\n"); 
					 textArea.appendText("__________________________________________________________\n");
					 displayStatistics(textArea);
					 return;
				 } 
				 else {
					 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
					 textArea.appendText(terroristPerson.terroristAttack());
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested();
					 textArea.appendText("***You can call another visitor***\n");
					 return;

				 }
				 
				 
			 }
			
			
			if (person.wantedMethod()) {
				 textArea.appendText("__________________________________________________________\n");
				 textArea.appendText("!!!WARNING!!!\n");
				 textArea.appendText("Wanted person detected!\n");
				 textArea.appendText("The order is to arrest!\n");
				 textArea.appendText("...\n");
				 textArea.appendText("Person arrested!\n");
				 textArea.appendText("__________________________________________________________\n");
				 Statistics.incArrested(); 
			} else {
				
				if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
					textArea.appendText("__________________________________________________________\n");
					textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
					 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
					 else textArea.appendText("Instinct tells him: ARREST!\n");
					 textArea.appendText("__________________________________________________________\n");
				 }
				 else { 
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
					 textArea.appendText("__________________________________________________________\n");

				 }
				textArea.appendText("***Pass or Not?***\n");
	        	letHimPass=true;
	        	letHimArrest=true;
			}
			GuiController.displayObjectType(person, textArea);
		 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithAccomodation deserializedPerson = (PersonWithAccomodation) GuiController.deserializeObject("person_with_accomodation.ser");

	    }
	
	 public static void displayPersonWithDeclaredItems(TextArea textArea) {	        

		 
		 if (clickedCallVisitor) {
				Statistics.incDeclaredItems();
		        clickedCallVisitor=false;
				 
		        PersonWithDeclaredItems person = new PersonWithDeclaredItems();
		        GuiController.serializeObject("person_with_declared_items.ser", person);
		        
		        String declaredItemsInfo = person.displayInfo(); 
		        textArea.appendText("Visitor:\n");
		        textArea.appendText(declaredItemsInfo); 
		        
		     
		        int chanceOfTerroristAttack=random.nextInt(5);	
				int leftHandedTerroristOrTerrorist=random.nextInt(2);	
				
				if (chanceOfTerroristAttack<1) {					//chance of attack 1/5
					 
					 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2
						 Terrorist terroristPerson= new Terrorist(); 
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("GAME OVER\n"); 
						 textArea.appendText("__________________________________________________________\n");
						 displayStatistics(textArea);
						 return;
					 } 
					 else {
						 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("__________________________________________________________\n");
						 Statistics.incArrested();
						 textArea.appendText("***You can call another visitor***\n");
						 return;

					 }
					 
					 
				 }
		        
				if (person.wantedMethod()) {
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("!!!WARNING!!!\n");
					 textArea.appendText("Wanted person detected!\n");
					 textArea.appendText("The order is to arrest!\n");
					 textArea.appendText("...\n");
					 textArea.appendText("Person arrested!\n");
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested(); 
				} else {
					
					if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
						textArea.appendText("__________________________________________________________\n");
						textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
						 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
						 else textArea.appendText("Instinct tells him: ARREST!\n");
						 textArea.appendText("__________________________________________________________\n");
					 }
					 else { 
						 textArea.appendText("__________________________________________________________\n");
						 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
						 textArea.appendText("__________________________________________________________\n");

					 }
					textArea.appendText("***Pass or Not?***\n");
		        	letHimPass=true;
		        	letHimArrest=true;
				}

				GuiController.displayObjectType(person, textArea);
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithDeclaredItems deserializedPerson = (PersonWithDeclaredItems) GuiController.deserializeObject("person_with_declared_items.ser");

	    } 
	 
	 public static void displayPersonWithoutValidVisa(TextArea textArea) {	        

		 if (clickedCallVisitor) {
				Statistics.incWithoutValidVisa();
		        clickedCallVisitor=false;
				 
		        PersonWithoutValidVisa person = new PersonWithoutValidVisa();
		        GuiController.serializeObject("person_without_valid_visa.ser", person);

		        String withoutVisaIfo = person.displayInfo(); 
		        textArea.appendText("Visitor:\n");
		        textArea.appendText(withoutVisaIfo); 
		        
		     
		        int chanceOfTerroristAttack=random.nextInt(5);	
				int leftHandedTerroristOrTerrorist=random.nextInt(2);	
				
				if (chanceOfTerroristAttack<1) {					//chance of attack 1/5
					 
					 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2
						 Terrorist terroristPerson= new Terrorist(); 
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("GAME OVER\n"); 
						 textArea.appendText("__________________________________________________________\n");
						 displayStatistics(textArea);
						 return;
					 } 
					 else {
						 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("__________________________________________________________\n");
						 Statistics.incArrested();
						 textArea.appendText("***You can call another visitor***\n");
						 return;

					 }
					 
					 
				 }
		        
				if (person.wantedMethod()) {
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("!!!WARNING!!!\n");
					 textArea.appendText("Wanted person detected!\n");
					 textArea.appendText("The order is to arrest!\n");
					 textArea.appendText("...\n");
					 textArea.appendText("Person arrested!\n");
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested(); 
				} else {
					
					if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
						textArea.appendText("__________________________________________________________\n");
						textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
						 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
						 else textArea.appendText("Instinct tells him: ARREST!\n");
						 textArea.appendText("__________________________________________________________\n");
					 }
					 else { 
						 textArea.appendText("__________________________________________________________\n");
						 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
						 textArea.appendText("__________________________________________________________\n");

					 }
					textArea.appendText("***Pass or Not?***\n");
		        	letHimPass=true;
		        	letHimArrest=true;
				}

				GuiController.displayObjectType(person, textArea);
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithoutValidVisa deserializedPerson = (PersonWithoutValidVisa) GuiController.deserializeObject("person_without_valid_visa.ser");

	    }
	 
	 public static void displayPersonWithStudyPlans(TextArea textArea) {

		 if (clickedCallVisitor) {
				Statistics.incStudyPlans();
		        clickedCallVisitor=false;
				 
		        PersonWithStudyPlans person = new PersonWithStudyPlans();
		        GuiController.serializeObject("person_with_study_plans.ser", person);

		        
		        String studyPlansInfo = person.displayInfo(); 
		        textArea.appendText("Visitor:\n");
		        textArea.appendText(studyPlansInfo); 
		        
		     
		        int chanceOfTerroristAttack=random.nextInt(5);	
				int leftHandedTerroristOrTerrorist=random.nextInt(2);	
				
				if (chanceOfTerroristAttack<1) {					//chance of attack 1/5
					 
					 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2
						 Terrorist terroristPerson= new Terrorist(); 
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("GAME OVER\n"); 
						 textArea.appendText("__________________________________________________________\n");
						 displayStatistics(textArea);
						 return;
					 } 
					 else {
						 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("__________________________________________________________\n");
						 Statistics.incArrested();
						 textArea.appendText("***You can call another visitor***\n");
						 return;

					 }
					 
					 
				 }
		        
				if (person.wantedMethod()) {
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("!!!WARNING!!!\n");
					 textArea.appendText("Wanted person detected!\n");
					 textArea.appendText("The order is to arrest!\n");
					 textArea.appendText("...\n");
					 textArea.appendText("Person arrested!\n");
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested(); 
				} else {
					
					if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
						textArea.appendText("__________________________________________________________\n");
						textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
						 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
						 else textArea.appendText("Instinct tells him: ARREST!\n");
						 textArea.appendText("__________________________________________________________\n");
					 }
					 else { 
						 textArea.appendText("__________________________________________________________\n");
						 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
						 textArea.appendText("__________________________________________________________\n");

					 }
					textArea.appendText("***Pass or Not?***\n");
		        	letHimPass=true;
		        	letHimArrest=true;
				}

				GuiController.displayObjectType(person, textArea);
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithStudyPlans deserializedPerson = (PersonWithStudyPlans) GuiController.deserializeObject("person_with_study_plans.ser");

	    }
	 
	 public static void displayPersonWithValidVisa(TextArea textArea) {	        

		 if (clickedCallVisitor) {
				Statistics.incValidVisa(); 
		        clickedCallVisitor=false;
				 
		        PersonWithValidVisa person = new PersonWithValidVisa();
		        GuiController.serializeObject("person_with_valid_visa.ser", person);

		        
		        String validVisaInfo = person.displayInfo(); 
		        textArea.appendText("Visitor:\n");
		        textArea.appendText(validVisaInfo); 
		        
		     
		        int chanceOfTerroristAttack=random.nextInt(5);	
				int leftHandedTerroristOrTerrorist=random.nextInt(2);	
				
				if (chanceOfTerroristAttack<1) {					//chance of attack 1/5			<1
					 
					 if (leftHandedTerroristOrTerrorist==0) {		//chance of left-handed 1/2		
						 Terrorist terroristPerson= new Terrorist(); 
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("GAME OVER\n"); 
						 textArea.appendText("__________________________________________________________\n");
						 displayStatistics(textArea);
						 return;
					 } 
					 else {
						 LeftHandedTerrorrist terroristPerson=new LeftHandedTerrorrist();
						 textArea.appendText(terroristPerson.terroristAttack());
						 textArea.appendText("__________________________________________________________\n");
						 Statistics.incArrested();
						 textArea.appendText("***You can call another visitor***\n");
						 return;
 
					 }
					  
					 
				 }
		        
				if (person.wantedMethod()) {
					 textArea.appendText("__________________________________________________________\n");
					 textArea.appendText("!!!WARNING!!!\n");
					 textArea.appendText("Wanted person detected!\n");
					 textArea.appendText("The order is to arrest!\n");
					 textArea.appendText("...\n");
					 textArea.appendText("Person arrested!\n");
					 textArea.appendText("__________________________________________________________\n");
					 Statistics.incArrested(); 
				} else {
					
					if (InstinctAdvisor.decideOrNotDecide()==false) {												//instinct
						textArea.appendText("__________________________________________________________\n");
						textArea.appendText("Pete can not decide on his own, he wants to follow his instincts.\n");
						 if (InstinctAdvisor.passOrNot()) textArea.appendText("Instinct tells him: PASS.\n");
						 else textArea.appendText("Instinct tells him: ARREST!\n");
						 textArea.appendText("__________________________________________________________\n");
					 }
					 else { 
						 textArea.appendText("__________________________________________________________\n");
						 textArea.appendText("Pete wants to be strong and independent, he wants to decide in his own.\n");
						 textArea.appendText("__________________________________________________________\n");

					 }
					textArea.appendText("***Pass or Not?***\n");
		        	letHimPass=true;
		        	letHimArrest=true;
				}
				
				GuiController.displayObjectType(person, textArea);
		        
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
		 
		 PersonWithValidVisa deserializedPerson = (PersonWithValidVisa) GuiController.deserializeObject("person_with_valid_visa.ser");

	    }
	 
	 public static void displayStatistics(TextArea textArea) {
		 Statistics statistics = new Statistics();
		 String statisticsInfo=statistics.countStatistics();
		 textArea.appendText("\n***Day has ended. Boss gave you statistics: ***\n");
		 textArea.appendText(statisticsInfo);
		 endedDay=true;
	 }
	 
	 public static void passOrArrestTextField(String input, TextArea textArea) {					
		    try {																						//exception
		        if (input.equalsIgnoreCase("pass")) GuiController.letVisitorPass(textArea);
		        else if (input.equalsIgnoreCase("arrest")) GuiController.letVisitorArrest(textArea);  
		        else throw new InvalidInputException("Invalid input! Enter 'pass' or 'arrest'.");
		        
		    } catch (InvalidInputException e) {
		        textArea.appendText("***Error: " + e.getMessage() + "***\n");
		    }
		}
	 
	 public static void letVisitorPass(TextArea textArea){
		 if (letHimPass) {
			Statistics.incPassed(); 
            textArea.appendText("***Visitor is allowed to pass.***\n");
			letHimPass=false;
			letHimArrest=false;
		 }
		 else textArea.appendText("***You have no one to pass***\n");
	 }
	 
	 public static void letVisitorArrest(TextArea textArea) {
		 if (letHimArrest) {
			 Statistics.incArrested(); 
			 textArea.appendText("***Visitor is under arrest.***\n");
			 letHimArrest=false;
			 letHimPass=false;
		 }
		 else textArea.appendText("***You have no one to arrest***\n");
	 }
	  
	 public static void startNewDay(TextArea textArea) {
		 if (endedDay) {
		    Platform.runLater(new Runnable() { 
		        @Override 
		        public void run() {
		            textArea.clear();
		        }
		    });
		    endedDay=false;
		    Statistics.setAllToZero();
		 }
		    
		}
	 
	 
	 public static void displayObjectType(Object object, TextArea textArea) {					//RTTI
		    if (object instanceof PersonWithHealthProblems) {
		        textArea.appendText("\n***Person with health problems has come.***\n");
		    } else if (object instanceof PersonWithAccomodation) {
		        textArea.appendText("\n***Person with accomodation booked has come.***\n");
		    } else if (object instanceof PersonWithDeclaredItems) {
		        textArea.appendText("\n***Person with declared items has come.****\n");
		    } else if (object instanceof PersonWithStudyPlans) {
		        textArea.appendText("\n***Person with study plans has come***\n");
		    } else if (object instanceof PersonWithValidVisa) {
		        textArea.appendText("\n***Person with valid visa has come.***\n");
		    } else if (object instanceof PersonWithoutValidVisa) {
		        textArea.appendText("\n***Person without valid visa has come.***\n");
		    } else {
		        textArea.appendText("\n***Unknown object type.***\n");
		    }
		}
	
	 
}
