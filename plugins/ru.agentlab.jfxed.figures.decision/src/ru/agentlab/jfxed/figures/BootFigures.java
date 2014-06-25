package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.decision.ClassFigure;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class BootFigures extends Application {
	
	ClassFigure sourceToMove;
	
	double sceneStartX;
	double sceneStartY;
	
	double figureStartTranslateX;
	double figureStartTranslateY;
	
	//commit 27.03
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Decision");

		AnchorPane root = new AnchorPane();
		
		final ClassFigure source = new ClassFigure();
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 400, 200);
		//scene.getStylesheets().addAll(ClassFigure.class.getResource("ClassFigure.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
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
