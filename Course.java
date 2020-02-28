import java.io.Serializable;
import java.util.ArrayList;
public class Course implements Serializable{
	private String courseName;
	private String id;
	private int max;
	private int registered;
	private ArrayList <StudentClass> registeredStudents; 
	private String instructor; 
	private int section; 
	private String location;
	/*
	 * Constructs a course object.
	 */
	Course(){
		
	}
	/*
	 * Constructs a course object with a name, id, maximum amount of students, registered amount of students, list of registered students, instructor name, section number, and location.
	 * @param courseName the name of the course
	 * @param id the id of the course
	 * @param max the maximum amount of students allowed in a course.
	 * @param registered the amount of students currently in the course.
	 * @param registeredStudents a list of the students registered in the course
	 * @param instructor the instructor's name
	 * @param section the section number
	 * @param location the location of the course
	 */
	Course(String courseName, String id, int max, int registered, ArrayList <StudentClass> registeredStudents, String instructor, int section, String location){
		this.courseName = courseName;
		this.id = id;
		this.max = max;
		this.registered = registered;
		this.registeredStudents = registeredStudents;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
	}
	/*
	 * @return the name of the course
	 */
	public String getCourseName() {
		return courseName;
	}
	/*
	 * @return the id of the course
	 */
	public String getID() {
		return id;
	}
	/*
	 * @return the maximum amount of students allowed in the course.
	 */
	public int getMax() {
		return max;
	}
	/*
	 * sets the maximum amount of students allowed in the course to the inputed value
	 * @param max the new maximum amount of students allowed in the course.
	 */
	public void setMax(int max) {
		this.max = max;
	}
	/*
	 * @return the amount of students registered in the course
	 */
	public int getRegistered() {
		return registered;
	}
	/*
	 * Increases the amount of students registered in the course by one.
	 */
	public void increaseRegistered() {
		this.registered++;
	}
	/*
	 * Decreases the amount of students registered in the course by one.
	 */
	public void decreaseRegistered() {
		this.registered--;
	}
	/*
	 * sets the instructor name
	 * @param instructor the new instructor name
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/*
	 * @return the section number of the course
	 */
	public int getSection() {
		return section;
	}
	/*
	 * sets the section number of the course.
	 * @param section the new section number
	 */
	public void setSection(int section) {
		this.section= section;
	}
	/*
	 * sets the location of the course
	 * @param location the new location of the course
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/*
	 * @return a string that contains the students registered in the course
	 */
	public String printRegisteredStudents() {
		String print = "";
		for(StudentClass student: registeredStudents) {
			print+= (student.getFullName() + " " +  student.getID() +  ", ") ;
		}
		return print;
	}
	/*
	 * @return the list of students registered in a course
	 */
	public ArrayList <StudentClass> getRegisteredStudents(){
		return registeredStudents;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * overrides the toStringMethod.
	 */
	public String toString() {
		return ("\nTitle: " + courseName + "\nID: " +  id);
	}
	/*
	 * @return the information about a course that an admin has access to: course name, id, instructor, section, location, amount of students registered, maximum capacity, and the students in the course.
	 */
	public String adminToString() {
		return ("\nTitle: " + courseName + "\nID: " +  id + "\nInstructor: " + instructor + "\nSection: " + section + "\nLocation: " + location + "\nAmount of students in class:  " + registered + "\nClass maximum capacity: " + max + "\nRegistered students: " + printRegisteredStudents());
	}
	/*
	 * @return the information about a course that a student has access to: the course name, id, instructor, section, and location.
	 */
	public String studentToString() {
		return ("\nTitle: " + courseName + "\nID: " +  id + "\nInstructor: " + instructor + "\nSection: " + section + "\nLocation: " + location);
	}
	
	
}
