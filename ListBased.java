package listADToperationsOnArray;

import java.util.Arrays;
import java.util.Random;

/*
 * class is a blueprint for an object, class describes the object,
 *  ListBased class models an list, so it should have a Constructor
 *   that creates an list, and contains all the  functions
 *  of the list, the list operations is implemented on the array
 */
//create an class that implements all the method from the interface 
public class ListBased implements ListADTinterface{
//myList is a variable that refers to a of type is object
	private Object[] myList;
// count counts the number of elements in the array
	private int count;
//Constructor creates an array
	public ListBased() {
// this.myList is the object type array whose size is 100
		this.myList = new Object[100];
		this.count = 0;
	}
	
	// check if the array is empty	
	@Override
	public boolean isEmpty() {
		/*boolean value = false;
		
// if the beginning element and the ending element of the array is both null then the array is empty
//null means that a variable contains a reference to a space in memory that does not contain an object		
		if (this.myList[0] == null && this.myList[99] == null) {
			value = true;
			//System.out.println(" each element in the array is null");
		}else if(this.myList.length == 0) {
			value = true;
			//System.out.println(" array length is 0");
		}*/
// set count to zero, the number of elements in the array is zero
		return this.count == 0;
	}

// inserting a item into array
	@Override
	public void insert(int index, Object item) throws ListIndexOutOfBoundsException, fullException{
// the range cannot be negative, Nor can it be bigger than the array size
// index cannot be equal to the array length, because array length start counting at 1, not 0
		if(index < 0 || index >= myList.length) {
// throws a custom exception if the index is inserted outside of the array
			throw new ListIndexOutOfBoundsException(" You can NOT insert outside of the range \n You must insert between 0 and " 
					+ (this.myList.length-1) );
//if the elements at position index zero is not null and the final element is not null, 
//			then the array is not null, but full
		}else if(this.myList[0] != null && this.myList[99] != null) {
			throw new fullException(" the array is full, You can NOT add anymore");
		}else {
//inserting a item into this.myList array
			this.myList[index]=item;
// each time the insert method gets called, count increment by one
			count++;
		}
	}

	@Override
	public int size() {
//return the number of elements in this array
		return this.count;
	}

// get the index of the matching item at first occurrence
	@Override
	public void getIndexOf1stOccurence(Object item) throws VacantException {
// macthedItem is a boolean type variable that refer to false
		boolean macthedItem = false;
// if the length of the array is zero, throw custom vacant exception 
		if(this.myList.length == 0 ) {
			throw new VacantException(" You can not find the first occurence of an matching item in a empty array");
		}else {
// else, run through each item in the array until the matching item is found
			for(int i = 0; i < this.myList.length; i++) {
				if(this.myList[i].equals(item)) {
					System.out.println("the first occurence of " + item + " is at index position " + i);
					macthedItem = true;
					break;	
				}
			}
//if the item is found by the previous for loop, then the statement would be: if(!true)
// which is false, so this if block will not run, but if the previous for loop did 
// not find a matching item, then, macthedItem never get a chance to become true
// macthedItem will stay the same, !false which is true, then the statement below runs 
			if(!macthedItem) {
				System.out.println(" there is no " + item + " in the array");
			}
		}	

	}

//	get an element by specifying its index	
	@Override
	public Object getItemOfGivenIndex(int index) throws ListIndexOutOfBoundsException, VacantException {
// filter out any index not within the array
		if(index < 0 || index >= this.myList.length) {
			throw new ListIndexOutOfBoundsException(" You can NOT get the object outside of the array, "
					+ "\n You must get the object between index 0 and  " + (this.myList.length-1));
// throws an custom exception if the size of the array is 0
		}else if(this.myList.length == 0) {
			throw new VacantException(" You can Not get an item in a empty array");
		}else {
// spits out the element of given index of the specifying array
			return this.myList[index];
		}
	}

// remove the final element
	@Override
	public void removeLast()throws VacantException {
// if array size is 0, throw an custom exception
		if(this.myList.length == 0) {
			throw new VacantException("you cannot remove the object at the final position in an empty array, \n"
					+ "for there is no final object in an empty array. ");
		}else {
// if size is not zero, cope the array and assign it to the same variable, but shrink size by one
			this.myList = Arrays.copyOf(this.myList, this.myList.length-1);
			count--;
		}		
	}

//	remove random element
	@Override
	public void removeRandom() throws VacantException, ListIndexOutOfBoundsException{
// generate a random index within the range
		Random r = new Random();
		int randomNumber = r.nextInt(this.myList.length);
		//System.out.println(randomNumber);
		
// if the index is out of range, throw custom out of bounds exception
		if(randomNumber < 0 || randomNumber >= myList.length) {
			throw new ListIndexOutOfBoundsException(" You can NOT remove objects out of range \n "
//myList.length-1, myList.length returns the number of elements in the array
// -1, which means (myList.length-1) is representing the final index				
					+ "You must insert between 0 and " + (myList.length-1));
// if the length of the array is empty, throw custom vacant exception 
		}else if(this.myList.length == 0){
			throw new VacantException(" You can NOT remove from an empty list");
		}else {
// else, get the element of the index(random number), the random number choose match
// index, store that element in eleRemoveAtRandom
			Object eleRemoveAtRandom = this.myList[randomNumber];
			System.out.println(eleRemoveAtRandom + " is the element choosen to remove randomly at index " + randomNumber);
// perform shifting from right to left, the element behind replace the front element
// myList[i] defines where to start replacing, and the element at this index is removed
// myList[i+1] is the the element after myList[i] used to replace myList[i]
// the shifting continues until final element is shifted left by one because of i++
			for(int i = randomNumber; i<(this.myList.length-1); i++) {
				this.myList[i] = this.myList[i+1];
			} 
// see if eleRemoveAtRandom is still in the array 
// after shifting operation was performed to removed the eleRemoveAtRandom
			boolean contains = Arrays.asList(this.myList).contains(eleRemoveAtRandom);
			if(contains) {
				System.out.println(" error!" + eleRemoveAtRandom + " is still contained in the array ");
			}else {
				System.out.println(eleRemoveAtRandom + " was successfully removed");
			}
// now that the final index is empty, a element was removed, decrement count by one
		    count--;
	
			}
		}
		
	

	@Override
	public void makeEmpty() {
//		this.myList = new Object[0];
//		if(this.myList.length == 0) {
//			System.out.println(" this array is made empty");		
//		this.myList = new Object[100];
//		for(Object iter: this.myList) {
//			iter = null
		
		
// this.myList refer to a space in memory that does NOT hold an object
		this.myList = null;
// set count to zero
		this.count = 0;
		}
	}


