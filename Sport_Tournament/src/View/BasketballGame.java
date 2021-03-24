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

public class BasketballGame {
	private Scene scene;
	private Stage stage;
	private List<TextField> p1Score;
	private List<TextField> p2Score;
	private Button submit;
	private RadioButton penalty1,penalty2;
	private boolean penalty=false;
	private HBox p1HB;
	private HBox p2HB;
	
	
	public BasketballGame(Stage stage,String p1N,String p2N) {
		this.stage=stage;
		Text titel=new Text("Basketball");
		titel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		titel.setFill(Color.DARKBLUE);
		titel.setStroke(Color.BLUEVIOLET);
		
		Text p1Name=new Text(p1N);
		p1Score=new ArrayList<TextField>();
		
		Text p2Name=new Text(p2N);
		p2Score=new ArrayList<TextField>();
		
		for(int i=0;i<4;i++) {
			p1Score.add(new TextField());
			p1Score.get(i).setPrefWidth(70);
			p2Score.add(new TextField());
			p2Score.get(i).setPrefWidth(70);
		}
		penalty1=new RadioButton();
		penalty2=new RadioButton();
		ToggleGroup tg=new ToggleGroup();
		penalty1.setToggleGroup(tg);
		penalty2.setToggleGroup(tg);
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
		mainVB.setMargin(p1HB, new Insets(20,0, 0, 0));
		mainVB.setMargin(p2HB, new Insets(20,0, 35, 0));
		mainVB.setAlignment(Pos.CENTER);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		scene=new Scene(mainVB,600,400);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setHBox(HBox hb, List<TextField> pScore) {
		for(int i=0;i<pScore.size();i++) {
			hb.getChildren().add(pScore.get(i));
			hb.setMargin(pScore.get(i), new Insets(0, 50, 0, 10));

		}
	}
	
	public boolean isPenaltyTime() {
		return penalty;
	}
	
	public void penaltyTime() {
		penalty=true;
		for(int i=0;i<p1Score.size();i++) {
			p1Score.get(i).setDisable(true);
			p2Score.get(i).setDisable(true);
		}
		Text penalty1T=new Text("|Penalties| ");
		p1HB.getChildren().add(5,penalty1T );
		Text penalty2T=new Text("|Penalties| ");
		p2HB.getChildren().add(5,penalty2T );

		p1HB.getChildren().add(penalty1);
		p2HB.getChildren().add(penalty2);

	}
	
	public List<TextField> getP1Score(){
		return p1Score;
	}
	
	public List<TextField> getP2Score(){
		return p2Score;
	}
	
	public boolean didP1WinPenalty() {
		return penalty1.isSelected();
	}
	
	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}
	
	public void closeStage() {
		stage.close();
	}
	
	
	
	
	
}

