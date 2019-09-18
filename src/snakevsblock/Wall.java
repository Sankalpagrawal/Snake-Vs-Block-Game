package snakevsblock;

import javafx.scene.paint.Color;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Wall extends Rectangle {
	public static Color colour=Color.BLACK;
	public int length;
	public static int width=4;
	
	public Wall(int x,int y) {
		this.assignLength();
		this.setWidth(width);
		this.setFill(colour);
		this.setX(x);
		this.setY(y);
	}
	
	private void assignLength() {
		Random r = new Random();
		this.length = r.nextInt(100)+100;
		this.setHeight(this.length);
	}
	
	public boolean blockpath(Snake s) {
		return (s.getStructure().get(0).intersects(this.getBoundsInLocal())); 
	}

}