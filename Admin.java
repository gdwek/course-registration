import java.util.ArrayList;
import java.io.Serializable;
public interface Admin{
	/*
	 * Allows the admin to create a new course.
	 * @param courseName the name of the course
	 * @param id the id of the course
	 * @param max the maximum amount of students allowed in a course.
	 * @param registered the amount of students currently in the course.
	 * @param registeredStudents a list of the students registered in the course
	 * @param instructor the instructor's name
	 * @param section the section number
	 * @param location the location of the course
	 */
	public void createNewCourse(String courseName, String id, int max, int registered, ArrayList <StudentClass> registeredStudents, String instructor, int section, String location);
	/*
	 * Allows the admin to delete a course.
	 * @param courseName the name of the course to be deleted
	 * @param section of the course to be deleted
	 */
	public void deleteCourse(String courseName, int section);
	/*
	 * Allows the admin to delete a course.
	 * @param courseName the name of the course to be deleted
	 * @param id the id of the course to be deleted
	 */
	public void deleteCourse(String courseName, String id);
	/*
	 * Allows the admin to edit the course maximum students, instructor, section number, or location.
	 * @param courseName the name of the course to be edited
	 * @param section the section number of the course to be edited
	 */
	public void editCourse(String courseName, int section);
	/*
	 * Prints the course name, id, maximum amount of students, amount of registered students, list of registered students, instructor name, section number, and location for a specific course.
	 * @param id the id of the course the admin wants information about.
	 */
	public void printCourseInfo(String id);
	/*
	 * Allows the admin to add a student to the system.
	 * @param first  the new student's first name
	 * @param last   the new student's last name
	 * @param username   the new student's username
	 * @param password   the new student's password
	 * @param id  the new student's id number
	 */
	public void addStudent(String first, String last, String username, String password, int id);
	/*
	 * Prints the courses that have reached maximum student capacity.
	 */
	public void printFullCourses();
	/*
	 * Writes the courses that have reached maximum student capacity to a text file.
	 */
	public void writeFullCoursestoFile();
	/*
	 * Prints the students in a specific course.
	 * @param courseName the specific course's name
	 * @param id the specific course's id
	 */
	public void studentsInCourse (String courseName, String id);
	/*
	 * Prints the courses a specific student is registered in
	 * @param first the specific student's first name
	 * @param last the specific student's last name
	 */
	public void studentsCourses(String first, String last);
	/*
	 * Sorts the courses in ascending order based on amount of registered students.
	 */
	public void sortCourses();
	/*
	 * Implements the abstract user method printCourseMenu.
	 * prints the course name, id, maximum amount of students, amount of registered students, list of registered students, instructor name, section number, and location for all the courses.
	 */
	public void printCourseMenu();
}
