import java.util.ArrayList;
import java.io.Serializable;
public class StudentClass extends User implements Student {
	private int id;
	public ArrayList <Course> myCourses  = new ArrayList <Course> ();
	/*
	 * Constructs a student object.
	 * @param first  the student's first name
	 * @param last   the student's last name
	 * @param username   the student's username
	 * @param password   the student's password
	 * @param id  the student's id number
	 */
	StudentClass(String first, String last, String username, String password, int id){
		super(first, last, username, password);
		this.id  = id;
	}
	/*
	 * Constructs a student object.
	 * @param first the student's first name
	 * @param last the student's last name
	 */
	StudentClass(String first, String last){
		this.first=  first;
		this.last =  last;
	}
	/*
	 * (non-Javadoc)
	 * @see Student#printOpenCourses()
	 */
	@Override
	public void printOpenCourses() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getRegistered() < CourseMenu.get(i).getMax()) 
				System.out.println(CourseMenu.get(i).studentToString());
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Student#register(java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void register(String courseName, int section, String first, String last) {
		StudentClass correctStudent= null;
		Course correctCourse;
		for(int i  = 0; i<AdminClass.allStudents.size(); i++) {
			if(AdminClass.allStudents.get(i).first.equalsIgnoreCase(first) && AdminClass.allStudents.get(i).last.equalsIgnoreCase(last)) {
				correctStudent = (StudentClass) AdminClass.allStudents.get(i);
			}
		}
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && CourseMenu.get(i).getSection() == section) {
				correctCourse = CourseMenu.get(i);
				if(correctCourse.getMax()== correctCourse.getRegistered()) {
					System.out.println("Sorry, that course is full.");
					return;
				}
				for(int k = 0; k<correctStudent.myCourses.size(); k++) {
					if(correctCourse.equals(myCourses.get(k))) {
						System.out.println("You are already registered in this course.");
						return;
					}
				}
				myCourses.add(CourseMenu.get(i));
				CourseMenu.get(i).getRegisteredStudents().add((correctStudent));
				CourseMenu.get(i).increaseRegistered();
				System.out.println("You have been successfully registered in the course");
				return;
			}
		}
		System.out.println("That course was not found.");
	}
	/* 
	 * (non-Javadoc)
	 * @see Student#withdraw(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void withdraw(String first, String last, String courseName) {
		StudentClass student;
		Course correctCourse;
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName)) {
				correctCourse = CourseMenu.get(i);
				
			for(int j= 0; j< correctCourse.getRegisteredStudents().size(); j++) {
					if(correctCourse.getRegisteredStudents().get(j).getFullName().equalsIgnoreCase(first + " " + last)){
						student = correctCourse.getRegisteredStudents().get(j);
						student.myCourses.remove(correctCourse);
						correctCourse.getRegisteredStudents().remove(student);
						correctCourse.decreaseRegistered();
						System.out.println("You have been successfully removed from the course.");
						return;
					}
				}
				System.out.println("You are not registered in that course.");
				return;
			}
		}
		System.out.println("That course was not found.");
		
	}
	/*
	 * (non-Javadoc)
	 * @see Student#printMyCourses()
	 */
	@Override
	public void printMyCourses() {
		for(int i =  0; i<myCourses.size(); i++) {
			System.out.println(myCourses.get(i).studentToString());
		}
	}
	@Override
	/* (non-Javadoc)
	 * @see User#printCourseMenu()
	 */
	public void printCourseMenu() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			System.out.println(CourseMenu.get(i).studentToString());
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Student#getFullName()
	 */
	@Override
	public String getFullName() {
		return first + " " + last;
	}
	/* 
	 * (non-Javadoc)
	 * @see Student#getID()
	 */
	public int getID() {
		return id;
	}
}
