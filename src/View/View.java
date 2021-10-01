
package View;

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
    private JLabel outputToUser;
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

    /**
     *
     * @param menuSelected
     */
    public void setMenuSelected(int menuSelected) { this.menuSelected = menuSelected; }

    /**
     *
     * @return
     */
    public int getMenuSelected() { return this.menuSelected;}

    public void outputToUser(String output) {
        outputToUser = new JLabel(output);
        GUI.add(outputToUser);
        refreshGUI();
    }

    /**
     *
     * @param textField
     * @param labelField
     */
    private void updateGUI(JTextField textField, JLabel labelField) {
        GUI.add(labelField);
        GUI.add(textField);
        refreshGUI();
    }

    /**
     *
     */
    public void promptCourseName() {
        showSubmitButton();
        courseNameText = new JTextField(10);
        courseNameLabel = new JLabel("Enter Course Name eg. ENGG, PHYS, ENSF: ");
        updateGUI(courseNameText, courseNameLabel);
    }

    /**
     *
     */
    public void promptCourseNumber() {
        showSubmitButton();
        courseNumberText = new JTextField(10);
        courseNumberLabel = new JLabel("Enter Course Number eg. 233, 607, 259, 123: ");
        updateGUI(courseNumberText, courseNumberLabel);
    }

    /**
     *
     */
    public void promptCourseSection() {
        showSubmitButton();
        courseSectionText = new JTextField(10);
        courseSectionLabel = new JLabel("Enter Course Section from [1-2]: ");
        updateGUI(courseSectionText, courseSectionLabel);
    }

    /**
     *
     */
    public void promptStudentID() {
        showSubmitButton();
        studentIDText = new JTextField(10);
        studentIDLabel = new JLabel("Enter Student ID from [1-4]: ");
        updateGUI(studentIDText, studentIDLabel);
    }

    /**
     *
     */
    private void showSubmitButton() {
        if (!submitShown) {
            this.GUI.add(submitButton);
            submitShown = true;
        }
    }

    // ALL BELOW CALLED ON SUBMIT
    /**
     *
     * @return
     */
    public String getCourseName() { return courseNameText.getText().toUpperCase(); }
    public int getCourseNumber() { return Integer.parseInt(courseNumberText.getText()); }
    public int getCourseSection() { return Integer.parseInt(courseSectionText.getText()); }
    public int getStudentID() { return Integer.parseInt(studentIDText.getText()); }

    // ADD ACTION LISTENERS

    /**
     *
     * @param searchListener
     * @param addListener
     * @param removeListener
     * @param allCourseListener
     * @param studentCourseListener
     * @param quitListener
     * @param submitListener
     */
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

    private void refreshGUI() {
        SwingUtilities.updateComponentTreeUI(this);
    }
}
