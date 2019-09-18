// SANKALP AGRAWAL, 2017363
// HARSHIT RAI, 2017152

package snakevsblock;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.util.Duration;
//import snakevsblock.Snake.Ball;
import javafx.scene.shape.Circle;


public class GamePage extends Application {
	
	ArrayList<Block> Blocklist;
	
	GamePage()
	{
		Blocklist=new ArrayList<Block>();
	}
	
	private class TimeHandler implements EventHandler<ActionEvent> {
	    
		@Override
		public void handle(ActionEvent event){
			
	    }	
	} 

	
	//private Timeline timeline;
	
//	public GamePage() {
//		this.timeline = new Timeline();
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.setAutoReverse(false);
//	}
	
	@Override
	public void start(Stage primarystage) {
		primarystage.setTitle("Game");
		Snake snake = new Snake();


		String st[] = {"Restart Game", "Save state of Game and Exit"}; 
		ChoiceBox<String> dropdown = new ChoiceBox<>(FXCollections.observableArrayList(st));
		dropdown.setLayoutX(200);
		dropdown.setLayoutY(1);
		dropdown.setMaxWidth(100);
		
//		MenuItem m1 = new MenuItem("Restart Game");
//		MenuItem m2 = new MenuItem("Save state of Game and Exit");
//		MenuButton dropdown = new MenuButton("Options",null,m1,m2);
//		dropdown.setLayoutX(230);
//		dropdown.setLayoutY(1);

		Label curr_score = new Label("Current score");
		curr_score.setFont(new Font("Cambria",20));
		curr_score.setLayoutX(1);
		curr_score.setLayoutY(1);
		Group fin = new Group(dropdown,curr_score);
		fin.getChildren().addAll(snake.getStructure());
		
		//block2.burst();
		
		EventHandler<KeyEvent> snakemove = new EventHandler<KeyEvent>() {
						
			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
					case LEFT: 
						snake.moveLeft(); 
						break;
					case RIGHT: 
						snake.moveRight(); 
						break;
				}
			}
		};
		
//		Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {		
//			
//			@Override
//			public void handle(ActionEvent e) {
//				if(Blocklist.size()!=0)
//				{
//					for(int i=0;i<Blocklist.size();i++) {
//						if ( snake.getStructure().get(0).getBoundsInParent().intersects(Blocklist.get(i).getStructure().getBoundsInParent()) ) {
//							System.out.println("collided");
//							Blocklist.get(i).burst();
//							}
//						else
//						{
//							System.out.println("not-collided");
//						}
////					System.out.println(snake.getStructure().get(0).getBoundsInParent().intersects(Blocklist.get(i).getStructure().getChildren().get(0).getBoundsInParent()));
//					}
//				}
//				
//			}
//			
//		}));
//		tl.play();
//		tl.setCycleCount(Timeline.INDEFINITE);
		
		Scene scene = new Scene(fin,300,500);
		scene.setOnKeyPressed(snakemove);
		scene.setFill(Color.LIGHTBLUE);
		
//		AnimationTimer timer1 = new AnimationTimer() {
//			private long t=0;
//			
//			@Override
//			public void handle(long now) {
//				//if(now - t>1_000_000) {
//					update(snake);
//				//}
//			}
//		};
//		timer1.start();
	
	
		AnimationTimer timer = new AnimationTimer() {
			private long t=0;
			
			@Override
			public void handle(long now) {
				if(now - t>2_000_000_000) {
					generateBlocks(fin,snake);
					generateWalls(fin,snake,scene,snakemove);
					generateToken(fin);
					generateBallsCoins(fin);
					update(snake);
					t=now;
				}
			}
			
//			public void stop() {
//				for(int i=0;i<fin.getChildren().size();i++) {
//					fin.getChildren().remove(fin.getChildren().get(i));
//				}
//			}
			
		};
		timer.start();
		
		primarystage.setScene(scene);
		primarystage.show();	
	}
	
	public void update(Snake snake) {
		
		if(Blocklist.size()!=0)
			{
				for(int i=0;i<Blocklist.size();i++) {
					if (Blocklist.get(i).getStructure().getBoundsInParent().intersects(snake.getStructure().get(0).getBoundsInParent()) ) {
						System.out.println("collided");
						Blocklist.get(i).burst();
						}
					else
					{
						//System.out.println("not-collided");
					}
				}
			}
	}
	
	public void generateBlocks(Group g,Snake s) {
		Random r = new Random();
		int nb = r.nextInt(3)+3;
		this.Blocklist = new ArrayList<>(nb);
		Circle b = s.getStructure().get(1);
		
		int[] arr_choices = {0,60,120,180,240};
		List<Integer> integers = IntStream.range(0, 5).boxed().collect(Collectors.toList());
		Collections.shuffle(integers);
		
		for(int i=0;i<nb;i++) {
			Block bl = new Block(arr_choices[integers.get(i)],-560,g);
			Blocklist.add(bl);
		}
	
		for(int i=0;i<nb;i++) {
			TranslateTransition translateTransition1 = new TranslateTransition(); 
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(Blocklist.get(i).getStructure()); 
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		
		//g.getChildren().addAll(Blocklist);
				
		//double tempx=b.getCenterX();
//		if(Blocklist.size()==5)
//		{	
//			Block blk0=Blocklist.get(0);
//			Block blk1=Blocklist.get(1);
//			Block blk2=Blocklist.get(2);
//			Block blk3=Blocklist.get(3);
//			Block blk4=Blocklist.get(4);
//	
//			if(b.intersects(blk0.rect.getX(), blk0.rect.getY(), 60, 60))
//				blk0.burst();
//			else if(b.intersects(blk1.rect.getX(), blk1.rect.getY(), 60, 60))
//					blk1.burst();
//			else if(b.intersects(blk2.rect.getX(), blk2.rect.getY(), 60, 60))
//					blk2.burst();
//			else if(b.intersects(blk3.rect.getX(), blk3.rect.getY(), 60, 60))
//					blk3.burst();
//			else if(b.intersects(blk3.rect.getX(), blk3.rect.getY(), 60, 60))
//					blk4.burst();
//		}
//		else if(Blocklist.size()==4)
//		{	
//			Block blk0=Blocklist.get(0);
//			Block blk1=Blocklist.get(1);
//			Block blk2=Blocklist.get(2);
//			Block blk3=Blocklist.get(3);
//			
//			if(b.intersects(blk0.rect.getX(), blk0.rect.getY(), 60, 60))
//				blk0.burst();
//			else if(b.intersects(blk1.rect.getX(), blk1.rect.getY(), 60, 60))
//					blk1.burst();
//			else if(b.intersects(blk2.rect.getX(), blk2.rect.getY(), 60, 60))
//					blk2.burst();
//			else if(b.intersects(blk3.rect.getX(), blk3.rect.getY(), 60, 60))
//					blk3.burst();
//		}
//		else
//		{	
//			Block blk0=Blocklist.get(0);
//			Block blk1=Blocklist.get(1);
//			Block blk2=Blocklist.get(2);
//			
//			if(b.intersects(blk0.rect.getX(), blk0.rect.getY(), 60, 60))
//				blk0.burst();
//			else if(b.intersects(blk1.rect.getX(), blk1.rect.getY(), 60, 60))
//					blk1.burst();
//			else if(b.intersects(blk2.rect.getX(), blk2.rect.getY(), 60, 60))
//					blk2.burst();
//		}
	}
	
	
	public void generateWalls(Group g,Snake s,Scene sc,EventHandler<KeyEvent> snakemove) {
		Random r = new Random();
		int nw = r.nextInt(2)+1;
		int[] arr_choices = {0,60,120,180,240};
		ArrayList<Wall> arra = new ArrayList<>(nw);
		List<Integer> integers = IntStream.range(1, 5).boxed().collect(Collectors.toList());
		Collections.shuffle(integers);
		int f=0;
		
		
		for(int i=0;i<nw;i++) {
			Random r2 = new Random();
			int n = r2.nextInt(200)-150-500;
			arra.add(new Wall(arr_choices[integers.get(i)],n));
		}
		for(int i=0;i<nw;i++) {
			TranslateTransition translateTransition1 = new TranslateTransition(); 
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(arra.get(i)); 
			if(arra.get(i).blockpath(s)) {
				f=1;
				sc.removeEventHandler(KeyEvent.ANY, snakemove);
			}
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		g.getChildren().addAll(arra);
		//if(f==1) sc.addEventHandler(KeyEvent.KEY_PRESSED, snakemove);
	}
	
	
	public void generateBallsCoins(Group g) {
		ArrayList<Token> arra = new ArrayList<>();
		Random r = new Random();
		int b = r.nextInt(2)+2;
		int c = r.nextInt(2)+1;
		Random r2 = new Random();
		int[] ex = new int[60];
		for(int i=0;i<60;i++) {
			ex[i] = -560+i;
		}
		for(int i=0;i<b;i++) {
			int x1 = r.nextInt(300);
			int y1 = getRandomWithEx(r,-280-500,280-500,ex);
			arra.add(new Ball_Token(x1,y1));
		}
		for(int i=0;i<c;i++) {
			int x2 = r.nextInt(300);
			int y2 = getRandomWithEx(r,-280-500,280-500,ex);
			arra.add(new Coin(x2,y2));
		}
		
		
		for(int i=0;i<b+c;i++) {
//			KeyValue kv = new KeyValue(arra.get(i).layoutYProperty(), 2000);
//			KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
//			timeline.getKeyFrames().add(kf);
//			//timeline.play();
			TranslateTransition translateTransition1 = new TranslateTransition(); 
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(arra.get(i)); 
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		g.getChildren().addAll(arra);
	}
	
	public void generateToken(Group g) {
		Random r1 = new Random();
		int t = r1.nextInt(4);
		Random r2 = new Random();
		int[] ex = new int[60];
		for(int i=0;i<60;i++) {
			ex[i] = -560+i;
		}
		int x = r2.nextInt(300);
		int y = getRandomWithEx(r2,-280-500,280-500,ex);
		TranslateTransition translateTransition1 = new TranslateTransition();
		if(t==0) {
			Magnet magnet = new Magnet(x,y);
			g.getChildren().add(magnet); 
//			KeyValue kv = new KeyValue(magnet.layoutYProperty(), 2000);
//			KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
//			timeline.getKeyFrames().add(kf);
			//timeline.play();
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(magnet); 
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		
		else if(t==1) {
			Shield shield = new Shield(x,y);
			g.getChildren().add(shield);
//			KeyValue kv = new KeyValue(shield.layoutYProperty(), 2000);
//			KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
//			timeline.getKeyFrames().add(kf);
			//timeline.play();
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(shield); 
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		else if(t==2) {
			Destroy_Token dt = new Destroy_Token(x,y);
			g.getChildren().add(dt);
//			KeyValue kv = new KeyValue(dt.layoutYProperty(), 2000);
//			KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
//			timeline.getKeyFrames().add(kf);
			//timeline.play();
			translateTransition1.setDuration(Duration.millis(10000)); 
			translateTransition1.setNode(dt); 
			translateTransition1.setToY(2000); 
			translateTransition1.play(); 
		}
		else return;
	}

	public int getRandomWithEx(Random rnd, int start, int end, int[] exclude) {
	    int random = start + rnd.nextInt(end - start + 1 - exclude.length);
	    for(int ex=0;ex<exclude.length;ex++) {
	        if (random < exclude[ex]) {
	            break;
	        }
	        random++;
	    }
	    return random;
	}
	
	public void rungame(Group g) {
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false);
		ArrayList<KeyValue> arrakey = new ArrayList<>(); 
		for(int i=3;i<g.getChildren().size();i++) {
			KeyValue kv = new KeyValue(g.getChildren().get(i).layoutYProperty(), 2000);
			arrakey.add(kv);
		}
		KeyValue[] arrkey = new KeyValue[arrakey.size()];
		for(int i=0;i<arrkey.length;i++) {
			arrkey[i] = arrakey.get(i);
		}
		KeyFrame kf = new KeyFrame(Duration.millis(10000),arrkey);
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}
	
	
//	public void rungame(Group g) {
//			TranslateTransition translateTransition1 = new TranslateTransition(); 
//			TranslateTransition translateTransition2 = new TranslateTransition(); 
//		      
//		    translateTransition1.setDuration(Duration.millis(2000)); 
//		    translateTransition2.setDuration(Duration.millis(2000));
//		    
//		    translateTransition1.setNode(this.blocks); 
//		    translateTransition2.setNode(this.walls); 
//		    
//		    translateTransition1.setByY(500); 
//		    translateTransition2.setByY(500'); 
//		    
//		    translateTransition1.setCycleCount(100); 
//		    translateTransition2.setCycleCount(100); 
//		    
//		    translateTransition1.setAutoReverse(false); 
//		    translateTransition2.setAutoReverse(false); 
//		      
//		    translateTransition1.play(); 
//		    translateTransition2.play();
//	}
	
}
