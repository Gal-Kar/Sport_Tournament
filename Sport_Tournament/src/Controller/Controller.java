package Controller;
import Model.*;
import View.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Controller {
	private Model theModel;
	private MainWindow theView;


	public Controller(Model m, MainWindow v) {
		theModel=m;
		theView=v;
		EventHandler<ActionEvent>EventToAddParticepent=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canAddParticepent(theView.textFieldInput())) {
					String name=theModel.addParticepent(theView.getParticepentCounter(), theView.textFieldInput());
					theView.addParticepent(name);
				}
				else {
					if(theModel.isFull()) 
						theView.erorWindow("can't add more players!");
					else
						theView.erorWindow("this name already exist!");
				}
			}
		};
		theView.addEventToAddParticepent(EventToAddParticepent);//Event to add particepent member Button


		EventHandler<ActionEvent>EventToStartChempionship=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				theModel.loadInfo(theView.GetParticeList(), theView.getGame());
				startChempionship();
			}
		};
		theView.addEventToStartChempionship(EventToStartChempionship);//Event to add particepent member Button

	}

	public void startChempionship() {
		Championship chempionship=new Championship(new Stage(),theView.GetParticeList());

		EventHandler<ActionEvent>EventToPlay11=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(1, 0),chempionship.getTextFieldString(1, 1))) {
					game(theModel.getP1Name(0),theModel.getP2Name(0),chempionship,10);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay11(EventToPlay11);

		EventHandler<ActionEvent>EventToPlay12=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(1, 2),chempionship.getTextFieldString(1, 3))) {
					game(theModel.getP1Name(1),theModel.getP2Name(1),chempionship,11);;
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay12(EventToPlay12);

		EventHandler<ActionEvent>EventToPlay13=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(1, 4),chempionship.getTextFieldString(1, 5))) {
					game(theModel.getP1Name(2),theModel.getP2Name(2),chempionship,12);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay13(EventToPlay13);

		EventHandler<ActionEvent>EventToPlay14=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(1, 6),chempionship.getTextFieldString(1, 7))) {
					game(theModel.getP1Name(3),theModel.getP2Name(3),chempionship,13);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay14(EventToPlay14);

		EventHandler<ActionEvent>EventToPlay21=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(2, 0),chempionship.getTextFieldString(2, 1))) {
					game(chempionship.getTextFieldString(2, 0),chempionship.getTextFieldString(2, 1),chempionship,20);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay21(EventToPlay21);

		EventHandler<ActionEvent>EventToPlay22=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(2, 2),chempionship.getTextFieldString(2, 3))) {
					game(chempionship.getTextFieldString(2, 2),chempionship.getTextFieldString(2, 3),chempionship,21);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay22(EventToPlay22);

		EventHandler<ActionEvent>EventToPlay31=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(theModel.canPlay(chempionship.getTextFieldString(3, 0),chempionship.getTextFieldString(3, 1))) {
					game(chempionship.getTextFieldString(3, 0),chempionship.getTextFieldString(3, 1),chempionship,30);
				}
				else
					theView.erorWindow("cant make this game now");
			}
		};
		chempionship.addEventToPlay31(EventToPlay31);

	}

	public void game(String p1Name,String p2Name,Championship chempionship,int btNum) {


		if(theModel.getSport()=="Tennis") {
			TennisGame game=new TennisGame(new Stage(),p1Name,p2Name);
			EventHandler<ActionEvent>EventToSubmit=new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					int result=theModel.play(p1Name, p2Name, game.getP1Score(),game.getP2Score());

					if(result==3)
						game.openNextTextBox();
					if(result==-1)//invalid input in text field
						theView.erorWindow("Invalid input");
					if(result==-2)  //tie in all 
						theView.erorWindow("Match can't end with tie");
					if(result==-3)
						theView.erorWindow("Match can't end before one player \nreach at least 6 points");
					if(result==-4)
						theView.erorWindow("If player passed the 6 points the other \nplayer need to be one point away");
					if(result==1) {//p1 win
						chempionship.playerWin(theModel.getPlayerByName(p1Name));
						chempionship.disablePlay(btNum);
						game.closeStage();
					}
					if(result==2) { //p2 win
						chempionship.playerWin(theModel.getPlayerByName(p2Name));
						chempionship.disablePlay(btNum);
						game.closeStage();
					}

				}

			};
			game.addEventToSubmit(EventToSubmit);

		}

		if(theModel.getSport()=="Soccer") {
			SoccerGame game=new SoccerGame(new Stage(),p1Name,p2Name);
			EventHandler<ActionEvent>EventToSubmit=new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					int result=theModel.play(p1Name, p2Name, game.getP1Score(), game.getP2Score());
					if(game.isPenaltyTime()) {
						if(game.didP1WinPenalty()) {
							theModel.getLoserAndWinner(p1Name, p2Name);
							chempionship.playerWin(theModel.getPlayerByName(p1Name));
							chempionship.disablePlay(btNum);
							game.closeStage();
						}
						else {
							theModel.getLoserAndWinner(p2Name, p1Name);
							chempionship.playerWin(theModel.getPlayerByName(p2Name));
							chempionship.disablePlay(btNum);
							game.closeStage();
						}
					}
					else {
						if(result==-1)//invalid input in text field
							theView.erorWindow("Invalid input");
						if(result==3) { //tie
							if(game.isExtraTime())
								game.penaltyTime();
							else
								game.extraTime();
						}
						if(result==1) {//p1 win
							chempionship.playerWin(theModel.getPlayerByName(p1Name));
							chempionship.disablePlay(btNum);

							game.closeStage();
						}
						if(result==2) { //p2 win
							chempionship.playerWin(theModel.getPlayerByName(p2Name));
							chempionship.disablePlay(btNum);
							game.closeStage();
						}

					}
				}
			};
			game.addEventToSubmit(EventToSubmit);
		}



		if(theModel.getSport()=="Basketball") {
			BasketballGame game=new BasketballGame(new Stage(),p1Name,p2Name);
			EventHandler<ActionEvent>EventToSubmit=new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					int result=theModel.play(p1Name, p2Name, game.getP1Score(), game.getP2Score());
					if(game.isPenaltyTime()) {
						if(game.didP1WinPenalty()) {
							theModel.getLoserAndWinner(p1Name, p2Name);
							chempionship.playerWin(theModel.getPlayerByName(p1Name));
							game.closeStage();
						}
						else {
							theModel.getLoserAndWinner(p2Name, p1Name);
							chempionship.playerWin(theModel.getPlayerByName(p2Name));
							game.closeStage();
						}
					}
					else {
						if(result==-1)//invalid input in text field
							theView.erorWindow("Invalid input");
						if(result==3) //tie
							game.penaltyTime();
						if(result==1) {//p1 win
							chempionship.playerWin(theModel.getPlayerByName(p1Name));
							game.closeStage();
						}
						if(result==2) { //p2 win
							chempionship.playerWin(theModel.getPlayerByName(p2Name));
							game.closeStage();
						}

					}
				}
			};
			game.addEventToSubmit(EventToSubmit);
		}
	}
	
}

