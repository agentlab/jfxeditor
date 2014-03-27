package application;
	
import java.awt.Font;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		try {
			BorderPane root1 = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	
	        Path path2 = new Path();

	        path2.getElements().addAll(
	                new MoveTo(115, 50),
	                new HLineTo(130),
	                new CubicCurveTo(130, 10, 130, 50, 210, 30),
	                new ArcTo(3, 10, 0, 210, 75, true, true)
	               // new CubicCurveTo(130,95,130,60,130,50)
	                );
	        
	        path2.setFill(null);

	        path2.setStroke(Color.RED);

	        path2.setStrokeWidth(2);

	        Path path1 = new Path();

	        path1.getElements().addAll(
	                new MoveTo(130, 50),
	                new CubicCurveTo(130, 100, 130, 65, 210, 75)
	                );
	        
	        path1.setFill(null);

	        path1.setStroke(Color.RED);

	        path1.setStrokeWidth(2);
	        
	        Text text = new Text(143, 50, "Fast[Claims \n Approval]");
	       

	        // show the path shapes;

	        root.getChildren().add(new Group(path1, path2));
	        root.getChildren().add(text);

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
