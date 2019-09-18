package snakevsblock;

import java.io.FileInputStream;

import javafx.scene.image.Image;

public class Magnet extends Token {

	private int distance;
	
	public Magnet(int x,int y) {
		super(x,y);
		try {
			Image img = new Image(new FileInputStream("C:\\Users\\Sankalp Agrawal\\Desktop\\ProjectImages\\img_magnet.png"));  
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
