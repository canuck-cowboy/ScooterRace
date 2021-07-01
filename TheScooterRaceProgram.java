import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class TheScooterRaceProgram extends Application {
	final int numOfScooters = 4;
	 HBox speedRow = new HBox(8);
	 ObservableList<Node> textsFromSpeedRow = speedRow.getChildren();
	 VBox scootersMainBox = new VBox(15);
	 ObservableList<Node> scooters = scootersMainBox.getChildren();
  public void start(Stage ps) {
	  BorderPane borderPane = new BorderPane(); 
	  borderPane.setTop(speedRow);
	  borderPane.setCenter(scootersMainBox);  
	  // drawing the top box
	  for (int i = 0; i < numOfScooters; i++) {
		  speedRow.getChildren().addAll(new Label("Scooter " + (i+1) +  " : "), new TextField());
	  }
	  
	  // add the scooters from the previous ScooterrPane
	  for (int i = 0; i < numOfScooters; i ++) {
		  scootersMainBox.getChildren().add(new ScooterrPane());
	  }
	  // add borders
	  for (int i = 0; i < numOfScooters; i++) {
		  
	  }
	  
	  // take the value from the user
	  for (int i = 1; i < textsFromSpeedRow.size(); i++) {
		  textsFromSpeedRow.get(i).setOnKeyPressed(e -> {
			  if (e.getCode() == KeyCode.ENTER) {
				setSpeed();
			  }
		  });
	  }
	  
	  Scene scene = new Scene(borderPane,1150,880);
	  ps.setScene(scene);
	  ps.setTitle("Scooter Race World Cup");
	  ps.show();
  }

 public static void main(String[] args) {
	  launch(args);
 }

  public void setSpeed() {
	for (int i = 1, j = 0 ; i < textsFromSpeedRow.size(); i += 2, j++) {
		if (   ((TextField) textsFromSpeedRow.get(i)).getText().length() > 0   ){
		  ((ScooterrPane) scooters.get(j)).setVelocity(Double.parseDouble(((TextField) textsFromSpeedRow.get(i)).getText()));
		  ((ScooterrPane) scooters.get(j)).play();
    	}else {
    		((ScooterrPane) scooters.get(j)).pause();
    	}
	}
 } 
}
