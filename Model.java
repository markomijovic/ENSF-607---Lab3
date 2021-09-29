package courseRegistration;

import java.util.HashMap;

public class Model {

    public CourseCat cat;
    HashMap<Integer, Student> students;

    private void createFakeOfferingDB(CourseCat cat, String courseName, int courseNum) {
        Course myCourse = cat.searchCat(courseName, courseNum);
        if (myCourse != null) {
            cat.createOffering(myCourse, 1, 100);
            cat.createOffering(myCourse, 2, 100);
        }
    }

//    /**
//     * User option 1 - Alternative boolean version that does not print and does not prompt user
//     */
//    public Course searchCatCourses (CourseCat cat, String courseName, int courseNum) {
//        Course c;
//        c = cat.searchCat(courseName, courseNum);
//        return c;
//    }
//
//    /**
//     * User option 2
//     */
//    public void addCourseToStudent(CourseCat cat, HashMap students) {
//
//        String courseName = this.userPrompt.promptCourseName();
//        int courseNum = this.userPrompt.promptCourseNum();
//        int courseSection = this.userPrompt.promptCourseSection();
//        // check course exists
//        if (searchCatCourses(cat, courseName, courseNum) == null) {
//            System.err.println("Cannot add courseRegistration.Student. courseRegistration.Course " + courseName + " " + courseNum + " does NOT exist!");
//            return;
//        }
//        // prompt student ID
//        Integer studentID = userPrompt.promptStudentID();
//        Student student = (Student) students.get(studentID);
//
//        // register for course
//        System.out.println(student.getStudentName());
//        student.registerForCourse(cat, courseName, courseNum, courseSection);
//        System.out.println("courseRegistration.Student: " + student.getStudentName() + " was successfully registered for " + courseName + courseNum + " section: " + courseSection);
//    }
//
//    /**
//     * User option 3
//     remove student registration from offering:studentList and student:regList
//     and set the registration object to null
//     */
//    public void removeStudentFromCourse(CourseCat cat, HashMap students) {
//        String courseName = this.userPrompt.promptCourseName();
//        int courseNum = this.userPrompt.promptCourseNum();
//        Course c = searchCatCourses(cat, courseName, courseNum);
//        // check course exists
//        if (c == null) {
//            System.err.println("Cannot remove courseRegistration.Student. courseRegistration.Course " + courseName + " " + courseNum + " does NOT exist!");
//            return;
//        }
//        // prompt student ID
//        Integer studentID = userPrompt.promptStudentID();
//        Student student = (Student) students.get(studentID);
//        student.removeCourseFromStudentCourses(c);
//    }
//
//    /**
//     * User option 4
//     */
//    public void viewCoursesInCatalogue(CourseCat cat) {
//        System.out.println(cat.toString());
//    }
//
//    /**
//     * User option 5
//     */
//    public void viewStudentCourses(HashMap students) {
//        // prompt student ID
//        Integer studentID = userPrompt.promptStudentID();
//        Student student = (Student) students.get(studentID);
//        System.out.println(student.showAllCoursesTaken());
//    }

    public Model() {
        this.cat = new CourseCat ();  //This loads the courses from our "DB"
        this.students = new HashMap<>(); // students database. courseRegistration.Student ID acts as key
        Student st1 = new Student ("Jimmy Conway", 1);
        Student st2 = new Student ("Henry Hill", 2);
        Student st3 = new Student ("Tommy DeVito", 3);
        Student st4 = new Student ("Karen Hill", 4);
        this.students.put(st1.getStudentId(), st1);
        this.students.put(st2.getStudentId(), st2);
        this.students.put(st3.getStudentId(), st3);
        this.students.put(st4.getStudentId(), st4);

        createFakeOfferingDB(cat, "ENGG", 233);
        createFakeOfferingDB(cat, "ENSF", 607);
        createFakeOfferingDB(cat, "PHYS", 259);
        createFakeOfferingDB(cat, "ENSF", 123);

        st1.registerForCourse(cat, "ENGG", 233, 1);
        st2.registerForCourse(cat, "ENGG", 233, 1);
        st3.registerForCourse(cat, "ENGG", 233, 2);
        st4.registerForCourse(cat, "ENGG", 233, 2);
    }

}
