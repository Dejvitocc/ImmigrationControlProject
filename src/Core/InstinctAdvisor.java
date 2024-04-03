package Core;

import java.util.Random;

public class InstinctAdvisor {
	static Random random=new Random();
	private static int resultOfRandom=random.nextInt(10)+1;
	
	public static boolean decideOrNotDecide() {
		if (resultOfRandom>=4) return false;
		else return true;
	}
	
	public static boolean passOrNot() {
			resultOfRandom=random.nextInt(2);
			if (resultOfRandom==0) return false;
			else return true;
		
	} 
}
 