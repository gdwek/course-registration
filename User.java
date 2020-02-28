import java.util.ArrayList;
import java.io.Serializable;
/*Creates a user object.
 *String username, password, first, and last represent the user's username, password, first name and last name respectively.
 *CourseMenu is an arraylist that holds all of the courses.
 */
public abstract class User implements Serializable{
	protected String username;
	protected String password;
	protected String first;
	protected String last;
	public static ArrayList <Course> CourseMenu = new ArrayList <Course> ();
	
	/*Default constructor
	 * Constructs a user object.
	 */
	User(){
		
	}
	/*
	 * Constructor for user object 
	 * @param first the user's first name
	 * @param last the user's last name
	 * @param username the user's username
	 * @param password the user's password
	 */
	User(String first, String last, String username, String password){
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
	}
	
	/*
	 * @return the user's first name
	 */
	public String getName() {
		return first;
	}
	/*
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}
	/*
	 * Allows the user to change their username.
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
		System.out.println("Your username has been succesfully changed to " + getUsername());
	}
	/*
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * Allows the user to change their password
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
		System.out.println("Your password has been succesfully changed to " + getPassword());
	}
	/*
	 * a method that prints the course menu, overrriden by both the student and admin 
	 */
	public void printCourseMenu() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			System.out.println(CourseMenu.get(i).toString());
		}
	}
	
	
}
