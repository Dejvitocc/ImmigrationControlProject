package People;

import Core.Database;
import Core.DatabaseOfWantedPeople;

public abstract class Person implements PersonInterface{
	protected static String name;
	protected static String surname;
	protected String contact;	
	 
	
	public Person() { 
		Person.name = Database.getName();  
        Person.surname = Database.getSurname(); 
        this.contact = Database.getContacts();
	}
	
	@Override
	public String displayInfo() { 
		 
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(name).append("\n");
        builder.append("Surname: ").append(surname).append("\n");
        builder.append("Contact: ").append(contact).append("\n");
        return builder.toString();
	}
	
	public abstract boolean wantedMethod(); 
 
	
}
