package listADToperationsOnArray;

//ListIndexOutOfBoundsException is the exception thrown if the index is inserted outside of the array

public class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {
	
//    constructs an object of this class
	public ListIndexOutOfBoundsException(String message) {
// call the IndexOutOfBoundsException class and pass insert the parameter
// for the parent class to handle
		super(message);
	}
}