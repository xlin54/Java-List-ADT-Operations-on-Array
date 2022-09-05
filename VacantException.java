package listADToperationsOnArray;

public class VacantException extends RuntimeException {
	
// when called without a message passed, the message inside this constructor will run
	public VacantException() {
		super(" a mistake occured, the array is vacant ! ");
	}
// when called with a message passed, this message will run by the RuntimeException class
	public VacantException(String message) {
		super(message);
	}
}