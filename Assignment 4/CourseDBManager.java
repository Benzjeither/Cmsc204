import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**Implements the CourseDBManagerInterface that is provided.
The data manager allows the user to read the courses from a file or to enter the data by hand, 
and uses an Alert to print out the database elements. The input is read from a file or read from 
the textfields and is added to the data structure through the add method.  The add method uses the CDS 
add method. The CourseDBManager is also referred to as a CDM.

*/

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure = new CourseDBStructure(30);
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override

	public void readFile(File input) throws FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(input);
		do {

			String instructorName = "";
			String roomNum = "";
			String inputFile = sc.nextLine();
			String[] listOfFiles = inputFile.split(" ");
			
			int crn = Integer.parseInt(listOfFiles[1]);
			int numOfCredits = Integer.parseInt(listOfFiles[2]);
			
			boolean name = false;
			String courseID = listOfFiles[0];

	
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].charAt(listOfFiles[i].length()-1)=='.' 
						&& listOfFiles[i].length()==2) {
					name = true;
				}
			}
			if (name == true) {
				
				for (int i = 3; i < listOfFiles.length-i; i++) {
					roomNum += listOfFiles[i];
				}
				instructorName = listOfFiles[listOfFiles.length-3] 
						         + listOfFiles[listOfFiles.length-2] 
						         + listOfFiles[listOfFiles.length-1];
				this.add(courseID, crn, numOfCredits, roomNum, instructorName);
			
				
			}else {
				
				for (int i = 3; i < listOfFiles.length-2; i++) {
					roomNum += listOfFiles[i];
				}
				instructorName = listOfFiles[listOfFiles.length-2]
								+ listOfFiles[listOfFiles.length-1];
				this.add(courseID, crn, numOfCredits, roomNum, instructorName);
			}
		} while (sc.hasNextLine());
		
	}

	@Override
	public ArrayList<String> showAll() throws IndexOutOfBoundsException 
	{
		ArrayList<String> list = new ArrayList<String>();
		String dataTable = "";
		try {
			for (LinkedList<CourseDBElement> element : structure.hashTable) {
				
				if(element != null) {

					for (int i = 0; i < element.size(); i++) {
						dataTable = element.get(i).toString();
						list.add(dataTable);
					}
				}
			}
		}catch(IndexOutOfBoundsException  e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
