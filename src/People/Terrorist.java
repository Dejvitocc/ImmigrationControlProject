package People;

import java.util.Random;

public class Terrorist implements TerroristInterface{
	private Random random=new Random();
	
	@Override
	public String terroristAttack() {
		int randomNumber=random.nextInt(4);
		StringBuilder builder=new StringBuilder();
			
			if (randomNumber==0) {

				builder.append("__________________________________________________________\n");
				builder.append(identify());
				builder.append("...\n");
				builder.append("Terrorist tried to steal a plane\n");
				builder.append("...\n");
				
			}
			if (randomNumber==1) {

				
				builder.append("__________________________________________________________\n");
				builder.append(identify());
				builder.append("...\n");
				builder.append("Terrorist tried to detonate a bomb at the airport\n");
				builder.append("...\n");
				
			}
			if (randomNumber==2) {

				
				builder.append("__________________________________________________________\n");
				builder.append(identify());
				builder.append("...\n");
				builder.append("Terrorist tried to start shootig at the airport\n");
				builder.append("...\n");
				 
			}
			if (randomNumber==3) {

				
				builder.append("__________________________________________________________\n");
				builder.append(identify());
				builder.append("...\n");
				builder.append("Terrorist tried to stab a stranger\n");
				builder.append("...\n");
				
			}
			return builder.toString();
			
	}
}
