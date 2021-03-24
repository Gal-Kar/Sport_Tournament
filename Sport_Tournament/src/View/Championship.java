package View;

import javafx.scene.paint.Color;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Model.Player;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.shape.Line;
import javafx.scene.Group;

public class Championship {
	private Scene scene;
	private List<TextField> teams8;
	private List<TextField> teams4;
	private List<TextField> teams2;
	private List<Button> teams8B;
	private List<Button> teams4B;
	private List<Button> teams2B;
	private HBox teamsHB;

	public Championship(Stage stage,List<TextField> particepent) {
		VBox mainVB=new VBox();
		Text titel=new Text("Championship");
		titel.setFont(Font.font("Verdana", FontWeight.BOLD,FontPosture.ITALIC, 40));
		titel.setFill(Color.GOLD);
		titel.setStroke(Color.BLUEVIOLET);

		teams8=new ArrayList<TextField>();
		VBox teams8VB=new VBox();
		textFieldArrayToVBox(teams8VB,teams8,8);
		fillStarters(particepent);

		teams8B=new ArrayList<Button>();
		VBox teams8BVB=new VBox();
		ButtonListToVBox(teams8BVB,teams8B,4);

		teams4=new ArrayList<TextField>();
		VBox teams4VB=new VBox();
		textFieldArrayToVBox(teams4VB,teams4,4);

		teams4B=new ArrayList<Button>();
		VBox teams4BVB=new VBox();
		ButtonListToVBox(teams4BVB,teams4B,2);

		teams2=new ArrayList<TextField>();
		VBox teams2VB=new VBox();
		textFieldArrayToVBox(teams2VB,teams2,2);

		teams2B=new ArrayList<Button>();
		VBox teams2BVB=new VBox();
		ButtonListToVBox(teams2BVB,teams2B,1);


		teamsHB=new HBox();
		teamsHB.getChildren().addAll(teams8VB,teams8BVB,teams4VB,teams4BVB,teams2VB,teams2BVB);

		Group root=new Group();
		addLines(root);

		mainVB.getChildren().addAll(titel,teamsHB);
		mainVB.setMargin(titel,new Insets(0, 0, 40, 0));
		mainVB.setAlignment(Pos.TOP_CENTER);
		root.getChildren().addAll(mainVB);

		stage.setTitle("Tournament time");
		stage.initModality(Modality.APPLICATION_MODAL);
		scene = new Scene(root,1400,700);
		stage.setScene(scene);
		stage.show();
	}	

	public void fillStarters(List<TextField> particepent) {
		for(int i=0;i<particepent.size();i++) {
			teams8.get(i).appendText(particepent.get(i).getText());
		}
	}

	public void addLines(Group root) {
		List<Line> lines=new ArrayList<Line>();
		lines.add(new Line(200,110,270,110));//0
		lines.add(new Line(270,110,270,150));//1
		lines.add(new Line(200,185,270,185));//2
		lines.add(new Line(270,185,270,150));//3
		for(int i=0;i<4;i++) {
			lines.get(i).setStroke(Color.RED);
		}

		lines.add(new Line(200,250,270,250));//4
		lines.add(new Line(270,250,270,300));//5
		lines.add(new Line(200,329,270,329));//6
		lines.add(new Line(270,329,270,300));//7
		for(int i=4;i<8;i++) {
			lines.get(i).setStroke(Color.SADDLEBROWN);
		}

		lines.add(new Line(200,400,270,400));//8
		lines.add(new Line(270,400,270,450));//9
		lines.add(new Line(200,480,270,480));//10
		lines.add(new Line(270,480,270,465));//11
		for(int i=8;i<12;i++) {
			lines.get(i).setStroke(Color.BLUEVIOLET);
		}

		lines.add(new Line(200,540,270,540));//12
		lines.add(new Line(270,540,270,600));//13
		lines.add(new Line(200,617,270,617));//14
		lines.add(new Line(270,617,270,600));//15
		for(int i=12;i<16;i++) {
			lines.get(i).setStroke(Color.DARKGREEN);
		}

		lines.add(new Line(270,160,400,160));//16
		lines.add(new Line(400,160,400,250));//17
		lines.get(16).setStroke(Color.RED);
		lines.get(17).setStroke(Color.RED);

		lines.add(new Line(270,301,400,301));//18
		lines.add(new Line(400,301,400,310));//19
		lines.get(18).setStroke(Color.SADDLEBROWN);
		lines.get(19).setStroke(Color.SADDLEBROWN);

		lines.add(new Line(270,450,320,450));//20
		lines.add(new Line(320,450,320,395));//21
		lines.add(new Line(320,395,370,395));//22
		lines.get(20).setStroke(Color.BLUEVIOLET);
		lines.get(21).setStroke(Color.BLUEVIOLET);
		lines.get(22).setStroke(Color.BLUEVIOLET);

		lines.add(new Line(270,600,390,600));//23
		lines.add(new Line(390,600,390,450));//24
		lines.get(23).setStroke(Color.DARKGREEN);
		lines.get(24).setStroke(Color.DARKGREEN);

		lines.add(new Line(400,250,590,250));//25
		lines.add(new Line(590,250,590,300));//26
		lines.add(new Line(400,315,590,315));//27
		lines.get(25).setStroke(Color.BLUE);
		lines.get(26).setStroke(Color.BLUE);
		lines.get(27).setStroke(Color.BLUE);

		lines.add(new Line(370,395,590,395));//28
		lines.add(new Line(590,395,590,460));//29
		lines.add(new Line(390,460,590,460));//30

		lines.add(new Line(590,315,690,315));//31
		lines.get(31).setStroke(Color.BLUE);

		lines.add(new Line(590,450,680,450));//32
		lines.add(new Line(680,450,680,400));//33

		lines.add(new Line(680,390,900,390));//34
		lines.add(new Line(690,320,900,320));//35
		lines.add(new Line(900,320,900,370));//36
		lines.get(34).setStroke(Color.DARKGOLDENROD);
		lines.get(35).setStroke(Color.DARKGOLDENROD);
		lines.get(36).setStroke(Color.DARKGOLDENROD);

		for(int i=0;i<lines.size();i++) {
			root.getChildren().add(lines.get(i));
		}
	}

	public void textFieldArrayToVBox(VBox vb,List<TextField> Particepent,int size) {
		for(int i=0;i<size;i++) {
			Particepent.add(new TextField());
			Particepent.get(i).setDisable(true);
			Particepent.get(i).setStyle("-fx-opacity: 1;");
			vb.getChildren().add(Particepent.get(i));
			vb.setMargin(Particepent.get(i), new Insets(0,20, 40, 40));
		}
		vb.setAlignment(Pos.CENTER_LEFT);
	}

	public void ButtonListToVBox(VBox vb,List<Button> bt,int size) {
		for(int i=0;i<size;i++) {
			bt.add(new Button("play"));
			vb.getChildren().add(bt.get(i));
			vb.setMargin(bt.get(i), new Insets(57, 10, 57, 5));
		}
		vb.setAlignment(Pos.CENTER_RIGHT);
	}


	public void disablePlay(int btNum) {
		int phase=btNum/10;
		int num=btNum%10;
		if(phase==1)
			teams8B.get(num).setDisable(true);
		if(phase==2)
			teams4B.get(num).setDisable(true);
		if(phase==3)
			teams2B.get(0).setDisable(true);
	}

	public void playerWin(Player p) {
		int phase=p.getGamePlayed();
		if(phase==1) {
			p.setNum(p.getNum()/2);
			teams4.get(p.getNum()).appendText(p.getName());
		}
		if(phase==2){
			p.setNum(p.getNum()/2);
			teams2.get(p.getNum()).appendText(p.getName());
		}
		if(phase==3) {
			VBox winTextVB=new VBox();
			Text winText1= new Text("winner winner chicken \ndinner! \ncongratulation to");
			Text winText2=new Text(p.getName());
			
			winText1.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
			winText1.setFill(Color.DARKGOLDENROD);
			winText1.setStroke(Color.GOLD);
			
			winText2.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
			winText2.setFill(Color.DARKGOLDENROD);
			winText2.setStroke(Color.GOLD);
			winTextVB.setAlignment(Pos.CENTER);
			winTextVB.getChildren().addAll(winText1,winText2);
			teamsHB.getChildren().add(winTextVB);
			
		}

	}

	public String getTextFieldString(int phase,int num) {
		if(phase==1) 
			return teams8.get(num).getText();
		if(phase==2) 
			return teams4.get(num).getText();
		return teams2.get(num).getText();
	}

	public void addEventToPlay11(EventHandler<ActionEvent> event) {
		teams8B.get(0).setOnAction(event);
	}
	public void addEventToPlay12(EventHandler<ActionEvent> event) {
		teams8B.get(1).setOnAction(event);
	}
	public void addEventToPlay13(EventHandler<ActionEvent> event) {
		teams8B.get(2).setOnAction(event);
	}
	public void addEventToPlay14(EventHandler<ActionEvent> event) {
		teams8B.get(3).setOnAction(event);
	}
	public void addEventToPlay21(EventHandler<ActionEvent> event) {
		teams4B.get(0).setOnAction(event);
	}
	public void addEventToPlay22(EventHandler<ActionEvent> event) {
		teams4B.get(1).setOnAction(event);
	}
	public void addEventToPlay31(EventHandler<ActionEvent> event) {
		teams2B.get(0).setOnAction(event);
	}

}




