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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

public class TennisGame {
	private Scene scene;
	private Stage stage;
	private List<TextField> p1Score;
	private List<TextField> p2Score;
	private Button submit;
	private HBox p1HB;
	private HBox p2HB;

	public TennisGame(Stage stage,String p1N,String p2N) {
		this.stage=stage;
		Text titel=new Text("Tennis");
		titel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		titel.setFill(Color.DARKBLUE);
		titel.setStroke(Color.BLUEVIOLET);

		Text p1Name=new Text(p1N);
		p1Score=new ArrayList<TextField>();

		Text p2Name=new Text(p2N);
		p2Score=new ArrayList<TextField>();

		

		for(int i=0;i<3;i++) {
			p1Score.add(new TextField(""));
			p1Score.get(i).setPrefWidth(50);
			p2Score.add(new TextField(""));
			p2Score.get(i).setPrefWidth(50);
		}

	    p1HB=new HBox();
		p1HB.getChildren().add(p1Name);
		setHBox(p1HB,p1Score);
		p2HB=new HBox();
		p2HB.getChildren().add(p2Name);
		setHBox(p2HB,p2Score);

		p1HB.setAlignment(Pos.CENTER);
		p2HB.setAlignment(Pos.CENTER);

		submit=new Button("Continue");

		VBox mainVB=new VBox();
		mainVB.getChildren().addAll(titel,p1HB,p2HB,submit);
		mainVB.setMargin(p1HB, new Insets(25,0, 0, 0));
		mainVB.setMargin(p2HB, new Insets(20,0, 35, 0));
		mainVB.setAlignment(Pos.CENTER);
		stage.initModality(Modality.APPLICATION_MODAL);
		scene=new Scene(mainVB,600,400);
		stage.setScene(scene);
		stage.show();
	}

	public void openNextTextBox() {
		if(p1Score.size()==5)
			return;
		for(int i=0;i<p1Score.size();i++) {
			p1Score.get(i).setDisable(true);
			p2Score.get(i).setDisable(true);
		}
		p1Score.add(new TextField(""));
		p1Score.get(p1Score.size()-1).setPrefWidth(50);
		setHBox(p1HB, p1Score);
		p2Score.add(new TextField(""));
		p2Score.get(p2Score.size()-1).setPrefWidth(50);
		setHBox(p2HB, p2Score);
	}

	public void setHBox(HBox hb, List<TextField> pScore) {
		Text name=(Text) hb.getChildren().get(0);
		hb.getChildren().clear();
		hb.getChildren().add(name);
		for(int i=0;i<pScore.size();i++) {
			hb.getChildren().add(pScore.get(i));
			hb.setMargin(pScore.get(i), new Insets(0, 20, 0, 10));

		}
	}
	
	public List<TextField> getP1Score(){
		return p1Score;
	}
	
	public List<TextField> getP2Score(){
		return p2Score;
	}
	
	public void closeStage() {
		stage.close();
	}

	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}

}



