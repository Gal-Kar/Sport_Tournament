package Program;
import Controller.Controller;
import Model.Model;
import View.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

	public class Program extends Application {
		
	    public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) {
	    	Model theModel=new Model();
	    	MainWindow theView=new MainWindow(primaryStage);
	    	Controller theController=new Controller(theModel,theView);
	    }
	}
	


