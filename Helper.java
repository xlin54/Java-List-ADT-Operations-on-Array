package listADToperationsOnArray;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NullPointerException;
public class Helper {

//the start method organize all the necessary testing implementations in one place
// the methods called inside the start method contains exceptions, the same exceptions should also be written at the start method header
	public static void start() throws FileNotFoundException, fullException, ListIndexOutOfBoundsException, VacantException {
// create an object of the ListBased class // create an array
		ListBased objectList = new ListBased();
		 
// check if the array is empty	
		 System.out.println(objectList.isEmpty());  //1
		 
// fill the array by calling the method name, since the method is static, we don't have to access it through an object 
		 fillList(objectList);  //2

// display the array		 
		 displayList(objectList);  //3
		 
		 System.out.println(" \n \n ");
		 System.out.println(" ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		 
//	 objectList.insert(0, " Hello Word");
		 /*
	Exception in thread "main" listADToperationsOnArray.fullException:  the array is full, You can NOT add anymore
	at listADToperationsOnArray.ListBased.insert(ListBased.java:34)
	at listADToperationsOnArray.Helper.start(Helper.java:24)
	at listADToperationsOnArray.Driver.main(Driver.java:10)
		  */
// professor instruction: For a full ADT bag, an exception
//	 should be thrown when inserting a new item into the bag
		 
		 
// get the list size

		 
		 System.out.println(objectList.size());
// remove random element
// we are removing the element, not decreasing the size, so the size remains the same
		 objectList.removeRandom();
		 System.out.println(objectList.size());
		 
// now we remove the final element by decreasing the size by one
		 objectList.removeLast();
		 System.out.println(objectList.size());
		 
// get the index of the matching item at first occurrence
		 objectList.getIndexOf1stOccurence("Carrot");
// index may be off by one because an element was removed by objectList.removeRandom()
	
// get an element by specifying its index 
		 System.out.println(objectList.getItemOfGivenIndex(2000));
		 
// make the array empty		 
		 objectList.makeEmpty();
		 
		 
		 //displayList(objectList);
		 // running displayList(objectList) will cause an exception because it is made empty by objectList.makeEmpty()
	}
	
// 	ListBased is the data type, objectList is the parameter that takes in an argument
	public static void fillList(ListBased objectList) throws FileNotFoundException, fullException{
		// scan the file, scan is a variable that refer to this file
		Scanner scan = new Scanner(new File("C:\\Users\\gygyg\\eclipse-workspace\\Project01ADT\\src\\listADToperationsOnArray\\100Fruits.txt"));
			int i = 0;
// hasNext() method returns true if this scanner has another token in its input.
			while(scan.hasNext()){
// insert each line consecutively in order by specifying the index in order
				objectList.insert(i, scan.nextLine().trim());
// index incrementing by 1 each round
				i++;
				}
// close the scanner
			scan.close(); 
			
	}

	
	public static void displayList(ListBased objectList) throws VacantException {
//	check if the array is empty if it is, then throw an exception 
// else display all the elements in the array
		if(objectList.isEmpty()) {
			throw new VacantException(" A mistake occured, an empty array can NOT be displayed");
		}else{ 
			for(int i = 0; i<objectList.size(); i++) {
				System.out.println(objectList.getItemOfGivenIndex(i));
		}

		}
		

	}
	

}
//try {
//	for(int i = 0; i<objectList.size(); i++) {
//		System.out.println(objectList.getItemOfGivenIndex(i));
//		}
//	if(objectList.isEmpty()) {
//		throw new VacantException();
//	}
//}catch(VacantException e){
//System.out.println(e.getMessage());
//}

//for(int i = 0; i< 120; i++) {
//if(scan.hasNext()) {
//	System.out.println(i);
//	System.out.println(scan.nextLine());