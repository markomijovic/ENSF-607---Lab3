package courseRegistration;

import java.util.HashMap;
import java.util.Scanner;

//This is my "FrontEnd!"
public class CourseRegApp {

	private UserPrompt userPrompt = new UserPrompt();
	class UserPrompt {
		// Helper class for user prompts for specific entries
		protected String promptCourseName() {
			String userInput;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter course name and press enter: (ie: ENGG, ENSF, etc.)");
			userInput = input.next();
			return userInput.toUpperCase();
		}
		protected int promptCourseNum() {
			int userInput;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter course number and press enter: (ie: 233, 607, etc.)");
			userInput = input.nextInt();
			return userInput;
		}
		protected int promptCourseSection() {
			int userInput;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter course section (1 or 2) and press enter: ");
			userInput = input.nextInt();
			return userInput;
		}
		protected int promptStudentID() {
			int userInput;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter student ID [1 to 4] (4 students in the fake database)");
			userInput = input.nextInt();
			return userInput;
		}
	}

	// helper method to create fake course offering DB
	private void createFakeOfferingDB(CourseCat cat, String courseName, int courseNum) {
		Course myCourse = cat.searchCat(courseName, courseNum);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 100);
			cat.createOffering(myCourse, 2, 100);
		}
	}

	/**
	 * Main app menu
	 * @return user input selection
	 */
	private Integer menu() {
		Integer selection;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number from below choices and press enter:");
		System.out.println("------------------:");
		System.out.println("1 Search catalogue courses");
		System.out.println("2 Add course to student courses");
		System.out.println("3 Remove course from student courses");
		System.out.println("4 View All courses in catalogue");
		System.out.println("5 View all courses taken by student");
		System.out.println("6 Quit");

		selection = input.nextInt();
		return selection;
	}

	/**
	 * User option 1
	 */
	private void searchCatCourses (CourseCat cat) {
		Course c;

		String courseName = this.userPrompt.promptCourseName();
		int courseNum = this.userPrompt.promptCourseNum();

		c = cat.searchCat(courseName, courseNum);
		boolean courseFound = c != null;
		if (courseFound) {
			System.out.println("courseRegistration.Course " + courseName + " " + courseNum + " exists!");
		} else {
			System.err.println("courseRegistration.Course " + courseName + " " + courseNum + " does NOT exist!");
		}
		return;
	}

	/**
	 * User option 1 - Alternative boolean version that does not print and does not prompt user
	 */
	private Course searchCatCourses (CourseCat cat, String courseName, int courseNum) {
		Course c;
		c = cat.searchCat(courseName, courseNum);
		return c;
	}

	/**
	 * User option 2
	 */
	private void addCourseToStudent(CourseCat cat, HashMap students) {

		String courseName = this.userPrompt.promptCourseName();
		int courseNum = this.userPrompt.promptCourseNum();
		int courseSection = this.userPrompt.promptCourseSection();
		// check course exists
		if (searchCatCourses(cat, courseName, courseNum) == null) {
			System.err.println("Cannot add courseRegistration.Student. courseRegistration.Course " + courseName + " " + courseNum + " does NOT exist!");
			return;
		}
		// prompt student ID
		Integer studentID = userPrompt.promptStudentID();
		Student student = (Student) students.get(studentID);

		// register for course
		System.out.println(student.getStudentName());
		student.registerForCourse(cat, courseName, courseNum, courseSection);
		System.out.println("courseRegistration.Student: " + student.getStudentName() + " was successfully registered for " + courseName + courseNum + " section: " + courseSection);
	}

	/**
	 * User option 3
		remove student registration from offering:studentList and student:regList
	 	and set the registration object to null
	 */
	private void removeStudentFromCourse(CourseCat cat, HashMap students) {
		String courseName = this.userPrompt.promptCourseName();
		int courseNum = this.userPrompt.promptCourseNum();
		Course c = searchCatCourses(cat, courseName, courseNum);
		// check course exists
		if (c == null) {
			System.err.println("Cannot remove courseRegistration.Student. courseRegistration.Course " + courseName + " " + courseNum + " does NOT exist!");
			return;
		}
		// prompt student ID
		Integer studentID = userPrompt.promptStudentID();
		Student student = (Student) students.get(studentID);
		student.removeCourseFromStudentCourses(c);
	}

	/**
	 * User option 4
	 */
	private void viewCoursesInCatalogue(CourseCat cat) {
		System.out.println(cat.toString());
	}

	/**
	 * User option 5
	 */
	private void viewStudentCourses(HashMap students) {
		// prompt student ID
		Integer studentID = userPrompt.promptStudentID();
		Student student = (Student) students.get(studentID);
		System.out.println(student.showAllCoursesTaken());
	}

	public static void main (String [] args) {

		CourseRegApp myApp = new CourseRegApp();

		// Create fake database //
		CourseCat cat = new CourseCat ();  //This loads the courses from our "DB"
		HashMap<Integer, Student> students = new HashMap<>(); // students database. courseRegistration.Student ID acts as key
		Student st1 = new Student ("Jimmy Conway", 1);
		Student st2 = new Student ("Henry Hill", 2);
		Student st3 = new Student ("Tommy DeVito", 3);
		Student st4 = new Student ("Karen Hill", 4);
		students.put(st1.getStudentId(), st1);
		students.put(st2.getStudentId(), st2);
		students.put(st3.getStudentId(), st3);
		students.put(st4.getStudentId(), st4);

		myApp.createFakeOfferingDB(cat, "ENGG", 233);
		myApp.createFakeOfferingDB(cat, "ENSF", 607);
		myApp.createFakeOfferingDB(cat, "PHYS", 259);
		myApp.createFakeOfferingDB(cat, "ENSF", 123);

		st1.registerForCourse(cat, "ENGG", 233, 1);
		st2.registerForCourse(cat, "ENGG", 233, 1);
		st3.registerForCourse(cat, "ENGG", 233, 2);
		st4.registerForCourse(cat, "ENGG", 233, 2);
		// --- END OF FAKE DATA --- //

		// Assignment front end
		while (true) {
			Integer selection = myApp.menu();
			switch (selection) {
				case 1:
					myApp.searchCatCourses(cat);
					break;
				case 2:
					myApp.addCourseToStudent(cat, students);
					break;
				case 3:
					myApp.removeStudentFromCourse(cat, students);
					break;
				case 4:
					myApp.viewCoursesInCatalogue(cat);
					break;
				case 5:
					myApp.viewStudentCourses(students);
					break;
				case 6:
					break;
			}
			if (selection.equals(6)) { break; }
		}
		
	}

}
