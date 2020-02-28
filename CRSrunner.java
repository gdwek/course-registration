import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;
/*
 * Displays the options to the user, allows them to pick from multiple menus
 */
public class CRSrunner {
	public static User admin = new AdminClass ("Gabrielle", "Dwek", "Admin", "Admin001");
	/*
	 * Checks to see if this is the first time the program is being run, if so it reads from the csv, if not, reads from the serialized file
	 * Asks the user if they are a student or an admin, allows them to log in appropriately and proceed to their respective menus
	 * Serializes the data after the user logs out.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try {
			FileInputStream file = new FileInputStream("SerializeOut");	
			ObjectInputStream deserialize = new ObjectInputStream(file);
			User.CourseMenu = (ArrayList <Course> ) deserialize.readObject();
			AdminClass.allStudents = (ArrayList <User> ) deserialize.readObject();
			System.out.println("Successfully deserialized.");
		}
		catch (IOException | ClassNotFoundException e){
		System.out.println("Could Not Deserialize, reading from csv");
		File file = new File ("MyUniversityCourses.csv");
		Scanner scan = new Scanner (file);
		String [] list;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			list = line.split(",");
			User.CourseMenu.add(new Course(list[0], list[1], Integer.parseInt(list[2]), Integer.parseInt(list[3]),  new ArrayList <StudentClass> () , list[5], Integer.parseInt(list[6]), list[7]));
			
		}
		}
		Scanner scan2 = new Scanner(System.in);
		boolean run =  true; 
		System.out.print("Welcome to Course Registration. Enter 1 if you are an admin and 2 if you are a student.");
		while(true) {
			try { 
				int num  =  scan2.nextInt();
				if(num == 1 ) {
					boolean run2 =  true; 
					while(run2) {
						System.out.println("Enter your username below.");
						if(scan2.next().equalsIgnoreCase("Admin")) {
							boolean run3 =  true; 
							while(run3) {
								System.out.println("Enter your password below.");
								if(scan2.next().equalsIgnoreCase("Admin001")) {
									System.out.println("Hello " + admin.getName());
									printAdminMainMenu();
									System.out.print("You have been logged out.");
									ArrayList <Course> copy = User.CourseMenu;
									ArrayList <User> copy2= AdminClass.allStudents;
									
									try {
										FileOutputStream data = new FileOutputStream ("SerializeOut");
										ObjectOutputStream out = new ObjectOutputStream(data);
										out.writeObject(copy);
										out.writeObject(copy2);
										out.close();
										data.close();
										System.out.println("The data has been serialized.");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									return;
								}
								else {
									System.out.println("Incorrect password.");
								}
								}
						}
						else {
							System.out.println("Incorrect username.");
							
						}
					}
				}
				else if(num == 2 ) {
					boolean test = true;
					while(test) {
						scan2.nextLine();
						System.out.println("Enter your username below.");
						String username = scan2.next();
						System.out.println("Enter your password below");
						String password = scan2.next();
						StudentClass correctStudent= null;
						for(User student: AdminClass.allStudents) {
							if(student.getUsername().equalsIgnoreCase(username) && student.getPassword().equalsIgnoreCase(password)) {
								correctStudent = (StudentClass) student;
								System.out.println("Hello " + correctStudent.getName());
								printStudentMenu(correctStudent);
								System.out.print("You have been logged out.");
								ArrayList <Course> copy = User.CourseMenu;
								ArrayList <User> copy2= AdminClass.allStudents;
								
								try {
									FileOutputStream data = new FileOutputStream ("SerializeOut");
									ObjectOutputStream out = new ObjectOutputStream(data);
									out.writeObject(copy);
									out.writeObject(copy2);
									out.close();
									data.close();
									System.out.println("The data has been serialized.");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								return;
							}
						}
						System.out.println("Student not found. Please try again");
					}
				}
				else {
					throw new InputMismatchException();
				}
			}
				catch (InputMismatchException e ) {
					System.out.println("Invalid input. Please enter 1 or 2.");
					scan2.nextLine();
				}
			}
		}
	/*
	 * Allows the admin to pick from a course management menu, reports menu, or logging out.
	 */
	public static void printAdminMainMenu() {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("Enter 1 to see the Course Management menu, 2 to see the Reports menu, or 3 to log out.");
			try {
				int num= scan.nextInt();
				if(num ==1) {
					printAdminCourseManagementMenu();
				}	
				else if(num== 2 ) {
					printAdminReportsMenu();
				}
				else if(num== 3) {
					return;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				scan.nextLine();
				}
		}
	}
	/*
	 * Allows the admin to pick from adding a new course, deleting a course, editing a course, viewing a courses information, registering a student, or returning to the main menu.
	 */
	public static void printAdminCourseManagementMenu() {
			Scanner scan= new Scanner(System.in);
			boolean run=  true;
			while(run) {
				try{
					System.out.println("*******Course Management*******");
					System.out.println("ADD NEW COURSE: Enter 1");
					System.out.println("DELETE A COURSE: Enter 2");
					System.out.println("EDIT A COURSE: Enter 3");
					System.out.println("VIEW COURSE INFO: Enter 4");
					System.out.println("REGISTER A STUDENT: Enter 5");
					System.out.println("RETURN TO MAIN MENU: Enter 6");
					int num= scan.nextInt();
					scan.nextLine();
					if(num== 1 ){
						String name, id, instructor, location;
						int max = 0; 
						int section= 0;
						ArrayList<StudentClass> registeredStudents= new ArrayList <StudentClass>();
						System.out.println("Enter the course name.");
						name = scan.nextLine();
						System.out.println("Enter the course id.");
						id = scan.nextLine();
						System.out.println("Enter the maximum amount of students allowed in the course.");
						boolean test = true;
						do { try {
							max = scan.nextInt();
							scan.nextLine();
							test = false;
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid input. Please enter a number.");
							test = true;
							scan.nextLine();
						}
						} while(test);
						System.out.println("Enter the instructor's full name.");
						instructor = scan.nextLine();
						System.out.println("Enter the section number.");
						boolean test2 = true;
						do{
							try {
							section = scan.nextInt();
							scan.nextLine();
							test2 = false;
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid input. Please enter a number.");
							test2 = true;
							scan.nextLine();
						}
						}
						while(test2);
						System.out.println("Enter the location of the course.");
						location= scan.nextLine();
						((AdminClass) admin).createNewCourse(name, id, max, 0, registeredStudents, instructor, section, location);
						}
					else if(num==2) {
						String name, id;
						System.out.println("Enter the name of the course you would like to delete.");
						name = scan.nextLine();
						System.out.println("Enter the ID of the course you would like to delete.");
						id = scan.nextLine();
						((AdminClass) admin).deleteCourse(name, id);
					}
					else if(num==3) {
						String name;
						int section = 0;
						System.out.println("Enter the name the course you would like to edit."); 
						name = scan.nextLine();
						System.out.println("Enter the section number of the course you would like to edit.");
						boolean test = true;
						do { try {
							section = scan.nextInt();
							scan.nextLine();
							test = false;
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid input. Please enter a number.");
							test = true;
							scan.nextLine();
						}
						} while(test);
						((AdminClass) admin).editCourse(name,section);
					}
					else if(num==4) {
						String id;
						System.out.println("Enter the ID of the course you would like to view.");
						id = scan.nextLine();
						((AdminClass) admin).printCourseInfo(id);
					}
					else if(num==5) {
						System.out.println("Enter the first name of the student you would like to register.");
						String first  = scan.nextLine();
						System.out.println("Enter the last name of the student you would like to register.");
						String last = scan.nextLine();
						System.out.println("Enter a username for the student.");
						String username = scan.nextLine();
						System.out.println("Enter a password for the student.");
						String password = scan.nextLine();
						System.out.println("Enter an ID number for the student.");
						int id = scan.nextInt();
						((AdminClass) admin).addStudent(first, last, username, password, id);
					}	
					else if(num==6){
						return;
					}
					else {
						try {
						throw new InputMismatchException();
						}
						catch(InputMismatchException e) {
							System.out.println("Invalid input. Please press 1,2,3,4,5 or 6.");
						}
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input. Please press 1,2,3,4,5 or 6.");
					scan.nextLine();
				}
			}
		}
		/*
		 * Allows the admin to pick from viewing all the courses, viewing full courses, writing full courses to a file, viewing the students in a specific course, viewing what courses a student is registered in, sorting courses based on amount of registered students, and returning to the main menu.
		 */
		public static void printAdminReportsMenu() {
			Scanner scan = new Scanner(System.in);
			boolean run =  true;
			while(run) {
					try {
						System.out.println("*******Reports*******");
						System.out.println("VIEW ALL COURSES: Enter 1");
						System.out.println("VIEW FULL COURSES: Enter 2");
						System.out.println("WRITE FULL COURSES TO A FILE: Enter 3");
						System.out.println("VIEW STUDENTS IN A COURSE: Enter 4");
						System.out.println("VIEW A STUDENT'S REGISTERED COURSES: Enter 5");
						System.out.println("SORT COURSES (BASED ON AMOUNT OF REGISTERED STUDENTS): Enter 6");
						System.out.println("RETURN TO MAIN MENU: Enter 7");
						int num =  scan.nextInt();
						scan.nextLine();
						if(num== 1) {
							admin.printCourseMenu();
						}
						else if(num== 2) {
							((AdminClass) admin).printFullCourses();
						}
						else if(num== 3) {
							((AdminClass)admin).writeFullCoursestoFile();
						}
						else if(num== 4) {
							System.out.println("Enter the name of the course.");
							String name= scan.nextLine();
							System.out.println("Enter the ID of the course.");
							String id = scan.nextLine();
							((AdminClass) admin).studentsInCourse(name, id);
						}
						else if(num== 5) {
							System.out.println("Enter the first name of the student.");
							String first = scan.nextLine();
							System.out.println("Enter the last name of the student.");
							String last  = scan.nextLine();
							((AdminClass) admin).studentsCourses(first, last);
						}
						else if(num== 6) {
							((AdminClass) admin).sortCourses();
						}
						else if(num== 7 ){
							return;
						}
						else {
							try {
							throw new InputMismatchException();
							}
							catch(InputMismatchException e){
								System.out.println("Invalid input. Please press 1,2,3,4,5 6, or 7.");
							}
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Invalid input. Please enter 1, 2, 3, 4 ,5 ,6 , or 7");
						scan.nextLine();
						}
			}
		}
		/*
		 * Allows the student to pick from viewing all the courses, viewing available courses, registering in a course, withdrawing from a course, viewing the courses they are registered in, changing their username or password, and logging out.
		 */
		public static void printStudentMenu(User student) {
			boolean run =  true;
			Scanner scan = new Scanner(System.in);
			while(run) {
					try {
						System.out.println("*******Course Management*******");
						System.out.println("VIEW ALL COURSES: Enter 1");
						System.out.println("VIEW ALL COURSES THAT ARE NOT FULL: Enter 2");
						System.out.println("REGISTER IN A COURSE: Enter 3");
						System.out.println("WITHDRAW FROM A COURSE: Enter 4");
						System.out.println("VIEW MY COURSES: Enter 5");
						System.out.println("CHANGE USERNAME: Enter 6");
						System.out.println("CHANGE PASSWORD: Enter 7");
						System.out.println("LOGOUT: Enter 8");
						int num= scan.nextInt();
						scan.nextLine();
						if(num== 1) {
							student.printCourseMenu();
						}
						else if(num==2) {
							((StudentClass) student).printOpenCourses();
						}
						else if(num==3) {
							String courseName;
							int section = 0;
								System.out.println("Enter name of the course you would like to register in.");
								courseName= scan.nextLine();
								System.out.println("Enter the section number of the course you would like to register in.");
								boolean test = true;
								do{
									try {
									section = scan.nextInt();
									test = false;
								}
								catch (InputMismatchException e) {
									System.out.println("Invalid input. Please enter a number.");
									test = true;
									scan.nextLine();
								}
								}
								while(test);
								((StudentClass)student).register(courseName, section, student.first, student.last);
								scan.nextLine();
						}
						else if(num== 4) {
							String courseName;
							System.out.println("Enter the name of the course you would like to withdraw from.");
							courseName= scan.nextLine();
							((StudentClass)student).withdraw(student.first, student.last, courseName);
						}
						else if(num== 5) {
							((StudentClass) student).printMyCourses();
						}
						else if(num== 6) {
							System.out.println("Enter your new username below.");
							student.setUsername(scan.next());
						}
						else if(num== 7) {
							System.out.println("Enter your new password below.");
							student.setPassword(scan.next());
						}
						else if(num == 8){
							return;
						}
						else {
							try {
							throw new InputMismatchException();
							}
							catch(InputMismatchException e) {
								System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, 6, 7, or 8.");
							}
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, 6, 7, or 8");
						scan.nextLine();
					}
				}
		}
	}

