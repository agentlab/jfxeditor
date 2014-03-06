package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.ClassFigure;
import ru.agentlab.jfxed.figures.clazz.ClassArrow;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.Polyline;

public class BootFigures extends Application {
	
	ClassFigure sourceToMove;
	
	double sceneStartX;
	double sceneStartY;
	
	double figureStartTranslateX;
	double figureStartTranslateY;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");

		AnchorPane root = new AnchorPane();
		
		final ClassFigure source = new ClassFigure();
		
		final ClassArrow arrow = new ClassArrow();
		
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		root.getChildren().add(arrow.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 1000, 600);
		//scene.getStylesheets().addAll(ClassFigure.class.getResource("ClassFigure.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Polyline polyline = new Polyline();
	    polyline.getPoints().addAll(new Double[]{
	        0.0, 10.0,
	        40.0, 10.0,
	        40.0, 0.0,
	        70.0, 20.0,
	        40.0, 40.0,
	        40.0, 30.0,
	        0.0, 30.0,
	        0.0, 10.0
	     });
	    
	    root.getChildren().add(polyline);
		
		
		/*source.getRoot().setOnMousePressed(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	            System.out.println("setOnMousePressed");
	            sceneStartX = event.getSceneX();
	            sceneStartY = event.getSceneY();
	            figureStartTranslateX = ((Node) event.getSource()).getTranslateX();
	            figureStartTranslateY = ((Node) event.getSource()).getTranslateY();
	        }
	    });
		
		
		source.getRoot().setOnMouseDragged(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	System.out.println("setOnMouseDragged");
	        	System.out.println(event.getSceneX() + " " + event.getSceneY());
	        	source.getRoot().setTranslateX(figureStartTranslateX + event.getSceneX() - sceneStartX);
	        	source.getRoot().setTranslateY(figureStartTranslateY + event.getSceneY() - sceneStartY);
	        }
	    });*/

	}
}
