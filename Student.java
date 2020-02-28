import java.io.Serializable;
/*
 * An interface for the StudentClass class.
 */
public interface Student {
	/*
	 *  Prints the courses that have availability.
	 */
	public void printOpenCourses();
	/*
	 * Registers a student in a course.
	 * @param courseName the name of the course to  be registered in
	 * @param section the section number of the course to be registered in
	 * @param first the student's first name
	 * @param last the student's last name
	 */
	public void register (String courseName, int section, String first, String last);
	/*
	 * Withdraws a student from a course.
	 * @param first the student's first name
	 * @param last the student's last name
	 * @param courseName the name of the course to withdraw from
	 */
	public void withdraw(String first, String last, String courseName);
	/*
	 * Prints the courses that the student is registered in
	 */
	public void printMyCourses();
	/*
	 *  Implements the printCourseMenu() method in user.
	 * 	prints the list of courses, with the basic information that a student is allowed to see
	 */
	public void printCourseMenu();
	/*
	 * @return the full name of the student
	 */
	public String getFullName();
	/*
	 * @return the id number of the student
	 */
	public int getID();
	}

