package snakevsblock;

import java.io.FileInputStream;
import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Ball_Token extends Token {
	
	private int value;
	private StackPane structure;
	
	public Ball_Token(int x,int y) {
		super(x,y);
		this.assignValue();
		try {
			Image img = new Image(new FileInputStream("C:\\Users\\Sankalp Agrawal\\Desktop\\ProjectImages\\img_ball.png"));  
			this.image.setImage(img);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Label l = new Label(String.valueOf(this.value));
		l.setFont(new Font("Cambria",15));
		l.setLayoutX(y);
		l.setLayoutY(x);
		this.structure = new StackPane();
		this.structure.getChildren().addAll(this.image,l);
		this.getChildren().add(this.structure);
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	private void assignValue() {
		Random r = new Random();
		this.value=r.nextInt(15)+1;
	}
	
	@Override
	public void collect(Snake s) {
		
	}
}
