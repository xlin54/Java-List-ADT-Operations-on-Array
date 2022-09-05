package listADToperationsOnArray;

// an interface is a blueprint for its subclass
// it tells the subclass "What" it should do, which is the methods
// the methods are generic, meaning it does not say in detail "HOW" to do something
// that is for its subclasses to customize

public interface ListADTinterface {
// public is the access modifier, public members are visible to all other classes
// boolean is the return type, isEmpty is the name of the method
// this method can return true or false depends on whether or not the list is empty
	public boolean isEmpty();
	
// takes in two arguments to put in the integer type parameter, object type parameter
// if the list is full, fullException is executed when additional elements are trying to be added
// // throws a custom exception if the index is inserted outside of the array
	public void insert(int index, Object item) throws ListIndexOutOfBoundsException, fullException;
	
	public int size();
	
	public void getIndexOf1stOccurence(Object item) throws VacantException;
	
	public Object getItemOfGivenIndex(int index) throws ListIndexOutOfBoundsException, VacantException; 
	
	public void removeLast() throws VacantException;
	
	public void removeRandom()throws VacantException, ListIndexOutOfBoundsException;
	
	public void makeEmpty();
	
	
	
	
	
	
	
	
	
}
