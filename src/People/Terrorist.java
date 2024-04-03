package People;

import java.util.Random;

public class Terrorist implements TerroristInterface{
	private Random random=new Random();
	
	@Override
	public String terroristAttack() {
		int randomNumber=random.nextInt(4);
		StringBuilder builder=new StringBuilder();
			
			if (randomNumber==0) {
				/*System.out.println("__________________________________________________________");
				System.out.println("This person seems like a terrorist");
				System.out.println("...");
				System.out.println("Terrorist tried to steal a plane");
				System.out.println("...");*/
				
				builder.append("__________________________________________________________\n");
				builder.append("This person seems like a terrorist\n");
				builder.append("...\n");
				builder.append("Terrorist tried to steal a plane\n");
				builder.append("...\n");
				
			}
			if (randomNumber==1) {
				/*System.out.println("__________________________________________________________");
				System.out.println("This person seems like a terrorist");
				System.out.println("...");
				System.out.println("Terrorist tried to detonate a bomb at the airport");
				System.out.println("...");*/
				
				builder.append("__________________________________________________________\n");
				builder.append("This person seems like a terrorist\n");
				builder.append("...\n");
				builder.append("Terrorist tried to detonate a bomb at the airport\n");
				builder.append("...\n");
				
			}
			if (randomNumber==2) {
				/*System.out.println("__________________________________________________________");
				System.out.println("This person seems like a terrorist");
				System.out.println("...");
				System.out.println("Terrorist tried to start shootig at the airport");
				System.out.println("...");*/
				
				builder.append("__________________________________________________________\n");
				builder.append("This person seems like a terrorist\n");
				builder.append("...\n");
				builder.append("Terrorist tried to start shootig at the airport\n");
				builder.append("...\n");
				 
			}
			if (randomNumber==3) {
				/*System.out.println("__________________________________________________________");
				System.out.println("This person seems like a terrorist");
				System.out.println("...");
				System.out.println("Terrorist tried to stab a stranger");
				System.out.println("...");*/
				
				builder.append("__________________________________________________________\n");
				builder.append("This person seems like a terrorist\n");
				builder.append("...\n");
				builder.append("Terrorist tried to stab a stranger\n");
				builder.append("...\n");
				
			}
			return builder.toString();
			
	}
}
