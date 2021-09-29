package courseRegistration;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    View theView;
    Model theModel;

    public Controller (View theView, Model theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.addActionListener(new SearchCatCourseListener(), new AddCourseListener(), new RemoveCourseListener(),
                new ViewAllCoursesListener(), new ViewAllStudentCoursesListener(), new QuitListener(), new SubmitListener());
    }

    class SearchCatCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            theView.setMenuSelected(1);
            theView.promptCourseName();
            theView.promptCourseNumber();
        }
    }

    class AddCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMenuSelected(2);
            theView.promptCourseName();
            theView.promptCourseNumber();
            theView.promptCourseSection();
            theView.promptStudentID();
        }
    }

    class RemoveCourseListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(3);
             theView.promptCourseName();
             theView.promptCourseNumber();
             theView.promptStudentID();
         }
    }

    class ViewAllCoursesListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(4);
         }
    }

    class ViewAllStudentCoursesListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(5);
             theView.promptStudentID();

         }
    }

    class QuitListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
             theView.setMenuSelected(6);
         }
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selection = theView.getMenuSelected();
            switch (selection) {
                case 1:
                    theModel.cat.searchCat(theView.getCourseName(), theView.getCourseNumber());
            }
        }
    }
}
