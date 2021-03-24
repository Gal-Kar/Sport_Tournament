package View;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;


public class MainWindow {
	private Scene scene;
	private VBox ParticepentVB;
	private TextField ParticepentTextField;
	private Button addParticepent;
	private Button startChempionShip;
	private RadioButton Tennis, Basketball,Soccer;
	private List<TextField> Particepent;
	private int particepentCounter=0;
	private ToggleGroup tg;
	
	

	public MainWindow(Stage stage) {
		VBox mainVB=new VBox();
		HBox mainHB=new HBox();
		ParticepentVB=new VBox();

		Text titel=new Text("Championship");
		titel.setFont(Font.font("Verdana", FontWeight.BOLD,FontPosture.ITALIC, 40));
		titel.setFill(Color.GOLD);
		titel.setStroke(Color.BLUEVIOLET);
		mainVB.setAlignment(Pos.CENTER);



		VBox ButtonVB=new VBox();
		HBox ButtonHB=new HBox();
		HBox Name=new HBox();
		Text particepentName=new Text("Particepent name:");
		particepentName.setFont(Font.font("Verdana", FontWeight.BOLD,15));
		ParticepentTextField=new TextField();
		addParticepent=new Button("add particepent");
		startChempionShip=new Button("start chempionship");
		startChempionShip.setDisable(true);
		Name.getChildren().addAll(particepentName,ParticepentTextField);
		ButtonHB.getChildren().addAll(addParticepent,startChempionShip);
		ButtonVB.getChildren().addAll(Name,ButtonHB);
		Name.setMargin(particepentName, new Insets(0, 10, 0, 0));
		ButtonHB.setMargin(addParticepent, new Insets(0, 20, 0, 0));
		ButtonVB.setMargin(ButtonHB, new Insets(10, 0, 0, 0));
		Name.setAlignment(Pos.CENTER);
		ButtonVB.setAlignment(Pos.CENTER);
		ButtonHB.setAlignment(Pos.CENTER);

		VBox tgVB=new VBox();
		tg = new ToggleGroup();
		Tennis=new RadioButton("Tennis");
		Tennis.setToggleGroup(tg);
		Tennis.setSelected(true);
		Basketball=new RadioButton("Basketball");
		Basketball.setToggleGroup(tg);
		Soccer=new RadioButton("Soccer");
		Soccer.setToggleGroup(tg);
		tgVB.getChildren().addAll(Tennis,Basketball,Soccer);

		Particepent=new ArrayList<TextField>();
		for(int i=0;i<8;i++) {
			Particepent.add(new TextField());
			Particepent.get(i).setDisable(true);
			Particepent.get(i).setStyle("-fx-opacity: 1;");
			ParticepentVB.getChildren().add(Particepent.get(i));
			ParticepentVB.setMargin(Particepent.get(i), new Insets(0, 0, 10, 0));
		}
		ParticepentVB.setAlignment(Pos.TOP_LEFT);

		mainHB.getChildren().addAll(ParticepentVB,ButtonVB,tgVB);
		mainHB.setAlignment(Pos.CENTER);
		Text note=new Text("pressing add particepent without entering name will enter player X");
		note.setFill(Color.FIREBRICK);
		mainVB.getChildren().addAll(titel,mainHB,note);
		mainHB.setMargin(ButtonVB, new Insets(0, 150, 0, 150));
		mainVB.setMargin(titel, new Insets(10, 0, 20, 0));

		stage.setTitle("Add your teams");
		scene = new Scene(mainVB,1000,600);
		stage.setScene(scene);
		stage.show();
	}

	public void addParticepent(String name) {
		if(particepentCounter<8) {
		Particepent.get(particepentCounter).appendText(name);
		particepentCounter++;
		if(particepentCounter==8)
			startChempionShip.setDisable(false);
		}
	}

	public String textFieldInput() {
		return ParticepentTextField.getText();
	}

	public int getParticepentCounter() {
		return particepentCounter;
	}

	public void addEventToAddParticepent(EventHandler<ActionEvent> event) {
		addParticepent.setOnAction(event);
	}

	public void addEventToStartChempionship(EventHandler<ActionEvent> event) {
		startChempionShip.setOnAction(event);
	}

	public List<TextField> GetParticeList(){
		return Particepent;
	}

	public String getGame() {
		if(Tennis.isSelected())
			return "Tennis";
		if(Soccer.isSelected())
			return "Soccer";
		return "Basketball";
	}
	
	public void erorWindow(String t) {
		ErorWindow e=new ErorWindow(new Stage(), t);
	} 

}
