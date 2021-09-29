
package courseRegistration;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class View extends JFrame {

    private JPanel GUI;
    private JButton searchCatCourseButton = new JButton ("Search catalogue courses");
    private JButton addCourseButton = new JButton ("Add course to student courses");
    private JButton removeCourseButton = new JButton ("Remove course from student courses");
    private JButton viewAllCoursesButton = new JButton ("View All courses in catalogue");
    private JButton viewAllStudentCoursesButton = new JButton ("View all courses taken by student");
    private JButton quitButton = new JButton ("Quit");
    private JButton submitButton = new JButton("Submit");
    private JTextField courseNameText;
    private JTextField courseNumberText;
    private JTextField courseSectionText;
    private JTextField studentIDText;
    private JLabel courseNameLabel;
    private JLabel courseNumberLabel;
    private JLabel courseSectionLabel;
    private JLabel studentIDLabel;
    private int menuSelected;
    private boolean submitShown = false;

    public View() {
        GUI = new JPanel();
        // setLayout(new GridLayout(1,2));
        setSize(800,600); //sets size of entire GUI
        GUI.add(searchCatCourseButton);
        GUI.add(addCourseButton);
        GUI.add(removeCourseButton);
        GUI.add(viewAllCoursesButton);
        GUI.add(viewAllStudentCoursesButton);
        GUI.add(quitButton);
        add(GUI);
    }

    public void setMenuSelected(int menuSelected) { this.menuSelected = menuSelected; }
    public int getMenuSelected() { return this.menuSelected;}
    private void updateGUI(JTextField textField, JLabel labelField) {
        GUI.add(labelField);
        GUI.add(textField);
        SwingUtilities.updateComponentTreeUI(this);
    }

    // CALLED ON BUTTON MENU CLICK
    public void promptCourseName() {
        showSubmitButton();
        courseNameText = new JTextField(10);
        courseNameLabel = new JLabel("Enter Course Name eg. ENGG, PHYS, ENSF: ");
        updateGUI(courseNameText, courseNameLabel);
    }
    public void promptCourseNumber() {
        showSubmitButton();
        courseNumberText = new JTextField(10);
        courseNumberLabel = new JLabel("Enter Course Number eg. 233, 607, 259, 123: ");
        updateGUI(courseNumberText, courseNumberLabel);
    }
    public void promptCourseSection() {
        showSubmitButton();
        courseSectionText = new JTextField(10);
        courseSectionLabel = new JLabel("Enter Course Section from [1-2]: ");
        updateGUI(courseSectionText, courseSectionLabel);
    }
    public void promptStudentID() {
        showSubmitButton();
        studentIDText = new JTextField(10);
        courseNameLabel = new JLabel("Enter Student ID from [1-4]: ");
        updateGUI(studentIDText, courseNameLabel);
    }

    private void showSubmitButton() {
        if (!submitShown) {
            this.GUI.add(submitButton);
            submitShown = true;
        }
    }

    // ALL BELOW CALLED ON SUBMIT
    // Integer.parseInt(firstNumber.getText()
    public String getCourseName() { return courseNameText.getText(); }
    public int getCourseNumber() { return Integer.parseInt(courseNumberText.getText()); }
    public int getCourseSection() { return Integer.parseInt(courseSectionText.getText()); }
    public int getStudentID() { return Integer.parseInt(studentIDText.getText()); }

    // ADD ACTION LISTENERS
    public void addActionListener (ActionListener searchListener, ActionListener addListener,
                                   ActionListener removeListener, ActionListener allCourseListener,
                                   ActionListener studentCourseListener, ActionListener quitListener, ActionListener submitListener) {
        searchCatCourseButton.addActionListener(searchListener);
        addCourseButton.addActionListener(addListener);
        removeCourseButton.addActionListener(removeListener);
        viewAllCoursesButton.addActionListener(allCourseListener);
        viewAllStudentCoursesButton.addActionListener(studentCourseListener);
        quitButton.addActionListener(quitListener);
        submitButton.addActionListener(submitListener);
    }

//    private CourseRegApp.UserPrompt userPrompt = new CourseRegApp.UserPrompt();
//    class UserPrompt {
//        // Helper class for user prompts for specific entries
//        protected String promptCourseName() {
//            String userInput;
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter course name and press enter: (ie: ENGG, ENSF, etc.)");
//            userInput = input.next();
//            return userInput.toUpperCase();
//        }
//        protected int promptCourseNum() {
//            int userInput;
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter course number and press enter: (ie: 233, 607, etc.)");
//            userInput = input.nextInt();
//            return userInput;
//        }
//        protected int promptCourseSection() {
//            int userInput;
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter course section (1 or 2) and press enter: ");
//            userInput = input.nextInt();
//            return userInput;
//        }
//        protected int promptStudentID() {
//            int userInput;
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter student ID [1 to 4] (4 students in the fake database)");
//            userInput = input.nextInt();
//            return userInput;
//        }
//    }
}
