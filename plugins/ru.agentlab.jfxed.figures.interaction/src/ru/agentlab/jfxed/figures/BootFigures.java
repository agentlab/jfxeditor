package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.interaction.ClassFigure;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		primaryStage.setTitle("Interaction");

		AnchorPane root = new AnchorPane();
		
		final ClassFigure source = new ClassFigure();
		source.setlabel("Interaction1\n");
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		final ClassFigure source2 = new ClassFigure();
		source2.setlabel("Interaction1\n" + "Interaction2\n");
		root.getChildren().add(source2.getRoot());
		root.getChildren().add(new VBox());
		
		final ClassFigure source3 = new ClassFigure();
		source3.setlabel("Interaction1\n" + "Interaction2\n" + "Interaction3\n");
		root.getChildren().add(source3.getRoot());
		root.getChildren().add(new VBox());
		
		final ClassFigure source4 = new ClassFigure();
		source4.setlabel("Interaction1" + "Interaction2" + "Interaction3");
		root.getChildren().add(source4.getRoot());
		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 800, 800);
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
