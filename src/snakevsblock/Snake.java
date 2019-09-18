package snakevsblock;

import javafx.scene.control.Label;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class Snake {
	private int length;                                 
	private ArrayList<Circle> structure;
	//private static head;
	private final int radius=10;
	private final Color colour=Color.GREEN;
	
//	public class Ball extends Circle {
//		
//		
//		public Ball() {
//			this.setRadius(radius);
//			this.setFill(colour);
//		}
//		
//		public Ball(int cx, int cy) {
//			this.setCenterX(cx);
//			this.setCenterY(cy);
//			this.setRadius(radius);
//			this.setFill(colour);
//			
//		}
//	}

	
	
	public Snake() {
		this.length=5;
		this.structure = new ArrayList<Circle>(length);
//		Label l = new Label(String.valueOf(this.length));
//		l.setFont(new Font("Cambria",15));
//		l.setLayoutX(147);
//		l.setLayoutY(280);
//		this.structure.getChildren().add(l);
		this.addBalls(this.length);
	}
	
	public void addBalls(int n) {
		for(int i=0;i<n;i++) {
			Circle bb = new Circle();
			bb.setCenterX(150);
			bb.setCenterY(310 + 20*i);
			bb.setRadius(radius);
			bb.setFill(colour);
			this.structure.add(bb);
		}
	}
	
	public void removeBalls(int n) {
		for(int i=this.structure.size();i>n;i--) {
			this.structure.remove(i);
		}
	}
	
	public void moveLeft() {	
		int i=0;
		while (i<this.length) {
			{
				Circle b = (Circle) this.structure.get(i);
				b.setCenterX(b.getCenterX()-6);
			}
			i++;
		}
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList<Circle> getStructure() {
		return structure;
	}

	public void setStructure(ArrayList<Circle> structure) {
		this.structure = structure;
	}

	public void moveRight() {	
		int i=0;
		while (i<this.length) {
			Circle b = (Circle) this.structure.get(i);
			b.setCenterX(b.getCenterX()+6);
			i++;
		}
	}
	
}
