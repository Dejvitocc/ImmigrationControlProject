package Core;

public class DatabaseOfWantedPeople {
	private static String[] databaseOfWantedNames= {"Elias","Elias","Ava","Ava","Leo","Mateo","Sophie"};
	private static String[] databaseOfWantedSurnames= {"Johnson","Martinez","Lee","Johnson","Silva","Lee","Martinez"};
	
	
	public static boolean isWanted(String name, String surname){
		for (int i=0;i<databaseOfWantedNames.length;i++) {
			if (databaseOfWantedNames[i].equals(name) && databaseOfWantedSurnames[i].equals(surname)) {
				return true;
			}
			
		}
		return false;
	} 
	 
	
} 
