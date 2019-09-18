package snakevsblock;

import java.util.Random;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.layout.Pane;


public class Block {
	private StackPane structure;
	private static int length=60;
	private static int width=60;
	private static Color[] colours= {Color.ORANGE,Color.RED,Color.VIOLET,Color.BROWN,Color.YELLOW,Color.CORNSILK};
	private int value;
	Rectangle rect;
	
	public Block(int x,int y,Group g) {
		this.structure = new StackPane();
		this.rect = new Rectangle();
		rect.setWidth(width);
		rect.setHeight(length);
		rect.setX(x);
		rect.setY(y);
		Random r = new Random();
		int n = r.nextInt(6);
		rect.setFill(colours[n]);
		this.value=this.assignValue();
		Text text = createText(String.valueOf(this.value));
		this.structure.getChildren().addAll(rect,text);
		this.structure.setLayoutX(x);
		this.structure.setLayoutY(y);
		g.getChildren().add(this.structure);
	}
	
	public StackPane getStructure() {
		return structure;
	}

	public void setStructure(StackPane structure) {
		this.structure = structure;
	}

	private Text createText(String string) {
        Text text = new Text(string);
        text.setStyle(
                "-fx-font-family: \"Comic Sans\";" +
                "-fx-font-size: 36px;"
        );
        text.setTextAlignment(TextAlignment.CENTER);
        return text;
    }
	
	private int assignValue() {
		Random r = new Random();
		return r.nextInt(40)+1;
	}
	
	public void burst() {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), this.structure);
	    ft.setFromValue(1.0);
	    ft.setToValue(0);
	    ft.setAutoReverse(false);
	    ft.play();
	}
	
}


