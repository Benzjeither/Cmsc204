import java.io.IOException;
import java.util.LinkedList;

/**
 * This is the interface to the Course Database Structure Class.  It is the data structure
 * class that is used with the Course Database Manager class.
 * This is a hash table with buckets.  Your hash table with be an array of 
 * linked lists of CourseDatabaseElements. Use the hashcode for a 
 * CourseDatabaseElement to find the location in the hash table for the linked lists of  
 * CourseDatabaseElements.
 * 
 * There should be two constructors.  The first one takes in an integer which represents the
 * estimated size of the hash table. 
 * 
 * Since the requirement is for a closed-addressing hash table (bucket hashing), 
 * you will not need to compute a 4k+3 prime.
 * 
 * If you were doing open-addressing, you would determine the size of the table by using a loading
 * factor of 1.5 and a 4K+3 prime.  Example: if you estimated 500 words, 500/1.5 = 333.  
 * The next 4K+3 prime over 333 is 347.  So the tableSize would be 347.
 * 
 * The other constructor will take in a String and an int.  The string will be "Testing"
 * and the int will be the size of the hash table.  This is used only for testing. 
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    public LinkedList<CourseDBElement>[] hashTable;


    @SuppressWarnings("unchecked")
	public CourseDBStructure(int estimatedSize) {
        hashTable = new LinkedList[estimatedSize];
    }

    @SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int hashTableSize){
        hashTable = new LinkedList[hashTableSize];
    }


    /** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
    public void add(CourseDBElement element) {
        int hashCode = element.hashCode();
     

        
        if (hashTable[hashCode%hashTable.length] != null){
            hashTable[hashCode%hashTable.length].add(element);
 
        }
        else{
        	hashTable[hashCode%hashTable.length] = new LinkedList<CourseDBElement>();
            hashTable[hashCode%hashTable.length].add(element);
        }
    }

  
	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param element the CDE to be added
	 * @throws IOException 
	*/
    @Override
	public CourseDBElement get(int crn) throws IOException {
		String str = crn + "";
		
		if(hashTable[str.hashCode() % hashTable.length] != null) { 
			for(int i = 0; i < hashTable.length; i++) {
				CourseDBElement element = hashTable[str.hashCode() % hashTable.length].get(i);
				
				if(element.getCRN() == crn) {
					return element;
				}
			}
		
		}
		else {
			throw new IOException();
		}
		return null;
	}
    

    public int getTableSize() {
        return hashTable.length;
    }



}