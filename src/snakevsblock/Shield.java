package snakevsblock;

import java.io.FileInputStream;

import javafx.scene.image.Image;

public class Shield extends Token {
	
	private int time;

	public Shield(int x,int y) {
		super(x,y);
		try {
			Image img = new Image(new FileInputStream("C:\\Users\\Sankalp Agrawal\\Desktop\\ProjectImages\\img_shield.png"));  
			this.image.setImage(img);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.getChildren().add(this.image);
	}
	
	@Override
	public void collect(Snake s) {
		
	}
}
