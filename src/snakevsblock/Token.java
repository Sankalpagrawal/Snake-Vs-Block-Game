package snakevsblock;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public abstract class Token extends Pane {
	
	protected ImageView image;
	private int x;
	private int y;
	private static int height=25;
	private static int width=25;
	
	public Token(int x,int y) {
		this.image = new ImageView();
		this.image.setX(x);
		this.image.setY(y);
		this.x=x;
		this.y=y;
		this.image.setFitHeight(height); 
		this.image.setFitWidth(width); 
		this.image.setPreserveRatio(true);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public abstract void collect(Snake s);
}
