package Core;

public class PassOrArrestException extends Exception{
	private String message;
	
	public PassOrArrestException(String message) {
		super(message);
		this.message=message; 
	}
	
	public String getMessage(){
		return message;
	}

}
