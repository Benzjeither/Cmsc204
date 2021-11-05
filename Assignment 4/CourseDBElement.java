@SuppressWarnings("rawtypes")
public class CourseDBElement implements Comparable{
	
	private String courseID;
	private String roomNum;
	private String instructorName;
	private int crn;
	private int numOfCredits;
	

	public CourseDBElement() {
		courseID = null;
		roomNum = null;
		instructorName = null;
		crn = 0;
		numOfCredits = 0;
	}
	
	public CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructorName) {
		super();
		this.courseID = courseID;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
		this.crn = crn;
		this.numOfCredits = numOfCredits;
	}

	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	public String getCourseID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public String getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}


	public String getInstructorName() {
		return instructorName;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}


	public int getCRN() {
		return crn;
	}


	public void setCRN(int crn) {
		this.crn = crn;
	}


	public int getNumOfCredits() {
		return numOfCredits;
	}


	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}


	public int compareTo(CourseDBElement element) {
		// TODO Auto-generated method stub
		return this.compareTo(element);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "\nCourse:" + courseID 
				+" CRN:" + crn 
				+ " Credits:" + numOfCredits 
				+ " Instructor:" + instructorName 
				+ " Room:" + roomNum;
	}

}