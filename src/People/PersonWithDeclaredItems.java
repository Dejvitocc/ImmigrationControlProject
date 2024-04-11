package People;

import java.time.LocalDate;
//import Controller.*;
import java.util.Random;

import Core.Database;
import Core.DatabaseOfWantedPeople;

public class PersonWithDeclaredItems extends Person{
	private String[] declaredItemsList;
	private double totalValueOfDeclaredItems;
	private LocalDate declarationDate;
	private String customsOfficerName;
	
	public PersonWithDeclaredItems() {
		super();
		this.declaredItemsList=new String[2];
		this.declarationDate=Database.getDeclarationDate();
		this.customsOfficerName=Database.getCustomsOfficerName();
		
		String[] tempArrayOfDeclaredItemsList=new String[5];
		tempArrayOfDeclaredItemsList=Database.getDeclaredItemList();
		
		Random random=new Random();
		for (int i=0;i<2;i++) {
			int resultOfRandom=random.nextInt(5);
		
			this.declaredItemsList[i]=tempArrayOfDeclaredItemsList[resultOfRandom];
		
			while (declaredItemsList[0]==declaredItemsList[1]) {
				resultOfRandom=random.nextInt(5);
				this.declaredItemsList[1]=tempArrayOfDeclaredItemsList[resultOfRandom];
			}
		}
		
		double sum=0;
		for (int i=0;i<2;i++) {
			if (declaredItemsList[i]=="Larger amount of currency")sum+=1000.0;
			if (declaredItemsList[i]=="Firearms and ammunation")  sum+=2340.5;
			if (declaredItemsList[i]=="Fruits and vegetables") 	  sum+=30.90;
			if (declaredItemsList[i]=="Alcohol")				  sum+=50.27;
			if (declaredItemsList[i]=="Tobacco products")		  sum+=135.0;
		}
		this.totalValueOfDeclaredItems=sum;
		
		}
	@Override
	public String displayInfo() {
		/*super.displayInfo();
        System.out.println("Declared items: "+declaredItemsList[0]+", "+declaredItemsList[1]);
        System.out.println("Total value of declared items: "+totalValueOfDeclaredItems);
        System.out.println("Date of declaration: "+declarationDate);
        System.out.println("Name of customs officer: "+customsOfficerName);*/
		
		StringBuilder builder = new StringBuilder();
		builder.append(super.displayInfo()); // Použite metódu z nadradenej triedy na získanie základných informácií
	    builder.append("Declared items: ").append(declaredItemsList[0]).append(", ").append(declaredItemsList[1]).append("\n");
	    builder.append("Total value of declared items: : ").append(totalValueOfDeclaredItems).append("\n");
	    builder.append("Date of declaration: ").append(declarationDate).append("\n");
	    builder.append("Name of customs officer: ").append(customsOfficerName).append("\n").append("\n");
	    return builder.toString();
	}
	
	@Override
    public boolean wantedMethod() {
        return DatabaseOfWantedPeople.isWanted(name, surname); 
    }
		
} 
