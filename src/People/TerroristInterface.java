package People;

public interface TerroristInterface {
	String terroristAttack();
	
	default String identify() { 
        return "This person seems like a terrorist\n";
    }
}
