package ru.agentlab.jfxed.figures;

import ru.agentlab.jfxed.figures.clazz.ClassFigure;
import ru.agentlab.jfxed.figures.clazz.ClassFigure2;
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
		primaryStage.setTitle("Collaboration");

		AnchorPane root = new AnchorPane();
		
		final ClassFigure source = new ClassFigure();
		final ClassFigure2 source2 = new ClassFigure2();
		
		
		root.getChildren().add(source.getRoot());
		root.getChildren().add(new VBox());
		
		root.getChildren().add(source2.getRoot());
		root.getChildren().add(new VBox());

		root.getChildren().add(new VBox());
		
		Scene scene = new Scene(root, 1000, 600);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
				
		
		
	}
}
