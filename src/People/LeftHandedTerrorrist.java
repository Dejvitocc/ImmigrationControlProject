package People;


public class LeftHandedTerrorrist extends Terrorist implements TerroristInterface{

	@Override
	public String terroristAttack() {
			/*super.terroristAttack();
			System.out.println("But... He is left-handed and got arrested");
			System.out.println("Everyone is okey");
			System.out.println("...");*/
			
			StringBuilder builder=new StringBuilder();
			builder.append(super.terroristAttack());
			builder.append("But... He is left-handed and got arrested\n");
			builder.append("...\n");
			
			return builder.toString();
			
	}
}
