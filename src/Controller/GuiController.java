package Controller;

import java.util.Random;

import Core.InstinctAdvisor;
import Core.Statistics;
import People.*;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class GuiController { 											//odovzdať UML do aisu, 2 vetvy do jednej viacvrstvej, abstraktná classa spraviť ako person!!!!!!!
	private static Random random=new Random();
	
	private static boolean clickedCallVisitor=false;
	private static boolean letHimPass=false;
	private static boolean letHimArrest=false;
	private static boolean endedDay=false;
	
	
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
	
	public static void visaPersonMethod(TextArea textArea) {
		boolean haveVisa=random.nextBoolean();
		if (haveVisa) {
			textArea.appendText("Yes, I do...\n");
			displayPersonWithValidVisa(textArea);
		} else {
			textArea.appendText("No, I do not...\n");
			displayPersonWithoutValidVisa(textArea);
		}
	}
	 
	 public static void displayPersonWithHealthProblems(TextArea textArea) {
		 if (clickedCallVisitor) {
			Statistics.incHealthProblems();
	        clickedCallVisitor=false;
			 
	        PersonWithHealthProblems person = new PersonWithHealthProblems();
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
			 
		 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    }
	 
	 public static void displayPersonWithAccomodation(TextArea textArea) {

		 
		 if (clickedCallVisitor) {
			Statistics.incAccommodation();
	        clickedCallVisitor=false;
			 
	        PersonWithAccomodation person = new PersonWithAccomodation();
	        String accomodationInfo = person.displayInfo(); 
	        textArea.appendText("Visitor:\n");
	        textArea.appendText(accomodationInfo); 
	        
	     
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
	        
		 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    }
	
	 public static void displayPersonWithDeclaredItems(TextArea textArea) {	        

		 
		 if (clickedCallVisitor) {
				Statistics.incDeclaredItems();
		        clickedCallVisitor=false;
				 
		        PersonWithDeclaredItems person = new PersonWithDeclaredItems();
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

		        
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    } 
	 
	 public static void displayPersonWithoutValidVisa(TextArea textArea) {	        

		 if (clickedCallVisitor) {
				Statistics.incWithoutValidVisa();
		        clickedCallVisitor=false;
				 
		        PersonWithoutValidVisa person = new PersonWithoutValidVisa();
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

		        
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    }
	 
	 public static void displayPersonWithStudyPlans(TextArea textArea) {

		 if (clickedCallVisitor) {
				Statistics.incStudyPlans();
		        clickedCallVisitor=false;
				 
		        PersonWithStudyPlans person = new PersonWithStudyPlans();
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

		        
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    }
	 
	 public static void displayPersonWithValidVisa(TextArea textArea) {	        

		 if (clickedCallVisitor) {
				Statistics.incValidVisa(); 
		        clickedCallVisitor=false;
				 
		        PersonWithValidVisa person = new PersonWithValidVisa();
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

		        
			 }else textArea.appendText("***No visitor around, please, call a visitor***\n");
	    }
	 
	 public static void displayStatistics(TextArea textArea) {
		 Statistics statistics = new Statistics();
		 String statisticsInfo=statistics.countStatistics();
		 textArea.appendText("\n***Day has ended. Boss gave you statistics: ***\n");
		 textArea.appendText(statisticsInfo);
		 endedDay=true;
	 }
	 
	 public static void letVisitorPass(TextArea textArea){
		 if (letHimPass) {
			Statistics.incPassed(); 
	        textArea.appendText("***Visitor passed***\n");
			letHimPass=false;
			letHimArrest=false;
		 }
		 else textArea.appendText("***You have no one to pass***\n");
	 }
	 
	 public static void letVisitorArrest(TextArea textArea) {
		 if (letHimArrest) {
			 Statistics.incArrested();
			 textArea.appendText("***Visitor arrested***\n");
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
	 
	 
	
	
	 
}
