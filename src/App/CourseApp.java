package App;
import Controller.Controller;
import Model.Model;
import View.View;

public class CourseApp {
    public static void main (String [] args) {

        View theView = new View ();
        Model theModel = new Model ();
        Controller theController = new Controller (theView, theModel);
        theView.setVisible(true);
    }
}
