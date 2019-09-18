// SANKALP AGRAWAL, 2017363
// HARSHIT RAI, 2017152

package snakevsblock;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LeaderBoard extends Application {
	
	private final TableView<Data> table = new TableView<>();
    private final ObservableList<Data> tvObservableList = FXCollections.observableArrayList();
	private TableColumn col2;
		
	@Override
	public void start(Stage primarystage) {
		
		Scene scene1 = new Scene(new Group());
		Label heading = new Label("LeaderBoard");
		//table.setEditable(true);
	 
		TableColumn Col1 = new TableColumn("Rank");
        TableColumn Col2 = new TableColumn("Points");
        TableColumn Col3 = new TableColumn("Date");
	    
        table.getColumns().addAll(Col1,Col2,Col3);
	 
        final VBox vbox = new VBox();
       
        vbox.setPadding(new Insets(40,0,0,25));
        vbox.getChildren().addAll(table);
        
        Pane pane = new Pane();
        primarystage.setScene(scene1);
        
		
        
		primarystage.setTitle("LeaderBoard");
		Button btn = new Button("Back");
		
		Group grouping = new Group(pane); 
		heading.setFont(new Font("Cambria",20));
		
		pane.getChildren().add(btn);
		pane.getChildren().add(heading);
		pane.getChildren().add(vbox);
		
		btn.setStyle("-fx-text-fill: #0000ff; -fx-font: 17px Serif");

		btn.setLayoutX(220);
		btn.setLayoutY(450);
		heading.setLayoutX(100);
		heading.setLayoutY(100);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void	handle(ActionEvent event) {	
				main_page mpage = new main_page();
				try {
					mpage.start(primarystage);
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}		
		});
		
		
		Scene scene = new Scene(grouping,300,500);
		scene.setFill(Color.LIGHTBLUE);
		primarystage.setScene(scene);
		primarystage.show();
	}
}
