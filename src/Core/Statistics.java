package Core;

public class Statistics {
    private static int numberOfPassed = 0;
    private static int numberOfArrested = 0;
    private static int numberOfHealthProblems = 0;
    private static int numberOfValidVisa = 0;
    private static int numberOfAccommodation = 0;
    private static int numberOfStudyPlans = 0;
    private static int numberOfDeclaredItems = 0;
    private static int numberOfWithoutValidVisa = 0;

    public static void incPassed() {
        numberOfPassed++;
    }

    public static void incArrested() {
        numberOfArrested++;
    }

    // Increment methods for each type of person
    public static void incHealthProblems() {
        numberOfHealthProblems++;
    }

    public static void incValidVisa() {
        numberOfValidVisa++;
    }

    public static void incAccommodation() {
        numberOfAccommodation++;
    }

    public static void incStudyPlans() {
        numberOfStudyPlans++;
    }

    public static void incDeclaredItems() {
        numberOfDeclaredItems++;
    }

    public static void incWithoutValidVisa() {
        numberOfWithoutValidVisa++;
    } 
    
    public static void setAllToZero() {
    	numberOfPassed=0;
    	numberOfArrested=0;
    	numberOfAccommodation=0;
    	numberOfDeclaredItems=0;
    	numberOfHealthProblems=0;
    	numberOfStudyPlans=0;
    	numberOfValidVisa=0;
    	numberOfWithoutValidVisa=0;
    }
    
    
    
	public String countStatistics() {
				
		StringBuilder builder=new StringBuilder();
		builder.append("Number of passed: ").append(numberOfPassed).append(", number of arrested: ").append(numberOfArrested).append("\n\n");
		builder.append("Number of visitors:\n");
		if (numberOfHealthProblems!=0)
			builder.append("People with health problems: ").append(numberOfHealthProblems).append("\n");
		if (numberOfValidVisa!=0)
			builder.append("People with valid visa: ").append(numberOfValidVisa).append("\n");
		if (numberOfAccommodation!=0)
			builder.append("People with accommodation: ").append(numberOfAccommodation).append("\n");
		if (numberOfStudyPlans!=0)
			builder.append("People with study plans: ").append(numberOfStudyPlans).append("\n");
		if (numberOfDeclaredItems!=0)
			builder.append("People with declared items: ").append(numberOfDeclaredItems).append("\n");
		if (numberOfWithoutValidVisa!=0)
			builder.append("People without valid visa: ").append(numberOfWithoutValidVisa).append("\n\n");
		
		return builder.toString(); 

        } 
}
