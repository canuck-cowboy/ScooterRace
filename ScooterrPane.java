import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ScooterrPane extends Pane{
  private double x = 0;
  private double y = 160;
  private Timeline speed;

  
  ScooterrPane(){
	  drawScooter();
	  speed = new Timeline(new KeyFrame(Duration.millis(50), e -> moveScooter()));
	  speed.setCycleCount(Timeline.INDEFINITE);
	
	  
	  
  }
  
  public void drawScooter() {
	  getChildren().clear();	
	  Rectangle rectangle = new Rectangle(x+100, y - 32, 190,25);
	  rectangle.setFill(Color.BLUE);
	  getChildren().add(rectangle);
	    
	  // two arcs
	  Arc arc1 = new Arc(x+100, y-29, 25,10,0,180);
	  arc1.setFill(Color.WHITE);
	  arc1.setStroke(Color.BLUEVIOLET);
	  arc1.setStrokeWidth(7);
	  getChildren().addAll(arc1);
	
	  Arc arc2 = new Arc(x+300, y-29, 25,10,0,180);
	  arc2.setFill(Color.WHITE);
	  arc2.setStroke(Color.BLUEVIOLET);
	  arc2.setStrokeWidth(7);
	  getChildren().addAll(arc2);
	   
	  // wheels
	  Circle wheel1 = new Circle (x +100, y, 30);
	  Rectangle r1 = new Rectangle(x+100, y-33, 5,5);
	  r1.setFill(Color.WHITE); 
	  Circle wheel2 = new Circle (x +300, y, 30);
	  Rectangle r2 = new Rectangle(x+300, y-33, 5,5);
	  r2.setFill(Color.WHITE);
	  wheel1.setFill(Color.WHITE);
	  wheel1.setStroke(Color.BLACK);
	  wheel2.setFill(Color.WHITE);
	  wheel1.setStrokeWidth(8);
	  wheel2.setStroke(Color.BLACK);
	  wheel2.setStrokeWidth(8); 
	  getChildren().addAll(wheel1, wheel2);
	  getChildren().addAll(r1,r2);
	  
	  PathTransition pt1 = new PathTransition();
	  pt1.setNode(r1);
	  pt1.setPath(wheel1);
	  pt1.setDuration(Duration.millis(50));
	  pt1.play();
	  
	  PathTransition pt2 = new PathTransition();
	  pt2.setNode(r2);
	  pt2.setPath(wheel2);
	  pt2.setDuration(Duration.millis(50));
	  pt2.play();
	  // stick
	  Rectangle base = new Rectangle (x+300, y - 135, 10,100);
	  base.setFill(Color.DARKBLUE);
	  getChildren().add(base);
	
	  // handle
	  Rectangle handle = new Rectangle(x+280, y - 140, 50, 8);
	  handle.setRotate(30);
	  handle.setFill(Color.BLACK);
	  getChildren().add(handle);
  }

  
  public void speedUp() {
	  speed.setRate(speed.getRate() + 1);
  }
  public void speedDown() {
	  speed.setRate(speed.getRate() > 0 ? speed.getRate() - 1 : 0);
  }
  
  public void jump() {
	  y -= 20;
  }
  
  public void down () {
	  y += 20;
  }
  
 
  public void moveScooter() {
	  if (x <= getWidth()) {
		  x+= 2;
	  }else {
		  x = -350;
	  }
	  drawScooter();
  }
  
  public void setVelocity(double velocity) {
	if (velocity < 100) {
	 speed.setRate(velocity);
	 }
  }
  
  public void play() {
	  speed.play();
  }
  public void pause() {
	  speed.pause();
  }
}
