package App;
import Controller.Controller;
import Model.DBInterface;
import View.View;

public class CourseApp {
    public static void main (String [] args) {

        View theView = new View ();
        DBInterface theModel = new DBInterface();
        Controller theController = new Controller (theView, theModel);
        theView.setVisible(true);
    }
}
