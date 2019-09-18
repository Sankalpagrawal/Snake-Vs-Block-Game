// SANKALP AGRAWAL, 2017363
// HARSHIT RAI, 2017152

package snakevsblock;

import javafx.event.*;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class main_page extends Application {
	
	@Override
	public void start(Stage primarystage) throws FileNotFoundException {
		primarystage.setTitle("SnakevsBlock");
		Button btn1 = new Button("Start Game");
		Button btn2 = new Button("LeaderBoard");
		Button btn3 = new Button("Resume Game");
		Label last_score = new Label("Last score here");
		last_score.setFont(new Font("Cambria",20));
		Pane pane = new Pane();
	    
		btn1.setStyle("-fx-text-fill: #0000ff; -fx-font: 17px Serif");
		btn2.setStyle("-fx-text-fill: #0000ff; -fx-font: 17px Serif");
		btn3.setStyle("-fx-text-fill: #0000ff; -fx-font: 17px Serif;");
		Image image = new Image(new FileInputStream("C:\\Users\\Sankalp Agrawal\\Desktop\\ProjectImages\\img1.jpg"));  
	    ImageView imageView = new ImageView(image); 
	     
	    imageView.setX(35); 
	    imageView.setY(85); 
	      
	    imageView.setFitHeight(250); 
	    imageView.setFitWidth(240); 
	    
	    imageView.setPreserveRatio(true);
	    Group grouping = new Group(imageView,pane);  
		
		pane.getChildren().add(btn1);
		pane.getChildren().add(btn2);
		pane.getChildren().add(btn3);
		pane.getChildren().add(last_score);
		
		btn1.setLayoutX(30);
		btn1.setLayoutY(340);
		btn2.setLayoutX(90);
		btn2.setLayoutY(410);
		btn3.setLayoutX(155);
		btn3.setLayoutY(340);
		last_score.setLayoutX(1);
		last_score.setLayoutY(1);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void	handle(ActionEvent event) {	
				GamePage gamepage = new GamePage();
				gamepage.start(primarystage);
			}		
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void	handle(ActionEvent event) {	
				LeaderBoard leaderboard = new LeaderBoard();
				leaderboard.start(primarystage);
			}		
		});
		
		last_score.setOnMouseExited(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
		    	last_score.setScaleX(1);
		    	last_score.setScaleY(2);
		    }
		});
				
		
		Scene scene = new Scene(grouping,300,500);
		scene.setFill(Color.LIGHTBLUE);
		primarystage.setScene(scene);
		primarystage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
