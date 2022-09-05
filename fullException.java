package listADToperationsOnArray;

public class fullException extends Exception{
// fullException executes when array meets the condition:
// add into an array that is already full
// the customized message will be thrown 
	public fullException(String message){
		super(message);
	}
}
