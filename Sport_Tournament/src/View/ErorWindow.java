package View;

import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ErorWindow {
	public ErorWindow(Stage stage,String t) {
		Text er=new Text(t);
		er.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		er.setFill(Color.RED);
		VBox vb=new VBox();
		vb.getChildren().add(er);
		vb.setAlignment(Pos.CENTER);
		stage.setTitle("Eror Window");
		Scene scene=new Scene(vb,300,170);
		stage.setScene(scene);
		stage.show();
	}
}
